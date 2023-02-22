package com.project.island;

import com.project.islandSimulationObjects.animals.AnimalLifeCycle;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.plants.PlantGrowth;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.*;

public class StartingIslandSimulation {

    public IslandMap islandMap = IslandMap.getIslandMap();
    public volatile CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = islandMap.getIslandSimulationObjectList();
    public IslandSimulationDisplay islandSimulationDisplay = IslandSimulationDisplay.getIslandSimulation();
    public AnimalLifeCycle animalLifeCycle = AnimalLifeCycle.getAnimalLifeCycle();
    public PlantGrowth plantGrowth = PlantGrowth.getPlantGrowth();
    public PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();
    private static StartingIslandSimulation instance;
    public static ScheduledExecutorService executorScheduledServicePlantGrowth = Executors.newScheduledThreadPool(1);
    public static ScheduledExecutorService executorScheduledServiceDisplay = Executors.newScheduledThreadPool(1);
    public static ScheduledExecutorService executorScheduledServiceAnimalLifeCycle = Executors.newScheduledThreadPool(1);
    public static ScheduledExecutorService executorScheduledServicePrintingIslandSimulationStatistics = Executors.newScheduledThreadPool(1);
    public static ScheduledExecutorService executorScheduledCheckStopConditionOfIslandSimulation = Executors.newScheduledThreadPool(1);
    public CheckingStopConditionOfIslandSimulation checkingStopConditionOfIslandSimulation = CheckingStopConditionOfIslandSimulation.getCheckingStopConditionOfIslandSimulation();

    private StartingIslandSimulation() {

    }

    public static StartingIslandSimulation getIslandSimulation() {
        if (instance == null) {
            instance = new StartingIslandSimulation();
        }
        return instance;
    }

    public void startSimulation() {
        islandMap.listInitialization();
        islandMap.creatListFreeCells();
        islandMap.setInitialPositionsSimulationObjects();

        executorScheduledServiceAnimalLifeCycle.scheduleAtFixedRate(animalLifeCycle, 2, 5, TimeUnit.SECONDS);
        executorScheduledServicePrintingIslandSimulationStatistics.scheduleAtFixedRate(printingIslandSimulationStatistics, 1, 7, TimeUnit.SECONDS);
        executorScheduledServiceDisplay.scheduleAtFixedRate(islandSimulationDisplay, 0, 6, TimeUnit.SECONDS);
        executorScheduledServicePlantGrowth.scheduleAtFixedRate(plantGrowth, 0, 7, TimeUnit.SECONDS);
        executorScheduledCheckStopConditionOfIslandSimulation.scheduleAtFixedRate(checkingStopConditionOfIslandSimulation, 3, 8, TimeUnit.SECONDS);
    }
}