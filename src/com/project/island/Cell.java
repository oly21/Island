package com.project.island;

import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.plants.Plant;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {
    private volatile CopyOnWriteArrayList<IslandSimulationObject> IslandSimulationObjectInCell = new CopyOnWriteArrayList<>();
    public synchronized int getIslandSimulationObjectInCellSize() {
        return IslandSimulationObjectInCell.size();
    }
    public synchronized void addIslandSimulationObject(IslandSimulationObject islandSimulationObject) {
        if (IslandSimulationObjectInCell.size() <= 5 && islandSimulationObject instanceof Animal) {
            IslandSimulationObjectInCell.add(islandSimulationObject);
        } else if (IslandSimulationObjectInCell.size() <= 5 && islandSimulationObject instanceof Plant) {
            IslandSimulationObjectInCell.add(islandSimulationObject);
        }
    }

    public synchronized boolean getIslandSimulationObject(String typeString) {
        for (IslandSimulationObject islandSimulationObject : IslandSimulationObjectInCell) {
            if (islandSimulationObject.getTypeString().equals(typeString)) {
                return true;
            }
        }
        return false;
    }


    public synchronized void removeIslandSimulationObject(IslandSimulationObject islandSimulationObject) {
        IslandSimulationObjectInCell.remove(islandSimulationObject);
    }

    public synchronized IslandSimulationObject getIslandSimulationObjectIfContains(CopyOnWriteArrayList<String> foodStaffs) {
        for (IslandSimulationObject islandSimulationObject : IslandSimulationObjectInCell) {
            if (foodStaffs.contains(islandSimulationObject.getTypeString())) {
                return islandSimulationObject;
            }
        }
        return null;
    }

    public synchronized IslandSimulationObject getRandomIslandSimulationObject() {
        int coordinateIndex = ThreadLocalRandom.current().nextInt(IslandSimulationObjectInCell.size()) % IslandSimulationObjectInCell.size();
        return IslandSimulationObjectInCell.get(coordinateIndex);
    }
}
