package com.project.island;

import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.plants.Plant;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private volatile CopyOnWriteArrayList<IslandSimulationObject> animalsInCell = new CopyOnWriteArrayList<>();

    public synchronized int getAnimalsInCellSize() {
        return animalsInCell.size();
    }

    public synchronized void addIslandSimulationObject(IslandSimulationObject islandSimulationObject) {
        if (animalsInCell.size() <= 5 && islandSimulationObject instanceof Animal) {
            animalsInCell.add(islandSimulationObject);
        } else if (animalsInCell.size() <= 5 && islandSimulationObject instanceof Plant) {
            animalsInCell.add(islandSimulationObject);
        }
    }

    public synchronized boolean getIslandSimulationObject(String typeString) {
        for (IslandSimulationObject islandSimulationObject : animalsInCell) {
            if (islandSimulationObject.getTypeString().equals(typeString)) {
                return true;
            }
        }
        return false;
    }


    public synchronized void removeIslandSimulationObject(IslandSimulationObject islandSimulationObject) {

        animalsInCell.remove(islandSimulationObject);
    }

    public synchronized IslandSimulationObject getIslandSimulationObjectIfContains(CopyOnWriteArrayList<String> foodStaffs) {
        for (IslandSimulationObject islandSimulationObject : animalsInCell) {
            if (foodStaffs.contains(islandSimulationObject.getTypeString())) {
                return islandSimulationObject;
            }
        }
        return null;
    }

    public synchronized IslandSimulationObject getRandomIslandSimulationObject() {
        int coordinateIndex = ThreadLocalRandom.current().nextInt(animalsInCell.size()) % animalsInCell.size();

        return animalsInCell.get(coordinateIndex);

    }
}
