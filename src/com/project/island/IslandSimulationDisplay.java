package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import java.util.concurrent.CopyOnWriteArrayList;


public class IslandSimulationDisplay implements Runnable {
    private static volatile Cell[][] islandArray;

    static {

        islandArray = IslandMap.getIslandArray();

    }
    private static IslandSimulationDisplay instance;
    public IslandMap island = IslandMap.getIsland();
    public static CopyOnWriteArrayList<Animal> animals = IslandMap.getAnimalList();

    private IslandSimulationDisplay() {

    }
    public static IslandSimulationDisplay getIslandSimulation() {
        if (instance == null) {
            instance = new IslandSimulationDisplay();
        }
        return instance;
    }

    public synchronized void run() {
        synchronized (System.out) {
            synchronized (islandArray) {
                for (int i = 0; i < islandArray.length; i++) {
                    System.out.println();

                    for (int j = 0; j < islandArray[i].length; j++) {
                        if (islandArray[i][j]!=null && islandArray[i][j].getAnimalsInCellSize()>0 ) {
                            System.out.print(islandArray[i][j].getRandomIslandSimulationObject().getTypePicture() + " ");

                        } else {
                            System.out.print("🟫" + " ");
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
