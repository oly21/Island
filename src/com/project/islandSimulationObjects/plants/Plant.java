package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;


public abstract class Plant implements IslandSimulationObject  {
    protected String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BERRIES;
    protected   String typeString = BoxCharacteristicsObject.TYPE_STRING_BERRIES;;

    protected int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    protected int age;
    protected volatile int x;
    protected volatile int y;

    public int numberBornAnimalsOfParticularSpecies = 0;
    public int numberAnimalsOfParticularSpecies = 0;
    public int numberDeadAnimalsOfParticularSpecies = 0;

    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return this.numberBornAnimalsOfParticularSpecies;
    }


    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        this.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return this.numberAnimalsOfParticularSpecies;
    }


    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        this.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return this.numberDeadAnimalsOfParticularSpecies;
    }


    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        this.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    public int getX() {
        return this.x;
    }


    public int getY() {
        return this.y;
    }

    @Override
    public synchronized void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public synchronized Coordinate getXY() {

        return new Coordinate(x, y);
    }

    public  String getTypePicture(){
        return  this.typePicture;
    }



    public  String getTypeString(){
        return this.typeString;
    }


    public Plant() {

    }
    public void run() {

    }

    @Override
    public Void call() throws Exception {
        return null;
    }
}




