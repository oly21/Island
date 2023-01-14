package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.Island;
import com.project.island.IslandSimulation;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;


import java.util.Iterator;
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


    private PlantGrowth() {


    }


    public static PlantGrowth getPlantGrowth() {
        if(instance == null){

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
                    plants.add(new Vegetables(2));
                    plants.add(new Berries(2));
                    plants.add(new Fruit(2));
                    plants.add(new Grass(2));
                    plants.add(new PlantLeaves(2));

                    islandSimulationObjects.add(new Vegetables(1));
                    islandSimulationObjects.add(new Berries(1));
                    islandSimulationObjects.add(new Fruit(1));
                    islandSimulationObjects.add(new Grass(1));
                    islandSimulationObjects.add(new PlantLeaves(1));


                }
                numbersPlantsGrew.addAndGet(10);

                setInitialPositionsGrowPlants();
            }
        }
    }

    public void setInitialPositionsGrowPlants() {

        if (freeCells.size() > 0) {
            int count = 0;
            for (int i = 0; i < 10; i++) {


                if (freeCells.size() > 0) {
                    count++;
                    int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();

                    Coordinate coordinate1 = freeCells.get(coordinate);
                    int x = coordinate1.getX();
                    int y = coordinate1.getY();


                    plants.get(i).setXY(x, y);
                    islandArray[x][y] = plants.get(i);
                    Animal.numberPlants.addAndGet(1);
                    freeCells.remove(coordinate1);
                } else {
                    break;//tasksCopy.remove(islandSimulationObject);
                }

            }
            if (count < 10) {
                Iterator<Plant> iterator = plants.iterator();
                for (int j = 0; j < 10 - count; j++){
                    Plant item = iterator.next();

                        iterator.remove();
                    }
                }
               // for (int j = 0; j < 10 - count; j++) {
               //     plants.remove(j);
              //  }

            }

        }

    }
