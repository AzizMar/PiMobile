/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.user;

import Entities.Utility;
import Entities.Voiture;
import com.codename1.components.ImageViewer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author azizx
 */
public class MesMessages {
    
    
    
    private UIBuilder uib;
    
    private Container ctnMesVoiture;
    
    private Form f;
    

    private Button btnAjouter;

    public MesMessages(Resources theme) {
        
        uib = new UIBuilder();
        ctnMesVoiture = uib.createContainer(theme, "MESSAGES_GUI");
        f = ctnMesVoiture.getComponentForm();
        btnAjouter = (Button) uib.findByName("btnAjouter", ctnMesVoiture);
        Container cm = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        
        initMesMessages();
        
        
        
        btnAjouter.addActionListener(e->{
            
            AjouterVoiture av = new AjouterVoiture(theme);
            av.ShowForm();
            
            
        });
        
        

        
        
        
    }
    
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

    //JSON PARSER
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
    
    
    
    public UIBuilder getUib() {
        return uib;
    }
    public void setUib(UIBuilder uib) {
        this.uib = uib;
    }
    public Container getCtnMesVoiture() {
        return ctnMesVoiture;
    }
    public void setCtnMesVoiture(Container ctnMesVoiture) {
        this.ctnMesVoiture = ctnMesVoiture;
    }
    public Form getF() {
        return f;
    }
    public void setF(Form f) {
        this.f = f;
    }
    public Button getBtnAjouter() {
        return btnAjouter;
    }
    public void setBtnAjouter(Button btnAjouter) {
        this.btnAjouter = btnAjouter;
    }
    
    
    
}
