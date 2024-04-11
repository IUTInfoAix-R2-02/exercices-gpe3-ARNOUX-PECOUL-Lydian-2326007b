package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static java.io.File.separator;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Button b1 = new Button("hello");

        BorderPane bp = new BorderPane();

        HBox h = new HBox();

        h.setAlignment(Pos.TOP_RIGHT);

        Menu file = new Menu("File");
        Menu edit = new Menu("Edit");
        Menu help = new Menu("Help");

        MenuItem n = new MenuItem("New");
        MenuItem open = new MenuItem("Open");
        MenuItem save = new MenuItem("Save");
        MenuItem close = new MenuItem("Close");

        MenuItem cut = new MenuItem("Cut");
        MenuItem copy = new MenuItem("Copy");
        MenuItem paste = new MenuItem("Paste");

        file.getItems().addAll(n,open,save,close);
        edit.getItems().addAll(cut,copy,paste);

        MenuBar menuBar = new MenuBar();

        menuBar.getMenus().addAll(file, edit, help);

        h.getChildren().add(menuBar);
        bp.getChildren().add(h);

        Button b1 = new Button("b1");
        Button b2 = new Button("b2");
        Button b3 = new Button("b3");

        Scene s1 = new Scene(bp, 200, 200);
        bp.setTop(menuBar);

        primaryStage.setScene(s1);
        primaryStage.show();
        // code de l'exercice 1
    }

    public static void main(String[] args) {
        launch(args);

    }
}

