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



public class IslandSimulation {
    public static volatile IslandSimulationObject[][] islandArray = Island.getIslandArray();


    public volatile static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();

    public volatile static CopyOnWriteArrayList<Plant> plants = new CopyOnWriteArrayList<>();
    public volatile static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.getIslandSimulationObjectList();
    public static Island island = Island.getIsland();

    public static CopyOnWriteArrayList<IslandSimulationObject> tasks = islandSimulationObjects;
    public static CopyOnWriteArrayList<IslandSimulationObject> tasksCopy = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<Coordinate> freeCells = new CopyOnWriteArrayList<>();
    public static IslandSimulationDisplay islandSimulationDisplay = IslandSimulationDisplay.getIslandSimulation();
    public static AnimalLifeCycle animalLifeCycle = AnimalLifeCycle.getAnimalLifeCycle();
    public static PlantGrowth plantGrowth;

    static {
        try {
            plantGrowth = new PlantGrowth();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();
    public static IslandSimulationParameters islandSimulationParameters = new IslandSimulationParameters();
    private static IslandSimulation instance;
   public  static ScheduledExecutorService executorScheduledServicePlantGrowth = Executors.newScheduledThreadPool(0);
   public static ScheduledExecutorService executorScheduledServiceDisplay = Executors.newScheduledThreadPool(0);
    public static ScheduledExecutorService executorScheduledServiceAnimalLifeCycle = Executors.newScheduledThreadPool(1);
   public static ScheduledExecutorService executorScheduledServicePrintingIslandSimulationStatistics = Executors.newScheduledThreadPool(0);
    public static ScheduledExecutorService executorScheduledCheckStopConditionOfIslandSimulation = Executors.newScheduledThreadPool(0);
   public  static CheckingStopConditionOfIslandSimulation checkingStopConditionOfIslandSimulation = CheckingStopConditionOfIslandSimulation.getCheckingStopConditionOfIslandSimulation();
    public static ScheduledExecutorService executorScheduledFX = Executors.newScheduledThreadPool(0);
    //JavaFXDisplay javaFXDisplay  = new  JavaFXDisplay();
    private IslandSimulation() {

    }

    public static IslandSimulation getIslandSimulation() {
        if (instance == null) {
            instance = new IslandSimulation();
        }
        return instance;
    }

    public void startSimulation() throws InterruptedException, InstantiationException, IllegalAccessException {
        island.listInitialization();
        creatListFreeCells();
        setInitialPositionsSimulationObjects();



        // while (freeCells.size() != islandArray.length) {
       // JavaFXDisplay.counter = 0;
     //  executorScheduledFX.submit(javaFXDisplay);
       // executorScheduledFX.scheduleAtFixedRate(javaFXDisplay, 0, 20, TimeUnit.SECONDS);

        executorScheduledServiceAnimalLifeCycle.scheduleAtFixedRate(animalLifeCycle, 10, 10, TimeUnit.SECONDS);


        executorScheduledServicePrintingIslandSimulationStatistics.scheduleAtFixedRate(printingIslandSimulationStatistics, 2, 10, TimeUnit.SECONDS);
        executorScheduledServiceDisplay.scheduleAtFixedRate(islandSimulationDisplay, 1, 10, TimeUnit.SECONDS);
        executorScheduledServicePlantGrowth.scheduleAtFixedRate(plantGrowth, 0, 30, TimeUnit.SECONDS);
        executorScheduledCheckStopConditionOfIslandSimulation.scheduleAtFixedRate(checkingStopConditionOfIslandSimulation, 40, 30, TimeUnit.SECONDS);
       // JavaFXDisplay.counter = 1;


                //  }


        //ExecutorService executorService  = Executors.newFixedThreadPool(1);
        // executorService.submit(animalLifeCycle);
        // executorScheduledServiceDisplay.submit(islandSimulationDisplay);/   executorScheduledServicePlantGrowth.submit(plantGrowth);
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


            // synchronized (islandArray) {
            islandSimulationObject.setXY(x, y);
            islandArray[x][y] = islandSimulationObject;
            //  }
            freeCells.remove(coordinate1);
            //tasksCopy.remove(islandSimulationObject);


        }

    }


    public static void creatListFreeCells() {
        // freeCells.clear();
        for (int i = 0; i < islandArray.length - 1; i++) {
            for (int j = 0; j < islandArray[i].length - 1; j++) {
                // synchronized (islandArray) {
                if (islandArray[i][j] == null) {
                    freeCells.add(new Coordinate(i, j));
                }

                //   }

            }
        }


    }


    public static CopyOnWriteArrayList<Coordinate> getListFreeCells() {

        return freeCells;
    }
}