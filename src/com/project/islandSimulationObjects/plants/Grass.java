package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;


public class Grass extends Plant {
    public Grass(int weight, int age) {
        this.weight = weight;
        this.age = age;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_Grass;
        typeString = BoxCharacteristicsObject.TYPE_STRING_GRASS;
    }
}
