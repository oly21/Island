package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
//import javafx.scene.control.Label;


public class Grass extends  Plant {
   public String typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_Grass;
   public String typeString  =  BoxCharacteristicsObject.TYPE_STRING_GRASS;
   private int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
   private int age;
   private volatile int x;
   private volatile int y;
   //public Label label = new Label(typePicture);
   public Grass(int weight, int age) {
      this.weight = weight;
      this.age = age;
   }

 //  @Override
  // public Label getLabel() {
    //  return label;
   //}

   public Grass(int age) {
      this.age = age;

   }

   @Override
   public int getX() {
      return x;
   }

   @Override
   public int getY() {
      return y;
   }

   @Override
   public synchronized void setXY(int x, int y) {
      this.x = x;
      this.y = y;
   }

   @Override
   public int getWeight() {
      return weight;
   }


   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }


   public synchronized Coordinate getXY() {

      return new Coordinate(x, y);
   }

   @Override
   public String getTypePicture() {
      return typePicture;
   }

   @Override
   public String getTypeString() {
      return typeString;
   }



   public void run() {

   }

   @Override
   public Void call() throws Exception {
      return null;
   }
}


