/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.user;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author azizx
 */
public class AjouterVoiture {
    
    
    
    private UIBuilder uib;
    
    private Container ctnAjoutVoiture;
    
    private Form f;
    
    private Label lblMatricule,lblMarque,lblNbPlaces,lblDescription;
    
    private TextField txtMatricule,txtMarque,txtNbPlaces,txtDescription;
    
    private Button btnAjouter;


    public AjouterVoiture(Resources theme) {
        

        uib = new UIBuilder();
        uib.registerCustomComponent("ImageViewer", ImageViewer.class);
        ctnAjoutVoiture = uib.createContainer(theme, "AJOUTER_VOITURE_GUI");
        f = ctnAjoutVoiture.getComponentForm();
        
        lblMatricule = (Label) uib.findByName("lblMatricule", ctnAjoutVoiture);
        
        lblMarque = (Label) uib.findByName("lblMarque", ctnAjoutVoiture);
        
        lblNbPlaces = (Label) uib.findByName("lblNbPlaces", ctnAjoutVoiture);
        
        lblDescription = (Label) uib.findByName("lblDescription", ctnAjoutVoiture);
        
        txtMatricule = (TextField) uib.findByName("txtMatricule", ctnAjoutVoiture);
        
        txtMarque = (TextField) uib.findByName("txtMarque", ctnAjoutVoiture);
        
        txtNbPlaces = (TextField) uib.findByName("txtNbPlaces", ctnAjoutVoiture);
        
        txtDescription = (TextField) uib.findByName("txtDescription", ctnAjoutVoiture);

        btnAjouter = (Button) uib.findByName("btnAjouter", ctnAjoutVoiture);
        
        

        
        f.getToolbar().addCommandToSideMenu("Back", null, e->{
                
            GUI.user.Home hu = new GUI.user.Home(theme);
            hu.ShowForm();
        });
        
        
        btnAjouter.addActionListener(e->{
            
            if (!txtMatricule.getText().equals("") && !txtMarque.getText().equals("") && !txtNbPlaces.getText().equals("") && !txtDescription.getText().equals("") ) {
                
                insertVoiture();
                
            } else {
                
                                            Dialog.show("Erreur", "Erreur insertion", "Ok", null);

            }
            
            
        });
        
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
    
        private void insertVoiture(){
        
                        ConnectionRequest req = new ConnectionRequest();
                req.setUrl("http://www.azizxmar.heliohost.org/voitureInsert.php?matricule=" + txtMatricule.getText() + "&marque=" + txtMarque.getText() + "&nbplaces=" + txtNbPlaces.getText() + "&description=" + txtDescription.getText() + "");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);

                        if (s.equals("success")) {
                            Dialog.show("Confirmation", "Voiture Ajoute", "Ok", null);
                        }
                        else
                        {
                            System.out.println("Add failed");
                        }
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
        
    }
    
}
