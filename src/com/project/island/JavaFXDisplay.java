package com.project.island;

import com.project.Solution;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;
//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.util.Duration;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/*public class JavaFXDisplay extends Application implements Runnable {
    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;

    public static volatile CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public static volatile IslandSimulationObject[][] islandArray;
    public static volatile CopyOnWriteArrayList<Label> animalsLabel = new CopyOnWriteArrayList<>();
    public static volatile Label[][] LabelArray = new Label[500][500];
   public static  volatile Pane root;
    static {

        islandArray = Island.getIslandArray();

    }

   public static int counter;

    @Override
    public void start(Stage stage) throws Exception {
         root = new Pane();

        stage.setWidth(500);
        stage.setHeight(500);
        //Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {

            if (counter == 0) {
                for (int i = 0; i < islandSimulationObjects.size(); i++) {
                    if (islandSimulationObjects.get(i).getX() != -1) {
                        Label label = new Label(islandSimulationObjects.get(i).getTypePicture());
                        animalsLabel.add(label);
                        LabelArray[islandSimulationObjects.get(i).getX()][islandSimulationObjects.get(i).getY()] =label;
                        //  int x = islandSimulationObjects.get(i).getX();

                        label.setLayoutX(islandSimulationObjects.get(i).getX() * 20);
                        label.setLayoutY(islandSimulationObjects.get(i).getY() * 20);

                        root.getChildren().add(label);
                    }
                }
                counter++;
            }
                for (int i = 0; i < LabelArray.length; i++) {
                    for (int j = 0; j < LabelArray[i].length; j++) {
                        // Label label = new Label(islandSimulationObjects.get(i).getTypePicture());

                        //  int x = islandSimulationObjects.get(i).getX();
                       if(LabelArray[i][j]!= null){
                           LabelArray[i][j].setAccessibleText(LabelArray[i][j].getAccessibleText());
                           LabelArray[i][j].setLayoutX(i * 20);
                           LabelArray[i][j].setLayoutY(j * 20);
                       }


                    }
                      }


          //  }
       // }));

       // timeline.setCycleCount(Animation.INDEFINITE);
        //timeline.play();
        Scene scene = new Scene(root, 1800, 1800);
        stage.setScene(scene);
        stage.show();


    }
    public static   Pane   getRoot() {


        return root;





    }


    public static  Label[][]   getLabelArray1() {


        return LabelArray;





    }
    public static  synchronized  CopyOnWriteArrayList<javafx.scene.control.Label>   getLabelArray() {


        return animalsLabel;





    }
    @Override
    public  synchronized void  run() {
        Application.launch();
    }
}

 */