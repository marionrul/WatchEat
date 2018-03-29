/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BL.User;
import Facade.UserFacade;
import Helpers.NavigationHelpers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Polytech
 */
public class FXMLChangePasswordController implements Initializable {

    @FXML
    private TextField newPwd_textField;
    @FXML
    private TextField newPwd2_textField;
    @FXML
    private Button confirm_button;
    private UserFacade uf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.uf = new UserFacade();
        User user = UserFacade.connectedUser;
    }    

    @FXML
    private void clickOnConfirm(ActionEvent event) {
        if(newPwd_textField.getText() == newPwd2_textField.getText()) {
            if(uf.updatePwd(newPwd_textField.getText(), newPwd2_textField.getText()) != null) {
                new NavigationHelpers().changeScene(confirm_button, "HomePage", null);
            }
        }
    }

}