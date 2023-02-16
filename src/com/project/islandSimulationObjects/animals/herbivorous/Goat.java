package com.project.islandSimulationObjects.animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;


public class Goat extends Herbivores {
    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Goat(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        step = BoxCharacteristicsObject.SPEED_GOAT;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_GOAT;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_GOAT;
        typeString = BoxCharacteristicsObject.TYPE_STRING_GOAT;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
                BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }



    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Goat.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Goat.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Goat.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }


}

