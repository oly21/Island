package com.project.islandSimulationObjects.animals.predators;

import com.project.island.BoxCharacteristicsObject;


import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Boa extends Predators {
    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Boa(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        step = BoxCharacteristicsObject.SPEED_BOA;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_BOA;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BOA;
        typeString = BoxCharacteristicsObject.TYPE_STRING_BOA;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_BOA,
                BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);
        foodStuffs = new CopyOnWriteArrayList<>(initialList);

    }



    @Override
    protected synchronized void initializationMapChanceToEat() {
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_FOX, BoxCharacteristicsObject.PROBABILITY_BOA_EAT_FOX);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_BOA_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, BoxCharacteristicsObject.PROBABILITY_BOA_EAT_MOUSE);


    }

    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Boa.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Boa.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Boa.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }
}

