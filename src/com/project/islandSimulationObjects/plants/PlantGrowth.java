package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.Cell;
import com.project.island.IslandMap;
import com.project.island.StartingIslandSimulation;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.CreationIslandSimulationObject;
import com.project.islandSimulationObjects.IslandSimulationObject;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import static com.project.island.IslandMap.getIslandMap;


public class PlantGrowth implements Runnable {
    public IslandMap islandMap = getIslandMap();
    public volatile  CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = islandMap.getIslandSimulationObjectList();

    public static PlantGrowth instance = null;

    public Cell[][] islandArray = islandMap.getIslandArray();
    public static final CopyOnWriteArrayList<Coordinate> freeCells = StartingIslandSimulation.getListFreeCells();

    public List<Plant> plants = islandMap.getPlantList();
    private int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    private int age;
    public static volatile AtomicInteger numbersPlantsGrew = new AtomicInteger(100);
    CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();
    private PlantGrowth() {


    }
    public static PlantGrowth getPlantGrowth() {
        if (instance == null) {

            instance = new PlantGrowth();
        }
        return instance;
    }

    @Override
    public void run() {

        for (Plant plant : plants) {
            weight = plant.getWeight();
            weight++;
            plant.setWeight(weight);
            age = plant.getAge();
            age++;
            plant.setAge(age);
        }

        for (int i = 0; i <= 2; i++) {
            if (freeCells.size() > 0) {
                synchronized (islandArray) {
                    plants.add((Plant)creationIslandSimulationObject.createObject(null,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES));
                    if (freeCells.size() > 0) {
                        plants.add((Plant)creationIslandSimulationObject.createObject(null,BoxCharacteristicsObject.TYPE_STRING_BERRIES));

                    }
                    if (freeCells.size() > 0) {
                        plants.add((Plant)creationIslandSimulationObject.createObject(null,BoxCharacteristicsObject.TYPE_STRING_FRUIT));

                    }
                    if (freeCells.size() > 0) {
                        plants.add((Plant)creationIslandSimulationObject.createObject(null,BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES));

                    }
                    if (freeCells.size() > 0) {
                        plants.add((Plant)creationIslandSimulationObject.createObject(null,BoxCharacteristicsObject.TYPE_STRING_GRASS));

                    }
                    if (freeCells.size() > 0) {
                        plants.add((Plant)creationIslandSimulationObject.createObject(null,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES));

                    }

                    setInitialPositionsGrowPlants();
                }
            }
        }
    }

    public void setInitialPositionsGrowPlants() {

        if (freeCells.size() > 0) {

            for (int i = 0; i <= islandMap.getX(); i++) {

                if (freeCells.size() > 0) {

                    int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();

                    Coordinate coordinate1 = freeCells.get(coordinate);
                    int x = coordinate1.getX();
                    int y = coordinate1.getY();

                    plants.get(i).setXY(x, y);
                    islandArray[x][y].addIslandSimulationObject(plants.get(i));
                    Animal.numberPlants.incrementAndGet();
                    numbersPlantsGrew.incrementAndGet();
                    freeCells.remove(coordinate1);
                } else {
                    break;
                }
            }
        }
    }
}
