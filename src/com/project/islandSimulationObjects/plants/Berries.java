package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;


public class Berries extends Plant {


    public Berries(int weight, int age) {
        super();
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BERRIES;
        typeString = BoxCharacteristicsObject.TYPE_STRING_BERRIES;
        this.weight = weight;
        this.age = age;
    }


}