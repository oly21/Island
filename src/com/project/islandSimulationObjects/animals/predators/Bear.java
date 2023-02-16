package com.project.islandSimulationObjects.animals.predators;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bear extends Predators {

    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Bear(int weight, int age) {
        super();
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BEAR;
        progenyLimit = 10;
        typeString = BoxCharacteristicsObject.TYPE_STRING_BEAR;
        this.weight = weight;
        this.age = age;
        step = BoxCharacteristicsObject.SPEED_BEAR;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_BEAR;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
                BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
                BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.TYPE_STRING_DUCK,
                BoxCharacteristicsObject.TYPE_STRING_GOAT, BoxCharacteristicsObject.TYPE_STRING_RABBIT,
                BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.TYPE_STRING_MOUSE,
                BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.TYPE_STRING_BOA,
                BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR, BoxCharacteristicsObject.TYPE_STRING_DEER);

        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }



    @Override
    protected synchronized void initializationMapChanceToEat() {
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_BOA, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_BOA);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DEER);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_FOX_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_MOUSE);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_GOAT, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_GOAT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_SHEEP);


    }

    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Bear.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Bear.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Bear.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }
}

