package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;



public class PlantLeaves extends Plant {


    public PlantLeaves(int weight, int age) {
        this.weight = weight;
        this.age = age;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_LEAVES;
        typeString = BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES;
    }


    public PlantLeaves(int age) {
        this.age = age;
        weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    }


}



