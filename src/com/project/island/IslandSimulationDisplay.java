package com.project.island;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class IslandSimulationDisplay implements Runnable {
    private  volatile static  IslandSimulationObject[][] islandArray;

    static {

        islandArray = Island.getIslandArray();

    }

    private static IslandSimulationDisplay instance;
    private final Island island = Island.getIsland();

    private volatile static  CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();

    private IslandSimulationDisplay() {

    }

    public static IslandSimulationDisplay getIslandSimulation() {
        if (instance == null) {
            instance = new IslandSimulationDisplay();
        }
        return instance;
    }


    public void run() {
        synchronized (islandArray) {
            for ( int i = 0; i<islandArray.length; i++) {
                System.out.println();

                for ( int j = 0; j<islandArray[i].length; j++) {
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
