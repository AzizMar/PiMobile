/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.user;

import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import Entities.Thread;
import Entities.Utility;
import Entities.Voiture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azizx
 */
public class Home {
    
    
    
    private UIBuilder uib;
    
    private Container ctnHome;
    
    private Form f,annoncesList;
    
    private Image imgHeader;
    
    private Label lblDepart;
    
    private Label lblDestination;
    
    private TextField txtDepart;
    
    private TextField txtDestination;
    
    private Button btnRechercher;
    

    public Home(Resources theme) {
        
        
        
        uib = new UIBuilder();
        
        uib.registerCustomComponent("ImageViewer", ImageViewer.class);
        
        ctnHome = uib.createContainer(theme, "HOME_USER_GUI");
        
        f = ctnHome.getComponentForm();
        Annonces a = new Annonces(theme,annoncesList);


        
        
        
        lblDepart = (Label) uib.findByName("lblDepart", ctnHome);
        
        lblDestination = (Label) uib.findByName("lblDestination", ctnHome);
        
        txtDepart = (TextField) uib.findByName("txtDepart", ctnHome);
        
        txtDestination = (TextField) uib.findByName("txtDestination", ctnHome);

        btnRechercher = (Button) uib.findByName("btnRechercher", ctnHome);
        
        

        f.getToolbar().addCommandToSideMenu("Mes voitures", null, e->{

//            MesVoitures mv = new MesVoitures(theme);
//            mv.getF().show();

            initMesVoitures();


        });
        
        f.getToolbar().addCommandToSideMenu("Mes Messages", null, e->{
                
            System.out.println("mes messages clicked");
            initMesMessages();
              
        });
        
        
        f.getToolbar().addCommandToSideMenu("Ajouter Annonce", null, e->{

                    //code
        });
        
        
        
        //MES ANNONCES
         f.getToolbar().addCommandToSideMenu("Mes Annonces", null, e->{
    
           ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://www.azizxmar.heliohost.org/annoncesSelect.php");
             con.addResponseListener(new ActionListener<NetworkEvent>() {
                 @Override
            public void actionPerformed(NetworkEvent evt) {
                 String ch =new String (con.getResponseData());
             ArrayList<Annonces> l=getListAnnonces(ch);

             
             for (Annonces u : l) {        
//                 System.out.println(u.getId());
//                  System.out.println(u.getUserId());
//                   System.out.println(u.getVoitureId());
//                    System.out.println(u.getDepart());
//                     System.out.println(u.getArrivee());
//                      System.out.println(u.getHeuredepart());
//                       System.out.println(u.getDate());
//                        System.out.println(u.getNbplace());
//                      System.out.println(u.getPrix());
//                      System.out.println(u.getDisponible());
//                     System.out.println(u.getBagages());
//                     System.out.println(u.getAnimal());
//                     System.out.println(u.getFumer());
        Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c2.addPointerDraggedListener(e->{
        
        Form f = new Form();
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        f.add(c);
        c.add(new Label("Nombre de Places  :"+u.getNbplace()));
        if(u.getAnimal().equals(1)){
        c.add(new Label("voyager avec son animal est permis"));
        }
        else
        {c.add(new Label("Il est interdit de voyager avec son animal"));}
        
        if(u.getBagages().equals(1)){
        c.add(new Label("voyager avec Bagages"));
        }
        else
        {c.add(new Label("Uniquement bagages à main est permis "));}
        if(u.getFumer().equals(1)){
        c.add(new Label("Vous pouver Fumer pendant le voyag "));
        }
        else
        {c.add(new Label("Il est strictement interdit de fumer"));}
        
        f.setTitle(u.getPrix()+" Dt"+"     "+u.getHeuredepart()+"H");
        
        Button b =new Button();
        b.setText("Reserver");
       f.show();
       
     
        Command cmdAdd = new Command("Retour");
        
        f.getToolbar().addCommandToRightBar(cmdAdd);
        
        f.addCommandListener(s->{
            a.getListAnnonces().showBack();
        
        });
        });
        c2.add(new Label("Depart :"+u.getDepart()));
        c2.add(new Label("--> "+u.getArrivee()));
        c2.add(new Label("Date: "+u.getDate()));
        c1.add(c2); 
        a.getListAnnonces().add(c1);
         a.getListAnnonces().refreshTheme();
         
                      }
             
                       
                        a.getListAnnonces().show();

            }
        });
               NetworkManager.getInstance().addToQueue(con);
             
             
       });
        
        f.getToolbar().addCommandToSideMenu("Mes Reservations", null, e->{
                
                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Mes Annonces", null, e->{
                
                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Logout", null, e->{
                
                    GUI.visiteur.Home hv = new GUI.visiteur.Home(theme);
                    hv.ShowForm();
        });
        
    }
    
