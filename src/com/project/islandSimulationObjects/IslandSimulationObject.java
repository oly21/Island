package com.project.islandSimulationObjects;


import java.util.concurrent.Callable;


public interface IslandSimulationObject extends Callable<Void> {

    int getNumberBornAnimalsOfParticularSpecies();

    void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies);

    int getNumberAnimalsOfParticularSpecies();

    void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies);

    int getNumberDeadAnimalsOfParticularSpecies();

    void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies);

    String getTypePicture();

    String getTypeString();

    void setXY(int x, int y);

    int getX();

    int getY();

    int getWeight();

    int getAge();

    void setAge(int age);
}