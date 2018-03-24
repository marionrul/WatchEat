package UI;







/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Facade.UserFacade;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alexandre
 */
public class FXMLUILoginController implements Initializable {
    
    private UserFacade uf;

    @FXML
    private TextField inputMail;
    @FXML
    private PasswordField inputPwd;
    @FXML
    private Button btLogIn;
    @FXML 
    private Label labelStatut;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if(event.getSource()==btLogIn){
            if(!inputMail.getText().equals("") && !inputPwd.getText().equals("")){
                if(uf.login(inputMail.getText(),inputPwd.getText())){
                    try {
                        labelStatut.setText("Connected !");
                        Parent truc = FXMLLoader.load(getClass().getResource("FXMLHomePage.fxml"));
                        Scene homePage = new Scene(truc);
                        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        st.setScene(homePage);              
                        st.show();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLUILoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    labelStatut.setText("Fail login.");
                }
                
            }
            else{
                labelStatut.setText("Empty fields !");
            }
        }
   
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uf = new UserFacade();
    }    
    
}