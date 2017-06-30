/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.user;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author azizx
 */
public class Home {
    
    
    
    private UIBuilder uib;
    
    private Container ctnHome;
    
    private Form f;
    
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
        

        
        
        
        lblDepart = (Label) uib.findByName("lblDepart", ctnHome);
        
        lblDestination = (Label) uib.findByName("lblDestination", ctnHome);
        
        txtDepart = (TextField) uib.findByName("txtDepart", ctnHome);
        
        txtDestination = (TextField) uib.findByName("txtDestination", ctnHome);

        btnRechercher = (Button) uib.findByName("btnRechercher", ctnHome);
        
        

        f.getToolbar().addCommandToSideMenu("Profile", null, e->{

                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Ajouter Annonce", null, e->{

                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Mes Annonces", null, e->{
                
                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Mes Reservations", null, e->{
                
                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Mes Annonces", null, e->{
                
                    //code
        });
        
        f.getToolbar().addCommandToSideMenu("Logout", null, e->{
                
                    //code
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
    
    
    
}
