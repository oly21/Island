package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;
import java.util.concurrent.CopyOnWriteArrayList;


public class IslandSimulationDisplay implements Runnable {
    private static volatile IslandSimulationObject[][] islandArray;

    static {

        islandArray = Island.getIslandArray();

    }

    private static IslandSimulationDisplay instance;
    public Island island = Island.getIsland();
    public static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();


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
    }

}
