package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;




public class Fruit extends Plant {


    public Fruit(int weight, int age) {
        this.weight = weight;
        this.age = age;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_FRUIT;
        typeString = BoxCharacteristicsObject.TYPE_STRING_FRUIT;
    }



}
