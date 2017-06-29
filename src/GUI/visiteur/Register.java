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
public class Register {
    
    private UIBuilder uib;
    private Container ctnRegister;
    private Form f;
    private Label lblUsername,lblEmail,lblPwd,lblPwdC ;   
    private TextField txtUsername,txtEmail,txtPwd,txtPwdC;            
    private Button btnRegister;
    
    
    
    
    public Register(Resources theme, Form hv){
        
        //init
        uib = new UIBuilder();
        uib.registerCustomComponent("ImageViewer", ImageViewer.class);
        ctnRegister = uib.createContainer(theme, "REGISTER_GUI");
        f = ctnRegister.getComponentForm();
        
        //Label components
        lblUsername = (Label) uib.findByName("lblLogin", ctnRegister);
        lblPwd = (Label) uib.findByName("lblPwd", ctnRegister);
        lblPwd = (Label) uib.findByName("lblPwd", ctnRegister);
        lblPwd = (Label) uib.findByName("lblPwd", ctnRegister);
        
        //Textfield components
        txtUsername = (TextField) uib.findByName("txtUsername", ctnRegister);
        txtEmail = (TextField) uib.findByName("txtEmail", ctnRegister);
        txtPwd = (TextField) uib.findByName("txtPwd", ctnRegister);
        txtPwdC = (TextField) uib.findByName("txtPwdC", ctnRegister);
        
        //Button components
        btnRegister = (Button) uib.findByName("btnRegister", ctnRegister);
        
        
        
        f.getToolbar().addCommandToSideMenu("Login", null, e->{
            
            Login l = new Login(theme,f);
            l.showForm();
           
        });
        
        
        
        f.getToolbar().addCommandToSideMenu("Back", null, e->{
            
            hv.showBack();

        });
    
    }

    public UIBuilder getUib() {
        return uib;
    }

    public void setUib(UIBuilder uib) {
        this.uib = uib;
    }

    public Container getCtnRegister() {
        return ctnRegister;
    }

    public void setCtnRegister(Container ctnRegister) {
        this.ctnRegister = ctnRegister;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Label lblUsername) {
        this.lblUsername = lblUsername;
    }

    public Label getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(Label lblEmail) {
        this.lblEmail = lblEmail;
    }

    public Label getLblPwd() {
        return lblPwd;
    }

    public void setLblPwd(Label lblPwd) {
        this.lblPwd = lblPwd;
    }

    public Label getLblPwdC() {
        return lblPwdC;
    }

    public void setLblPwdC(Label lblPwdC) {
        this.lblPwdC = lblPwdC;
    }

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(TextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public TextField getTxtPwd() {
        return txtPwd;
    }

    public void setTxtPwd(TextField txtPwd) {
        this.txtPwd = txtPwd;
    }

    public TextField getTxtPwdC() {
        return txtPwdC;
    }

    public void setTxtPwdC(TextField txtPwdC) {
        this.txtPwdC = txtPwdC;
    }

    public Button getBtnRegister() {
        return btnRegister;
    }

    public void setBtnRegister(Button btnRegister) {
        this.btnRegister = btnRegister;
    }
}

