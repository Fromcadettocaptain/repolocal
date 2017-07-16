package org.academiadecodigo.bootcamp.registerexercisemaven.controller;

/**
 * Created by codecadet on 23/06/17.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import org.academiadecodigo.bootcamp.registerexercisemaven.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class LogoutController implements Initializable{

    @FXML
    private MenuItem logoutButton;

    @FXML
    void onLogout(ActionEvent event) {
        Navigation.getInstance().back();
    }

    // This method is called by the FXMLLoader when initialization is complete
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // initialize your logic here: all view elements have been loaded

    }

}