package com.project.islandSimulationObjects.animals.predators;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Wolf extends Predators {
    public static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public static volatile int numberAnimalsOfParticularSpecies = 0;
    public static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Wolf(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        step = BoxCharacteristicsObject.SPEED_WOLF;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_WOLF;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_WOLF;
        typeString = BoxCharacteristicsObject.TYPE_STRING_WOLF;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_WOLF,
                BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.TYPE_STRING_DEER,
                BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.TYPE_STRING_GOAT,
                BoxCharacteristicsObject.TYPE_STRING_DUCK, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR,
                BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
                BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }



    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Wolf.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Wolf.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Wolf.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    protected synchronized void initializationMapChanceToEat() {

        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_GOAT, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_GOAT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_MOUSE);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DEER);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_SHEEP);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DUCK, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DUCK);
    }
}

