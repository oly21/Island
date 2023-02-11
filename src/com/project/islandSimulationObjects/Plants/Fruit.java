package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;




public class Fruit extends Plant {


    public Fruit(int weight, int age) {
        this.weight = weight;
        this.age = age;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_FRUIT;
        typeString = BoxCharacteristicsObject.TYPE_STRING_FRUIT;
    }


    public Fruit(int age) {
        this.age = age;
        weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    }




}
