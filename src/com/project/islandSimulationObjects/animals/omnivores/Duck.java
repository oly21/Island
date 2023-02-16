package com.project.islandSimulationObjects.animals.omnivores;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Duck extends Omnivores {
    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Duck(int weight, int age) {
        super();
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);
        step = BoxCharacteristicsObject.SPEED_DUCK;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_DUCK;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_DUCK;
        typeString = BoxCharacteristicsObject.TYPE_STRING_DUCK;
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
        this.weight = weight;
        this.age = age;
    }




    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Duck.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Duck.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Duck.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public void reproduce() {
        for (int i = 0; i <= 2; i++) {
            super.reproduce();
        }
    }
}








