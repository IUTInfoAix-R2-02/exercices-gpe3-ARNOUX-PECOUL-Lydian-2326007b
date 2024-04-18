package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static javafx.scene.paint.Color.rgb;

public class IHMPendu extends Application {

    Dico dico = new Dico();

    private int essais = 0;

    private String mot = dico.getMot();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        GridPane root = new GridPane();
        root.setBackground(Background.fill(rgb(170, 255, 230)));

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(10);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(10);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(10);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setPercentWidth(10);
        ColumnConstraints column5 = new ColumnConstraints();
        column5.setPercentWidth(10);
        ColumnConstraints column6 = new ColumnConstraints();
        column6.setPercentWidth(10);
        ColumnConstraints column7 = new ColumnConstraints();
        column7.setPercentWidth(10);
        ColumnConstraints column8 = new ColumnConstraints();
        column8.setPercentWidth(10);
        ColumnConstraints column9 = new ColumnConstraints();
        column9.setPercentWidth(10);
        ColumnConstraints column10 = new ColumnConstraints();
        column10.setPercentWidth(10);
        root.getColumnConstraints().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10);


        Label vies = new Label("Nombre de vies : " + essais);
        vies.setFont(new Font("Arial", 20));


        TextField lettre = new TextField();

        root.setHgap(5);
        root.setVgap(30);

        lettre.setAlignment(Pos.CENTER_LEFT);

        VBox tot = new VBox();

        root.add(vies, 3, 8, 4, 1);
        //tot.getChildren().add(lettre);
        GridPane.setHalignment(lettre, HPos.RIGHT);
        root.add(lettre, 3, 9,3,1);


        ImageView image = new ImageView("exercice6/pendu0.png");

        //HBox img = new HBox();
        // img.getChildren().add(image);
        //root.getChildren().add(img);

        Scene scene = new Scene(root);

        // A completer

        primaryStage.setScene(scene);


        System.out.println(mot);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
