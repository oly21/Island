package com.project.islandSimulationObjects.animals.omnivores;

import com.project.island.BoxCharacteristicsObject;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Giraffe extends  Omnivores{
    public  static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public  static volatile int numberAnimalsOfParticularSpecies = 0;
    public  static volatile int numberDeadAnimalsOfParticularSpecies = 0;
    public Giraffe(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
                BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
                BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);

        step = BoxCharacteristicsObject.SPEED_GIRAFFE;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_GIRAFFE;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_GIRAFFE;
        typeString = BoxCharacteristicsObject.TYPE_STRING_GIRAFFE;
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }


    public Giraffe(int age) {
        super();
        this.age = age;
        weight = BoxCharacteristicsObject.WEIGHT_GIRAFFE;
    }

    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Giraffe.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Giraffe.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Giraffe.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }






}


