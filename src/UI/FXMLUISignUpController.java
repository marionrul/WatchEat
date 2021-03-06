/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Facade.UserFacade;
import Helpers.NavigationHelpers;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alexandre
 */
public class FXMLUISignUpController implements Initializable, UIController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField mail_Field;
    @FXML
    private ComboBox<String> gender;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private Button signUpButton;
    @FXML
    private Button cancelButton;
    @FXML
    private PasswordField pwdField;
    private UserFacade uf;
    @FXML
    private Label labelStatut;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uf = new UserFacade(); // TODO
        gender.setItems(FXCollections.observableArrayList("Male", "Female"));
        
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
        if (event.getSource()== signUpButton){
            if(!mail_Field.getText().equals("") && !firstName.getText().equals("")&&!lastName.getText().equals("") && !pwdField.getText().equals("") && !gender.getSelectionModel().getSelectedItem().equals("") && dateOfBirth.getValue()!=null){
                Date date= Date.valueOf(dateOfBirth.getValue());
                if(uf.signUp(mail_Field.getText(),pwdField.getText(),firstName.getText(),lastName.getText(),gender.getSelectionModel().getSelectedItem(),date)){
                     new NavigationHelpers().changeScene(firstName,"HomePage",null);
                }
                else
                {
                   labelStatut.setText("Fail signUp");     
                        }
            }
            else{
                labelStatut.setText("Empty fields !");
            }
        }
        if (event.getSource()== cancelButton){
            new NavigationHelpers().changeScene(firstName,"UILogin",null);
        }
    }

    @Override
    public void receiveData(Object givenData) {
    }
    
}
