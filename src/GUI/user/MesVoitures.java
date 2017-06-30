/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.user;

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
public class MesVoitures {
    
    
    
    private UIBuilder uib;
    
    private Container ctnMesVoiture;
    
    private Form f;
    
    
    private Button btnAjouter;

    public MesVoitures(Resources theme) {
        
        uib = new UIBuilder();
        ctnMesVoiture = uib.createContainer(theme, "VOITURE_GUI");
        f = ctnMesVoiture.getComponentForm();
        btnAjouter = (Button) uib.findByName("btnAjouter", ctnMesVoiture);
        
        initMesVoitures();
        
        
        
        btnAjouter.addActionListener(e->{
            
            AjouterVoiture av = new AjouterVoiture(theme);
            av.ShowForm();
            
            
        });
        
        

        
        
        
        
    }
    
    public void initMesVoitures(){
        
                  ConnectionRequest con = new ConnectionRequest();
                  con.setUrl("http://www.azizxmar.heliohost.org/voitureSelect.php");
        
                con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String rep = new String(con.getResponseData());


         for (Voiture v : getListVoiture(rep)) {
                        
                         System.out.println(v.getMarque());
                         
                      }

            }
            
            
        });
                            NetworkManager.getInstance().addToQueue(con);

    }    
        public ArrayList<Voiture> getListVoiture(String json) {

        ArrayList<Voiture> listVoitures = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> voitures = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) voitures.get("Voiture");

            for (Map<String, Object> obj : list) {
                Voiture v = new Voiture();
                v.setMatricule((obj.get("matricule").toString()));
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
