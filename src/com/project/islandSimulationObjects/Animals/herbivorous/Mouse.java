package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.IslandSimulation;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
//import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Mouse extends Herbivores {

    public  static volatile int numberBornAnimalsOfParticularSpecies = 0;
    public  static volatile int numberAnimalsOfParticularSpecies = 0;
    public  static volatile int numberDeadAnimalsOfParticularSpecies = 0;
    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Mouse.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Mouse.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Mouse.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    public Mouse(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
        initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_FRUIT,
                BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
                BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES);
        step = BoxCharacteristicsObject.SPEED_MOUSE;
        progenyLimit = 5;
        neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_MOUSE;
        typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_MOUSE;
        typeString = BoxCharacteristicsObject.TYPE_STRING_MOUSE;
        foodStuffs = new CopyOnWriteArrayList<>(initialList);
    }

    public Mouse(int age) {
        super();
        weight = BoxCharacteristicsObject.WEIGHT_MOUSE;
        this.age = age;
    }


    @Override
    public void reproduce() {
        for (int i = 0; i <= 2; i++) {
            super.reproduce();
        }
    }


}
