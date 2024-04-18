package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;

    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    @Override
    public void start(Stage primaryStage) {


        Obstacle obstacle1 = new Obstacle();

        obstacle1.setFill(Paint.valueOf("Red"));
        obstacle1.setLayoutX(20);
        obstacle1.setLayoutY(20);
        obstacle1.setWidth(100);
        obstacle1.setHeight(120);
        obstacles.add(obstacle1);


        Obstacle obstacle2 = new Obstacle();

        obstacle2.setFill(Paint.valueOf("Green"));
        obstacle2.setLayoutX(300);
        obstacle2.setLayoutY(100);
        obstacle2.setWidth(40);
        obstacle2.setHeight(60);
        obstacles.add(obstacle2);

        root = new BorderPane();

        for (Obstacle obs : obstacles) {
            root.getChildren().add(obs);
        }

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels

        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {

        scene.setOnKeyPressed((KeyEvent event) -> {
            double savedJ1X = j1.getLayoutX();
            double savedJ1Y = j1.getLayoutY();
            double savedJ2X = j2.getLayoutX();
            double savedJ2Y = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case Z:
                    j2.deplacerEnHaut();//j2...... vers le haut;
                    break;
                case UP:
                    j1.deplacerEnHaut();//j1...... vers le haut;
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());//j2...... vers la droite;
                    break;
                case Q:
                    j2.deplacerAGauche();//j2...... vers la gauche;
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());//j2...... vers le bas;
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getWidth());//j2...... vers le haut;
                    break;

            }

            for (Obstacle obs : obstacles) {
                if (j1.estEnCollision(obs)) {
                    j1.setLayoutX(savedJ1X);
                    j1.setLayoutY(savedJ1Y);
                }
                if (j2.estEnCollision(obs)) {
                    j2.setLayoutX(savedJ2X);
                    j2.setLayoutY(savedJ2Y);
                }

                if (j1.estEnCollision(j2))
                    Platform.exit();
            }
        });
    }


}
