package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;


public class Berries extends Plant {


    public Berries(int weight, int age) {
        super();
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BERRIES;
        typeString = BoxCharacteristicsObject.TYPE_STRING_BERRIES;
        this.weight = weight;
        this.age = age;
    }


    public Berries(int age) {
        super();
        weight = BoxCharacteristicsObject.WEIGHT_PLANT;
        this.age = age;

    }


}