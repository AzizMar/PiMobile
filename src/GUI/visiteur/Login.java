/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.visiteur;

import Entities.User;
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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        
        
            btnLogin.addActionListener((ActionEvent e)->{
                
                ConnectionRequest con = new ConnectionRequest();
                con.setUrl("http://www.azizxmar.heliohost.org/userSelect.php");
        
        
        
        con.addResponseListener((NetworkEvent evt) -> {
            
            String rep = new String(con.getResponseData());
            System.out.println(rep);
                    ArrayList<User> usersList = getListUser(rep);
                    
//                    usersList.forEach(item->{
//                        
//                       
//                        });
                    for (User u : usersList) {
                        
                         System.out.println(u.getPassword());
                         
                          if (u.getUsername().equals(txtLogin.getText()) && u.getPassword().startsWith(txtPwd.getText())) {
                            
                            //  GUI.user.Home uh = new GUI.user.Home();
                        System.out.println("login success²");

                            
                            break;
                        }
                        
                        else{
                            System.out.println("login Failed²");
                        }
                      }
                            
                            
                   System.out.println(usersList.size());
                            
//                System.out.println(getListEtudiant(new String(con.getResponseData())));
//                sp.setText(getListEtudiant(new String(con.getResponseData())) + "");
//                hi.refreshTheme();
//                hi.show();
                });
        NetworkManager.getInstance().addToQueue(con);
                
            });
        
        
        
    }
    
        public ArrayList<User> getListUser(String json) {
        
        ArrayList<User> listUsers = new ArrayList<>();

        try {

            JSONParser j = new JSONParser();
           

            Map<String, Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) users.get("utilisateur");

            for (Map<String, Object> obj : list) {
                User u = new User();
                u.setUsername(obj.get("username").toString());
                u.setEmail(obj.get("email").toString());
                u.setPassword(obj.get("password").toString());
                listUsers.add(u);
              //  System.out.println(obj.get("username").toString());

            }

        } catch (IOException ex) {
         }
        return listUsers;

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
