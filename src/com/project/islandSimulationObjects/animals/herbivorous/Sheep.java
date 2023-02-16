package com.project.islandSimulationObjects.animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;


import java.util.Arrays;

import java.util.concurrent.CopyOnWriteArrayList;

public class Sheep extends Herbivores {

    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;


    public Sheep(int weight, int age) {
        super();
        this.age = age;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
                BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
        step = BoxCharacteristicsObject.SPEED_SHEEP;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_SHEEP;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_SHEEP;
        typeString = BoxCharacteristicsObject.TYPE_STRING_SHEEP;
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
        this.weight = weight;
        this.age = age;
    }

    @Override
    public void reproduce() {
        for (int i = 0; i <= 2; i++) {
            super.reproduce();
        }
    }

    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Sheep.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Sheep.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Sheep.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }
}
