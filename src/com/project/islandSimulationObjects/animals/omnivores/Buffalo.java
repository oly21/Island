package com.project.islandSimulationObjects.animals.omnivores;

import com.project.island.BoxCharacteristicsObject;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Buffalo  extends Omnivores {
    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;


    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Buffalo.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Buffalo.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Buffalo.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    public Buffalo(int age) {
        super();
        weight = BoxCharacteristicsObject.WEIGHT_BUFFALO;
        this.age = age;
    }


    public Buffalo(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);
        step = BoxCharacteristicsObject.SPEED_BUFFALO;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_BUFFALO;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BUFFALO;
        typeString = BoxCharacteristicsObject.TYPE_STRING_BUFFALO;
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }

}