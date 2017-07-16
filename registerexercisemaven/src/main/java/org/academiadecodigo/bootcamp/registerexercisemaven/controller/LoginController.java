package org.academiadecodigo.bootcamp.registerexercisemaven.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.registerexercisemaven.EmailAlreadyInUse;
import org.academiadecodigo.bootcamp.registerexercisemaven.Navigation;
import org.academiadecodigo.bootcamp.registerexercisemaven.utils.Validate;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.ServiceRegistry;
import org.academiadecodigo.bootcamp.registerexercisemaven.model.User;
import org.academiadecodigo.bootcamp.registerexercisemaven.service.user.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button regButton;

    @FXML
    private Button switchButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userField;

    @FXML
    private Label emailLabel;

    @FXML
    private TextField emailField;

    @FXML
    private Label message;

    @FXML
    private Button loginButton;

    private UserService userService;

    public UserService getService() {
        return userService;
    }


    //methods that deal with input

    @FXML
    void switchClicked(ActionEvent event) {
        if(regButton.isDisabled()){
            regButton.setDisable(false);
            loginButton.setDisable(true);
            emailField.setVisible(true);
            emailLabel.setVisible(true);
            return;
        }
        regButton.setDisable(true);
        loginButton.setDisable(false);
        emailField.setVisible(false);
        emailLabel.setVisible(false);
        }

    @FXML
    void onLogin(ActionEvent event) {
        boolean correctLogin= userService.authenticate(userField.getText(), passwordField.getText());
        if (correctLogin){
            message.setText("Successfully logged in.");
            Navigation.getInstance().loadScreen("afterlogin");
        }else{
            message.setText("Login failed. Are you sure this user exists and his/her password is correct?");
        }
    }

    @FXML
    void onRegister(ActionEvent event) {
        if((!userField.getText().equals("")) && (!passwordField.getText().equals("")) &&
                Validate.isEmail(emailField.getText())) {
            if (userService.findByName(userField.getText()) == null) {
                if(userService.findByEmail(emailField.getText()) == null) {
                    //&& userService.findByEmail(emailField.getText()) == null) {
                    try {
                        userService.addUser(new User(userField.getText(), emailField.getText(), passwordField.getText()));
                    } catch (EmailAlreadyInUse ex) {
                        message.setText("Email is already in use, please provide a different one");
                    }
                    if (userService.findByName(userField.getText()) != null) {
                        message.setText("New user successfully registered!");
                    }
                } else {
                    message.setText("Email already registered. Choose a different one.");
                }
            } else {
                message.setText("Username taken. Please choose a different username.");
            }
        } else{
            message.setText("Invalid username, password and/or email");
        }
    }


    // This method is called by the FXMLLoader when initialization is complete
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize your logic here: all view elements have been loaded;

        userService = (UserService)ServiceRegistry.getInstance().getService("UserService");
    }
}
