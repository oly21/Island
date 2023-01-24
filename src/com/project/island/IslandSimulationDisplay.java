package com.project.island;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class IslandSimulationDisplay implements Runnable {
    private static volatile IslandSimulationObject[][] islandArray;

    static {

        islandArray = Island.getIslandArray();

    }

    private static IslandSimulationDisplay instance;
    public Island island = Island.getIsland();

    public static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    // public static CopyOnWriteArrayList<Animal> animalsCopy = new CopyOnWriteArrayList<>();

    private IslandSimulationDisplay() {

    }

    public static IslandSimulationDisplay getIslandSimulation() {
        if (instance == null) {
            instance = new IslandSimulationDisplay();
        }
        return instance;
    }

    // @Override
    //   public void run() {
    //   animalsCopy.addAll(animals);
    //  ExecutorService executorService = Executors.newFixedThreadPool(animals.size() - 1);
    //  System.out.println("start");


    // for (Runnable task : animalsCopy) {


    // executorService.submit(task);


    // }


    public synchronized void run() {
        synchronized (System.out) {
            synchronized (islandArray) {
                for (int i = 0; i < islandArray.length; i++) {
                    System.out.println();

                    for (int j = 0; j < islandArray[i].length; j++) {
                        if (islandArray[i][j] != null) {
                            System.out.print(islandArray[i][j].getTypePicture() + " ");

                        } else {
                            System.out.print("🟫" + " ");
                        }
                    }

                }
                System.out.println();


            }

        }


        //try {    java.awt.Robot robot=new java.awt.Robot();
        //  robot.mouseMove(0,0); }

        // catch (java.lang.Exception e) {   }
    }

}
