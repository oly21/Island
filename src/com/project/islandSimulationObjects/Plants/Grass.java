package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;


public class Grass extends Plant {


    public Grass(int weight, int age) {
        this.weight = weight;
        this.age = age;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_Grass;
        typeString = BoxCharacteristicsObject.TYPE_STRING_GRASS;
    }


    public Grass(int age) {
        this.age = age;
        weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    }



}
