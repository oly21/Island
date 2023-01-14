package com.project.island;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Animals.AnimalLifeCycle;
import com.project.islandSimulationObjects.Animals.herbivorous.Mouse;
import com.project.islandSimulationObjects.Animals.predators.Fox;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.Plants.Plant;
import com.project.islandSimulationObjects.Plants.PlantGrowth;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class IslandSimulation {
    private static  IslandSimulationObject[][] islandArray = Island.getIslandArray();
    private static  CopyOnWriteArrayList<Coordinate> freeCells = new CopyOnWriteArrayList<>();
    private static  CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.getIslandSimulationObjectList();
    private static final Island island = Island.getIsland();
    private static  CopyOnWriteArrayList<IslandSimulationObject> tasks = islandSimulationObjects;
    private static  CopyOnWriteArrayList<IslandSimulationObject> tasksCopy = new CopyOnWriteArrayList<>();

    private static final IslandSimulationDisplay islandSimulationDisplay = IslandSimulationDisplay.getIslandSimulation();
    private static final AnimalLifeCycle animalLifeCycle = AnimalLifeCycle.getAnimalLifeCycle();
    private static final PlantGrowth plantGrowth = PlantGrowth.getPlantGrowth();
    private static final PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();
    private static final CheckingStopConditionOfIslandSimulation checkingStopConditionOfIslandSimulation = CheckingStopConditionOfIslandSimulation.getCheckingStopConditionOfIslandSimulation();

    private static IslandSimulation instance;
    public static ScheduledExecutorService executorScheduledServicePlantGrowth = Executors.newScheduledThreadPool(0);
    public static ScheduledExecutorService executorScheduledServiceDisplay = Executors.newScheduledThreadPool(0);
    public static ScheduledExecutorService executorScheduledServiceAnimalLifeCycle = Executors.newScheduledThreadPool(1);
    public static ScheduledExecutorService executorScheduledServicePrintingIslandSimulationStatistics = Executors.newScheduledThreadPool(0);
    public static ScheduledExecutorService executorScheduledCheckStopConditionOfIslandSimulation = Executors.newScheduledThreadPool(0);
    public static volatile AtomicInteger DaysCount = new AtomicInteger(0);

    // public static ScheduledExecutorService executorScheduledFX = Executors.newScheduledThreadPool(0);
    //JavaFXDisplay javaFXDisplay  = new  JavaFXDisplay();
    private IslandSimulation() {

    }

    public static IslandSimulation getIslandSimulation() {
        if (instance == null) {
            instance = new IslandSimulation();
        }
        return instance;
    }

    public void startSimulation() {
        island.listInitialization();
        createListFreeCells();
        setInitialPositionsSimulationObjects();


        executorScheduledServiceAnimalLifeCycle.scheduleAtFixedRate(animalLifeCycle, 10, 10, TimeUnit.SECONDS);
        executorScheduledServicePrintingIslandSimulationStatistics.scheduleAtFixedRate(printingIslandSimulationStatistics, 2, 10, TimeUnit.SECONDS);
        executorScheduledServiceDisplay.scheduleAtFixedRate(islandSimulationDisplay, 1, 10, TimeUnit.SECONDS);
        executorScheduledServicePlantGrowth.scheduleAtFixedRate(plantGrowth, 0, 20, TimeUnit.SECONDS);
        executorScheduledCheckStopConditionOfIslandSimulation.scheduleAtFixedRate(checkingStopConditionOfIslandSimulation, 40, 35, TimeUnit.SECONDS);

        //  executorScheduledFX.submit(javaFXDisplay);
        // executorScheduledFX.scheduleAtFixedRate(javaFXDisplay, 0, 20, TimeUnit.SECONDS);
        //ExecutorService executorService  = Executors.newFixedThreadPool(1);
        // executorService.submit(animalLifeCycle);
        // executorScheduledServiceDisplay.submit(islandSimulationDisplay);/   e
        // xecutorScheduledServicePlantGrowth.submit(plantGrowth);
        //executorScheduledServiceAnimalLifeCycle.submit(animalLifeCycle);


        /* Fox fox = new Fox( 5);
            Fox fox1 = new Fox( 5);
            Fox fox2 = new Fox( 5);
            Fox fox3 = new Fox( 5);

            Mouse mouse = new Mouse( 5);
            Mouse mouse1 = new Mouse( 5);
            Mouse mouse2 = new Mouse( 5);
            Mouse mouse3 = new Mouse( 5);
            animals.add(fox);
            animals.add(fox1);
            animals.add(fox2);
            animals.add(fox3);
            animals.add(mouse);
            animals.add(mouse1);
            animals.add(mouse2);
            animals.add(mouse3);

            islandSimulationObjects.add(fox);
            islandSimulationObjects.add(fox1);
            islandSimulationObjects.add(fox2);
            islandSimulationObjects.add(fox3);
            islandSimulationObjects.add(mouse);
            islandSimulationObjects.add(mouse1);
            islandSimulationObjects.add(mouse2);
            islandSimulationObjects.add(mouse3);

               setInitialPositionsSimulationObjects();

            fox.Hunt();
            fox1.Hunt();
            fox2.Hunt();
            fox3.Hunt();
            mouse1.Hunt();
            mouse2.Hunt();
            mouse3.Hunt();


        IslandSimulationDisplay.print();
        PrintingIslandSimulationStatistics.printS();
        */

        // executorScheduledServicePrintingIslandSimulationStatistics.submit(printingIslandSimulationStatistics);
        //}

        //   executorScheduledServiceDisplay.awaitTermination(60, TimeUnit.SECONDS);
        // executorScheduledServiceAnimalLifeCycle.awaitTermination(60, TimeUnit.SECONDS);
        //  executorScheduledServicePlantGrowth.awaitTermination(60, TimeUnit.SECONDS);
        //  executorScheduledServicePrintingIslandSimulationStatistics.awaitTermination(60, TimeUnit.SECONDS);


    }

    public void setInitialPositionsSimulationObjects() {

        tasksCopy.addAll(tasks);

        for (IslandSimulationObject islandSimulationObject : tasksCopy) {
            int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();

            Coordinate coordinate1 = freeCells.get(coordinate);
            int x = coordinate1.getX();
            int y = coordinate1.getY();


            synchronized (islandArray) {
                islandSimulationObject.setXY(x, y);
                islandArray[x][y] = islandSimulationObject;
            }
            freeCells.remove(coordinate1);
            //tasksCopy.remove(islandSimulationObject);


        }

    }


    public static void createListFreeCells() {
        // freeCells.clear();
        for (int i = 0; i < islandArray.length - 1; i++) {
            for (int j = 0; j < islandArray[i].length - 1; j++) {
                synchronized (islandArray) {
                    if (islandArray[i][j] == null) {
                        freeCells.add(new Coordinate(i, j));
                    }

                }

            }
        }


    }


    public static CopyOnWriteArrayList<Coordinate> getListFreeCells() {

        return freeCells;
    }
}