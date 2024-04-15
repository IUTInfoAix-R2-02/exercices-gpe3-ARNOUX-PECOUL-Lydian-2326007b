package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import static java.io.File.separator;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {

        // code de l'exercice 1


            BorderPane root = new BorderPane();

            MenuBar menuBar = new MenuBar();

            Menu file = new Menu("File");
            MenuItem n = new MenuItem("New");
            MenuItem open = new MenuItem("Open");
            MenuItem save = new MenuItem("Save");
            MenuItem exit = new MenuItem("Exit");
            file.getItems().addAll(n, open, save, exit);

            Menu edit = new Menu("Edit");
            MenuItem cut = new MenuItem("Cut");
            MenuItem copy = new MenuItem("Copy");
            MenuItem paste = new MenuItem("Paste");
            edit.getItems().addAll(cut, copy, paste);

            menuBar.getMenus().addAll(file, edit, new Menu("Help"));

            root.setTop(menuBar);

            VBox leftBox = new VBox();
            leftBox.setAlignment(Pos.CENTER);
            leftBox.setSpacing(10);

            Label buttonLabel = new Label("Boutons :");

            Button button1 = new Button("Bouton 1");
            Button button2 = new Button("Bouton 2");
            Button button3 = new Button("Bouton 3");
            leftBox.getChildren().addAll(buttonLabel, button1, button2, button3);

            root.setLeft(new HBox(leftBox, new Separator(Orientation.VERTICAL)));


            GridPane grilleFormulaire = new GridPane();
            grilleFormulaire.setAlignment(Pos.CENTER);
            grilleFormulaire.setHgap(10);
            grilleFormulaire.setVgap(10);
            grilleFormulaire.setPadding(new Insets(10));

            grilleFormulaire.addRow(0, new Label("Name:"), new TextField());
            grilleFormulaire.addRow(1, new Label("Email:"), new TextField());
            grilleFormulaire.addRow(2, new Label("Password:"), new TextField());

            HBox bB = new HBox();
            bB.setAlignment(Pos.CENTER);
            bB.setSpacing(10);

            bB.getChildren().addAll(new Button("Submit"), new Button("Cancel"));

            grilleFormulaire.add(bB, 0, 3, 2, 1);

            root.setCenter(grilleFormulaire);

            Label statusLabel = new Label("Ceci est un label de bas de page");
            VBox bas = new VBox(new Separator(Orientation.HORIZONTAL), statusLabel);
            bas.setAlignment(Pos.CENTER);
            root.setBottom(bas);

            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Premier exemple manipulant les conteneurs");
            primaryStage.show();
        }


    public static void main(String[] args) {
        launch(args);

    }
}

