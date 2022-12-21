package com.project.island;

import java.util.concurrent.CopyOnWriteArrayList;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Animals.herbivorous.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.Plants.*;

public class Island {


    private static Island instance;
    public static int x = 20;
    public static int y = 20;

    int numberAnimal = 50;

    private Island(int x, int y) {

        Island.x = x;
        Island.y = y;
      //  this.numberAnimal = numberAnimal;
    }


    public static Island getIsland() {

        if (instance == null) {
            instance = new Island(20, 20);
        }
        return instance;
    }

    private static volatile IslandSimulationObject[][] islandArray = new IslandSimulationObject[x][y];


    public volatile static CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();

    public volatile static CopyOnWriteArrayList<Plant> plants = new CopyOnWriteArrayList<>();
    public volatile static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects =
            new CopyOnWriteArrayList<>();


    public void listInitialization() {

        Animal animal;
        Animal animal1;
        Animal animal2;
        Animal animal3;
        Animal animal4;
        Animal animal5;
        Animal animal6;
        Animal animal7;
        Animal animal8;
        Animal animal9;
        Animal animal10;
        Animal animal11;
        Animal animal12;
        Animal animal13;
        Animal animal14;

        Plant plant;
        Plant plant1;
        Plant plant2;
        Plant plant3;
        Plant plant4;


        for (int i = 0; i <= 10; i++) {
            animal = new Fox(1, 1);
            animal1 = new Wolf(1, 1);
            animal2 = new Caterpillar(1, 1);
            animal3 = new Deer(1, 1);
            animal4 = new Duck(1, 1);
            animal5 = new Goat(1, 1);
            animal6 = new Horse(1, 1);
            animal7 = new Mouse(1, 1);
            animal8 = new Rabbit(1, 1);
            animal9 = new Sheep(1, 1);
            animal10 = new Bear(1, 1);
            animal11 = new Boa(1, 1);
            animal12 = new Boar(1, 1);
            animal13 = new Eagle(1, 1);
            animal14 = new Buffalo(1, 1);
            plant = new Berries(1, 1);
            plant1 = new Fruit(1, 1);
            plant2 = new Grass(1, 1);
            plant3 = new PlantLeaves(1, 1);
            plant4 = new Vegetables(1, 1);

            animals.add(animal);
            animals.add(animal1);
            animals.add(animal2);
            animals.add(animal3);
            animals.add(animal4);
            animals.add(animal5);
            animals.add(animal6);
            animals.add(animal7);
            animals.add(animal8);
            animals.add(animal9);
            animals.add(animal10);
            animals.add(animal11);
            animals.add(animal12);
            animals.add(animal13);
            animals.add(animal14);
            plants.add(plant1);
            plants.add(plant2);
            plants.add(plant3);
            plants.add(plant4);
            plants.add(plant);
        }
            islandSimulationObjects.addAll(animals);
            islandSimulationObjects.addAll(plants);
            Animal.numberAnimals.addAndGet(150);
            Animal.numberPlants.addAndGet(50);






    }

    public synchronized static  IslandSimulationObject[][] getIslandArray() {

        return islandArray;


    }
   // public synchronized void setIslandArray(int x, int y, IslandSimulationObject value) {
      //  islandArray[x][y] = value;
   // }

    public static  CopyOnWriteArrayList<Animal> getAnimalList() {

        return animals;


    }

    public static  CopyOnWriteArrayList<Plant> getPlantList() {

        return plants;


    }

    public static  CopyOnWriteArrayList<IslandSimulationObject> getIslandSimulationObjectList() {
        return islandSimulationObjects;


    }
}