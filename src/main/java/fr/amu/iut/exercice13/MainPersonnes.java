package fr.amu.iut.exercice13;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.List;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static List<? extends Personne> temp;

    private static ListChangeListener<Personne> unChangementListener;

    private static ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList();

        plusieursChangementsListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                change.next();
                boolean vA = change.wasAdded();
                boolean vR = change.wasRemoved();
                if (vA==true){
                    temp = change.getAddedSubList();
                    for (int i = 0; i<change.getAddedSubList().size(); i+=1){
                        System.out.println("Ajouté : " + temp.get(i).getNom());
                    }

                }
                if (vR==true){
                    temp = change.getRemoved();
                    for (int i = 0; i<temp.size(); i+=1){
                        System.out.println("Supprimé : " + temp.get(i).getNom());
                    }
                }
            }
        };

        lesPersonnes.addListener(plusieursChangementsListener);
        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

