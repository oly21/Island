package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import java.util.concurrent.CopyOnWriteArrayList;
import static com.project.island.IslandMap.getIslandMap;

public class IslandSimulationDisplay implements Runnable {
    private volatile Cell[][] islandArray = getIslandMap().getIslandArray();
    private static IslandSimulationDisplay instance;
    public IslandMap island = getIslandMap();
    public static CopyOnWriteArrayList<Animal> animals = getIslandMap().getAnimalList();
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
                        if (islandArray[i][j] != null && islandArray[i][j].getIslandSimulationObjectInCellSize() > 0) {
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
