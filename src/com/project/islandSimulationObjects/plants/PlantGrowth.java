package com.project.islandSimulationObjects.plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.Island;
import com.project.island.IslandSimulation;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.CreationIslandSimulationObject;
import com.project.islandSimulationObjects.IslandSimulationObject;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;


public class PlantGrowth implements Runnable {
    public volatile static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.getIslandSimulationObjectList();
    public static PlantGrowth instance = null;
    public Island island = Island.getIsland();
    public IslandSimulationObject[][] islandArray = island.getIslandArray();
    public static final CopyOnWriteArrayList<Coordinate> freeCells = IslandSimulation.getListFreeCells();


    public List<Plant> plants = Island.getPlantList();
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

            for (int i = 0; i <= Island.x; i++) {


                if (freeCells.size() > 0) {

                    int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();

                    Coordinate coordinate1 = freeCells.get(coordinate);
                    int x = coordinate1.getX();
                    int y = coordinate1.getY();


                    plants.get(i).setXY(x, y);
                    islandArray[x][y] = plants.get(i);
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
