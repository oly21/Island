package com.project.island;

import com.project.island.Island;

public class IslandSimulationParameters {
    int islandX = 100;
    int islandY = 100;
    int initialNumberAnimals = 5;


    //Island island = new Island(islandX, islandY, initialNumberAnimals);
    int DurationSimulationCycle = 20;
    String simulationStopCondition;
    int progeny = 10;

    public void setProgeny(int progeny) {
        this.progeny = progeny;

    }

    public  void setSimulationStopCondition(String simulationStopCondition) {
        this.simulationStopCondition = simulationStopCondition;

    }

    public  void setDurationSimulationCycle(int setDurationSimulationCycle) {
        this.DurationSimulationCycle = DurationSimulationCycle;

    }


    public  void setIslandX(int islandX) {
        this.islandX = islandX;

    }

    public  void setIslandY(int islandY) {
        this.islandY = islandY;

    }

    public  void setInitialNumberAnimals(int initialNumberAnimals) {
        this.initialNumberAnimals = initialNumberAnimals;

    }



}
