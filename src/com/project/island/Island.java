package com.project.island;

import java.util.concurrent.CopyOnWriteArrayList;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Animals.herbivorous.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.Plants.*;

public class Island {
    public static Island instance = null;
    public static volatile int x;
    public static volatile int y;
    public static int predatorsNumber;
    public static int herbivoresNumber;
    public static int conditionNumberStopSimulation;
    private static volatile IslandSimulationObject[][] islandArray;
    private  volatile static  CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
    private  volatile static  CopyOnWriteArrayList<Plant> plants = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects =
            new CopyOnWriteArrayList<>();

    private Island(int x, int y, int predatorsNumber, int herbivoresNumber, int conditionNumberStopSimulation) {

        Island.x = x;
        Island.y = y;
        Island.predatorsNumber = predatorsNumber;
        Island.herbivoresNumber = herbivoresNumber;
        Island.conditionNumberStopSimulation = conditionNumberStopSimulation;
        islandArray = new IslandSimulationObject[Island.x][Island.y];
    }


    public static Island getIsland() {
        if (instance == null) {

            instance = new Island(x, y, predatorsNumber, herbivoresNumber, conditionNumberStopSimulation);
        }
        return instance;
    }


    public void listInitialization() {

       for (int i = 0; i <= predatorsNumber; i++) {
            animals.add(new Fox(1, 5));
            animals.add(new Wolf(1, 7));

            animals.add(new Horse(1, 5));
            animals.add(new Bear(1, 7));
            animals.add(new Boar(1, 7));
            animals.add(new Eagle(1, 6));
            animals.add(new Buffalo(1, 5));

        }
        for (int i = 0; i <= herbivoresNumber; i++) {

            animals.add(new Deer(1, 5));
            animals.add(new Deer(1, 5));

            animals.add(new Caterpillar(1, 5));
            animals.add(new Mouse(1, 7));
            animals.add(new Mouse(1, 7));
            animals.add(new Mouse(1, 7));
            animals.add(new Mouse(1, 7));
            animals.add(new Rabbit(1, 5));
            animals.add(new Rabbit(1, 5));
            animals.add(new Rabbit(1, 5));
            animals.add(new Rabbit(1, 5));
            animals.add(new Rabbit(1, 5));
            animals.add(new Sheep(1, 7));
            animals.add(new Sheep(1, 7));
            animals.add(new Sheep(1, 7));
            animals.add(new Sheep(1, 7));
            animals.add(new Boa(1, 6));
           // animals.add(new Goat(1, 7));
           // animals.add(new Goat(1, 7));
            //animals.add(new Goat(1, 7));
            animals.add(new Goat(1, 7));
            animals.add(new Duck(1, 8));

            plants.add(new Berries(1, 5));
            plants.add(new Fruit(1, 5));
            plants.add(new Grass(1, 1));
            plants.add(new PlantLeaves(1, 1));
            plants.add(new Vegetables(1, 1));
        }

        islandSimulationObjects.addAll(animals);

        islandSimulationObjects.addAll(plants);
        Animal.numberAnimals.addAndGet((animals.size()));
        Animal.numberPlants.addAndGet(plants.size());
    }


    public static synchronized IslandSimulationObject[][] getIslandArray() {

        return islandArray;
    }


    public static CopyOnWriteArrayList<Animal> getAnimalList() {

        return animals;
    }

    public static CopyOnWriteArrayList<Plant> getPlantList() {

        return plants;
    }

    public static CopyOnWriteArrayList<IslandSimulationObject> getIslandSimulationObjectList() {
        return islandSimulationObjects;


    }
}