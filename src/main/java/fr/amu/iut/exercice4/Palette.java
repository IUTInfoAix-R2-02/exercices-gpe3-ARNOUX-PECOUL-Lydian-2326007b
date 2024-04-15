package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.vert = new Button("vert");
        this.rouge = new Button("rouge");
        this.bleu = new Button("bleu");

        this.root = new BorderPane();
        this.label = new Label();
        this.panneau = new Pane();
        this.bas = new HBox();

        bas.setAlignment(Pos.CENTER);

        bas.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            if (nbVert < 2){
                nbVert +=1;
            }
            else{
                panneau.setStyle("-fx-background-color: rgb(0, 182 , 160);");
                label.setText("Vert choisi 3 fois");
                BorderPane.setAlignment(label, Pos.CENTER);
                root.setTop(label);}

        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            panneau.setStyle("-fx-background-color: rgb(255, 80, 50);");
            label.setText("Rouge choisi "  + nbRouge + " fois");
            BorderPane.setAlignment(label, Pos.CENTER);
            root.setTop(label);}

        );
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            if (nbBleu < 2){
                nbBleu +=1;
            }
            else{
                panneau.setStyle("-fx-background-color: rgb(40, 50, 200);");
                label.setText("Bleu choisi " + nbBleu + " fois");
                BorderPane.setAlignment(label, Pos.CENTER);
                root.setTop(label);}

        });

        root.setBottom(bas);

        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

