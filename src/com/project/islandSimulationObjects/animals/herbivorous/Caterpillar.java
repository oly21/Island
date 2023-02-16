package com.project.islandSimulationObjects.animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Caterpillar extends Herbivores {
    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Caterpillar(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.STRING_TYPE_PICTURE_Grass);
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
        step = BoxCharacteristicsObject.SPEED_CATERPILLAR;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_CATERPILLAR;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_CATERPILLAR;
        typeString = BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR;

    }



    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Caterpillar.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Caterpillar.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Caterpillar.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }
}