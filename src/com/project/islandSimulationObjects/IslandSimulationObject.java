package com.project.islandSimulationObjects;

//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.scene.Scene;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//import javafx.scene.control.Label;
//import java.awt.*;
import java.util.concurrent.ConcurrentHashMap;


public interface IslandSimulationObject extends Runnable {
  //int  weight = 0;
  //String typePicture  = "🐻";
  //String typeString  = "IslandSimulationObject";
  //List<String> initialList = Arrays.asList("Rabbit", "Mouse");
  //CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
  ConcurrentHashMap<IslandSimulationObject, Integer> chanceToEat = new ConcurrentHashMap<>();
   String getTypePicture();

   String getTypeString();
   void setXY(int x, int y);
   int getX();


   int getY();
  // Label getLabel();

  int getWeight();



   int getAge();


   void setAge(int age);


}