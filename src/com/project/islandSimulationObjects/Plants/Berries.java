package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
//import javafx.scene.control.Label;



public class Berries  extends Plant {

    private String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BERRIES;
   // public Label label = new Label(typePicture);
    private String typeString = BoxCharacteristicsObject.TYPE_STRING_BERRIES;
    private int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    private int age;
    private volatile int x;
    private volatile int y;

    public Berries(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    //@Override
   // public Label getLabel() {
  //      return label;
  //  }

    public Berries(int age) {
        super();
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




    @Override
    public void run() {

    }

}