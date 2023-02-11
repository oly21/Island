package com.project.islandSimulationObjects.Animals.predators;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Fox extends Predators {
    public  static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public  static volatile int numberAnimalsOfParticularSpecies = 0;
    public  static volatile int numberDeadAnimalsOfParticularSpecies = 0;

    public Fox(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        step = BoxCharacteristicsObject.SPEED_FOX;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_FOX;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_FOX;
        typeString = BoxCharacteristicsObject.TYPE_STRING_FOX;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_MOUSE,
                BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.TYPE_STRING_DEER,
                BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR,
                BoxCharacteristicsObject.TYPE_STRING_GOAT, BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
                BoxCharacteristicsObject.TYPE_STRING_DUCK);
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }

    public Fox(int age) {
        super();
        this.age = age;
        weight = BoxCharacteristicsObject.WEIGHT_FOX;
    }

    @Override
    protected synchronized void initializationMapChanceToEat() {
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_FOX_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, BoxCharacteristicsObject.PROBABILITY_FOX_EAT_MOUSE);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DEER);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.PROBABILITY_FOX_EAT_HORSE);

    }
    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Fox.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Fox.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Fox.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    }
