/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.visiteur;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author azizx
 */



public class Login {
    
    
    private UIBuilder uib;
    
    private Container ctnLogin;
    
    private Form f;
    
    private Label lblLogin ;
            
    private Label lblPwd;
            
    private TextField txtLogin;
            
    private TextField txtPwd;
            
    private Button btnLogin;

    
    public Login(Resources theme,Form hv){
        
        uib = new UIBuilder();
        
        uib.registerCustomComponent("ImageViewer", ImageViewer.class);
        
        ctnLogin = uib.createContainer(theme, "LOGIN_GUI");
        
        f = ctnLogin.getComponentForm();
        
        lblLogin = (Label) uib.findByName("lblLogin", ctnLogin);
        lblPwd = (Label) uib.findByName("lblPwd", ctnLogin);
        txtLogin = (TextField) uib.findByName("txtLogin", ctnLogin);
        txtPwd = (TextField) uib.findByName("txtPwd", ctnLogin);
        btnLogin = (Button) uib.findByName("btnLogin", ctnLogin);
        
        
        
                f.getToolbar().addCommandToSideMenu("Register", null, e->{

            Register r = new Register(theme,f);
            r.getF().show();
            
        });
        
        f.getToolbar().addCommandToSideMenu("Back", null, e->{
            
            hv.showBack();

        });
        
        
            
        
        
        
    }
    
    public void showForm(){
        f.show();
    }

    public UIBuilder getUib() {
        return uib;
    }

    public void setUib(UIBuilder uib) {
        this.uib = uib;
    }

    public Container getCtnLogin() {
        return ctnLogin;
    }

    public void setCtnLogin(Container ctnLogin) {
        this.ctnLogin = ctnLogin;
    }

    public Form getForm() {
        return f;
    }

    public void setForm(Form f) {
        this.f = f;
    }

    public Label getLblLogin() {
        return lblLogin;
    }

    public void setLblLogin(Label lblLogin) {
        this.lblLogin = lblLogin;
    }

    public Label getLblPwd() {
        return lblPwd;
    }

    public void setLblPwd(Label lblPwd) {
        this.lblPwd = lblPwd;
    }

    public TextField getTxtLogin() {
        return txtLogin;
    }

    public void setTxtLogin(TextField txtLogin) {
        this.txtLogin = txtLogin;
    }

    public TextField getTxtPwd() {
        return txtPwd;
    }

    public void setTxtPwd(TextField txtPwd) {
        this.txtPwd = txtPwd;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }
    
    
}
