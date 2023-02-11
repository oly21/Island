package com.project.islandSimulationObjects.Plants;


import com.project.island.BoxCharacteristicsObject;

public class Vegetables extends Plant {


    public Vegetables(int weight, int age) {
        this.weight = weight;
        this.age = age;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_VEGETABLES;
        typeString = BoxCharacteristicsObject.TYPE_STRING_VEGETABLES;
    }

    public Vegetables(int age) {
        this.age = age;
        int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    }

}












