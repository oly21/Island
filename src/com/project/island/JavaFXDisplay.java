package com.project.island;
import com.project.Solution;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public class JavaFXDisplay   extends Application implements  Runnable {
        public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;

        public static volatile CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
        public static volatile IslandSimulationObject[][] islandArray;

        static {

                        islandArray = Island.getIslandArray();

        }


        @Override
        public void start(Stage stage) throws Exception {
                Pane root = new Pane();






                stage.setWidth(500);
                stage.setHeight(500);
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000.0 / 420.0), event -> {
                        for (int i = 0; i < islandSimulationObjects.size(); i++) {
                                if (islandSimulationObjects.get(i).getX() != -1) {




                                        int x = islandSimulationObjects.get(i).getX();

                                       // islandSimulationObjects.get(i).getLabel().setLayoutX(islandSimulationObjects.get(i).getX());
                                      //  islandSimulationObjects.get(i).getLabel().setLayoutY(islandSimulationObjects.get(i).getY());

                                       // root.getChildren().add(islandSimulationObjects.get(i).getLabel());
                                }
                        }

                }));
                timeline.setCycleCount(Animation.INDEFINITE);
                timeline.play();
                Scene scene = new Scene(root, 800, 600);
                stage.setScene(scene);
                stage.show();




                stage.show();
        }




        @Override
        public void run() {
                Application.launch();
        }
}