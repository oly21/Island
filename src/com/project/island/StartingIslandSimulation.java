package com.project.island;


import com.project.islandSimulationObjects.animals.AnimalLifeCycle;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.plants.PlantGrowth;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.*;


public class StartingIslandSimulation {
    public IslandMap islandMap = IslandMap.getIslandMap();
    public volatile Cell[][] islandArray = islandMap.getIslandArray();
    public volatile CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = islandMap.getIslandSimulationObjectList();
    public CopyOnWriteArrayList<IslandSimulationObject> tasks = islandSimulationObjects;
    public CopyOnWriteArrayList<IslandSimulationObject> tasksCopy = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Coordinate> freeCells = new CopyOnWriteArrayList<>();
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
        creatListFreeCells();
        setInitialPositionsSimulationObjects();

        executorScheduledServiceAnimalLifeCycle.scheduleAtFixedRate(animalLifeCycle, 2, 5, TimeUnit.SECONDS);
        executorScheduledServicePrintingIslandSimulationStatistics.scheduleAtFixedRate(printingIslandSimulationStatistics, 1, 7, TimeUnit.SECONDS);
        executorScheduledServiceDisplay.scheduleAtFixedRate(islandSimulationDisplay, 0, 6, TimeUnit.SECONDS);
        executorScheduledServicePlantGrowth.scheduleAtFixedRate(plantGrowth, 0, 7, TimeUnit.SECONDS);
        executorScheduledCheckStopConditionOfIslandSimulation.scheduleAtFixedRate(checkingStopConditionOfIslandSimulation, 3, 8, TimeUnit.SECONDS);
    }

    public void setInitialPositionsSimulationObjects() {

        tasksCopy.addAll(tasks);

        for (IslandSimulationObject islandSimulationObject : tasksCopy) {
            int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();
            Coordinate coordinate1 = freeCells.get(coordinate);

            int x = coordinate1.getX();
            int y = coordinate1.getY();

            islandSimulationObject.setXY(x, y);
            islandArray[x][y].addIslandSimulationObject(islandSimulationObject);
            freeCells.remove(coordinate1);
        }
    }


    public void creatListFreeCells() {
        for (int i = 0; i < islandArray.length - 1; i++) {
            for (int j = 0; j < islandArray[i].length - 1; j++) {
                for (int k = 0; k <= 5; k++) {
                    freeCells.add(new Coordinate(i, j));
                }
            }
        }
    }

    public static CopyOnWriteArrayList<Coordinate> getListFreeCells() {
        return freeCells;
    }
}