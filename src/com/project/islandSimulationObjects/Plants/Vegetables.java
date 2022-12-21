package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
import javafx.scene.control.Label;



public class Vegetables extends Plant {

    public String typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_VEGETABLES;
    public String typeString  =  BoxCharacteristicsObject.TYPE_STRING_VEGETABLES;

//    public Label label = new Label(typePicture);

    private int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    private int age;
    private volatile int x;
    private volatile int y;

    public Vegetables(int weight, int age) {
        this.weight = weight;
        this.age = age;
    }

    public Vegetables(int age) {
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

   // @Override
   // public Label getLabel() {
   //     return null;
   // }

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



