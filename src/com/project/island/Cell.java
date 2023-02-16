package com.project.island;

import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.plants.Plant;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private volatile CopyOnWriteArrayList<IslandSimulationObject> IslandSimulationObjecInCell = new CopyOnWriteArrayList<>();

    public synchronized int getIslandSimulationObjecInCellSize() {
        return IslandSimulationObjecInCell.size();
    }

    public synchronized void addIslandSimulationObject(IslandSimulationObject islandSimulationObject) {
        if (IslandSimulationObjecInCell.size() <= 5 && islandSimulationObject instanceof Animal) {
            IslandSimulationObjecInCell.add(islandSimulationObject);
        } else if (IslandSimulationObjecInCell.size() <= 5 && islandSimulationObject instanceof Plant) {
            IslandSimulationObjecInCell.add(islandSimulationObject);
        }
    }

    public synchronized boolean getIslandSimulationObject(String typeString) {
        for (IslandSimulationObject islandSimulationObject : IslandSimulationObjecInCell) {
            if (islandSimulationObject.getTypeString().equals(typeString)) {
                return true;
            }
        }
        return false;
    }


    public synchronized void removeIslandSimulationObject(IslandSimulationObject islandSimulationObject) {

        IslandSimulationObjecInCell.remove(islandSimulationObject);
    }

    public synchronized IslandSimulationObject getIslandSimulationObjectIfContains(CopyOnWriteArrayList<String> foodStaffs) {
        for (IslandSimulationObject islandSimulationObject : IslandSimulationObjecInCell) {
            if (foodStaffs.contains(islandSimulationObject.getTypeString())) {
                return islandSimulationObject;
            }
        }
        return null;
    }

    public synchronized IslandSimulationObject getRandomIslandSimulationObject() {
        int coordinateIndex = ThreadLocalRandom.current().nextInt(IslandSimulationObjecInCell.size()) % IslandSimulationObjecInCell.size();

        return IslandSimulationObjecInCell.get(coordinateIndex);

    }
}
