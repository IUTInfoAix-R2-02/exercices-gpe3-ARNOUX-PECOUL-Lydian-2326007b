package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    TextField usr;

    @FXML
    PasswordField pwd;

    @FXML
    private void okClicked() {
        System.out.println(usr.getText());
    }

    @FXML
    private void cancelClicked() {
        usr.setText("");
        pwd.setText("");
    }
}