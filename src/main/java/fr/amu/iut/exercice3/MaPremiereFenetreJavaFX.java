package fr.amu.iut.exercice3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MaPremiereFenetreJavaFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);

        Label helloLabel = new Label("Bonjour à tous !");
        vbox.getChildren().add( helloLabel );


        Scene scene = new Scene( vbox );

        primaryStage.setScene( scene );

        TextField nameField = new TextField("Veuillez saisir un nom");
        nameField.setMaxWidth(180.0d);
        nameField.setFont( Font.font("Courier", FontWeight.NORMAL, 12) );
        vbox.getChildren().add( nameField );

        Button button = new Button("Dire bonjour");

        vbox.getChildren().add( button );

        button.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            helloLabel.setText( "Bonjour à toi, "+nameField.getText() );
        });

        primaryStage.setTitle("Hello application");
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.show();
    }
}