    public ArrayList<Annonces> getListAnnonces(String json) {
 ArrayList<Annonces> listAnnonces = new ArrayList<>();
         JSONParser j = new JSONParser(); 
        try {
            Map<String, Object> annonces = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) annonces.get("annonce");

            for (Map<String, Object> obj : list) {
                Annonces a = new Annonces();
                    a.setId(Integer.parseInt(obj.get("id").toString()));
                    a.setUserId(Integer.parseInt(obj.get("userid").toString()));
                    a.setVoitureId(Integer.parseInt(obj.get("voitureid").toString()));
                    a.setDepart(obj.get("depart").toString());
                    a.setArrivee(obj.get("arrivee").toString());
                    a.setHeuredepart(obj.get("heuredepart").toString());
                    a.setDate(obj.get("date").toString());
                    a.setNbplace(Integer.parseInt(obj.get("nbplace").toString()));
                    a.setPrix(obj.get("prix").toString());
                    a.setDisponible((obj.get("disponible").toString()));
                    a.setBagages(obj.get("bagages").toString());
                    a.setAnimal(obj.get("animal").toString());
                    a.setFumer(obj.get("fumer").toString());
                    a.setDescription(obj.get("description").toString());
                   
                 listAnnonces.add(a);
                
            }

            
        } catch (IOException ex) {
           
        }
         
          return listAnnonces;
         
         }  
    
    
    
///////////////////////////////////////////////////// MESSAGES ////////////////////////////////////////////////////////
    
      public void initMesMessages(){
        
                ConnectionRequest con = new ConnectionRequest();
                con.setUrl("http://www.azizxmar.heliohost.org/threadSelect.php");
                Form fmsg = new Form("Inbox", BoxLayout.y());

        con.addResponseListener((NetworkEvent evt) -> {
            
            String rep = new String(con.getResponseData());
           // System.out.println(rep);
                    ArrayList<Entities.Thread> threadsList = getListThread(rep);
                    

                    for (Entities.Thread t : threadsList) {
                        
                        if (t.created_by_id==Utility.loggedUserId) {
                            
                        
                            System.out.println(t.created_by_id);
                        System.out.println(t.getSubject());
                        
                        Container cmsg = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        
                        Label lblSubject = new Label("Sujet: "+t.getSubject());
                        cmsg.addPointerPressedListener(e->{
                        
                            System.out.println(lblSubject.getText());
                        });
                        cmsg.add(lblSubject);
                        fmsg.add(cmsg);  
                        }           
                    else{
                            System.out.println("Boite Vide");
                        }
                 }       
   
                fmsg.show();

                            
                });

                           NetworkManager.getInstance().addToQueue(con);

    }
    //JSON PARSER Messages
     public ArrayList<Entities.Thread> getListThread(String json) {
        
        ArrayList<Entities.Thread> listThreads = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();
           

            Map<String, Object> threads = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) threads.get("thread");

            for (Map<String, Object> obj : list) {
                Entities.Thread t = new Entities.Thread();
                
                t.setCreatedById(Integer.parseInt(obj.get("created_by_id").toString()));
                t.setSubject(obj.get("subject").toString());
                listThreads.add(t);
              //  System.out.println(obj.get("username").toString());

            }

        } catch (IOException ex) {
         }
        return listThreads;

    }
     
 ///////////////////////////////////////////////////// MESSAGES  END ////////////////////////////////////////////////////////
    
      ///////////////////////////////////////////////////// VOITURES BEGIN ////////////////////////////////////////////////////////

     
     
    
         // VOITURES
      public void initMesVoitures(){
        
        
                  ConnectionRequest con = new ConnectionRequest();
                  con.setUrl("http://www.azizxmar.heliohost.org/voitureSelect.php");
                   Form fvt = new Form("Voitures", BoxLayout.y());
                con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String rep = new String(con.getResponseData());


           for (Voiture v : getListVoiture(rep)) {
                        
                       // if (v.getProprietaire_id()==Utility.loggedUserId) {
                            
                        
                        System.out.println(v.getProprietaire_id());
                        System.out.println(v.getMarque());
                        
                        Container cvt = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        
                        Label lblMatricule = new Label("Matricule: "+v.getMatricule());
                        cvt.addPointerPressedListener(e->{
                        
                            System.out.println(lblMatricule.getText());
                        });
                        cvt.add(lblMatricule);
                        fvt.add(cvt);  
                        //}           
                   // else{
                  //          System.out.println(" Vide");
                  //      }
                 }       
   
                fvt.show();

            }
            
            
        });
                                               NetworkManager.getInstance().addToQueue(con);

    }
    //JSON PARSER Messages
     public ArrayList<Voiture> getListVoiture(String json) {

        ArrayList<Voiture> listVoitures = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> voitures = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) voitures.get("Voiture");

            for (Map<String, Object> obj : list) {
                Voiture v = new Voiture();
                
                        
               // v.setProprietaire_id(Integer.parseInt(obj.get("proprietaire_id").toString())); 
                //v.setProprietaire_id(obj.get("proprietaire_id").toString());
                v.setProprietaire_id(Integer.parseInt(obj.get("proprietaire_id").toString()));
                v.setMarque(obj.get("marque").toString());
                v.setNbPlaces(Integer.parseInt(obj.get("nombreplaces").toString()));
                v.setDescription(obj.get("description").toString());
                System.out.println(obj.get("matricule").toString());
                listVoitures.add(v);

            }

        } catch (IOException ex) {
                       System.out.println("catch");

         }
        return listVoitures;

    }
     
     

    public Form getF() {
        return f;
    }
    
    public void ShowForm(){
        
        f.show();
    }
    
        public void ShowBack(){
        
        f.showBack();
    }
    
           
    
}
