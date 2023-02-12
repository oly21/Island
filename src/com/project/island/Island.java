package com.project.island;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.CreationIslandSimulationObject;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.plants.*;

public class Island {

    CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();


    public volatile static CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
    public volatile static CopyOnWriteArrayList<Plant> plants = new CopyOnWriteArrayList<>();
    public volatile static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = new CopyOnWriteArrayList<>();
    public static Island instance = null;

    public static volatile int x;
    public static volatile int y;

    public static int predatorsNumber;
    public static int herbivoresNumber;
    public static int conditionNumberStopSimulation;
    private static volatile IslandSimulationObject[][] islandArray;

    protected List<String> initialList = Arrays.asList(
            BoxCharacteristicsObject.TYPE_STRING_WOLF,
            BoxCharacteristicsObject.TYPE_STRING_BOA,
            BoxCharacteristicsObject.TYPE_STRING_FOX,
            BoxCharacteristicsObject.TYPE_STRING_BEAR,
            BoxCharacteristicsObject.TYPE_STRING_EAGLE,
            BoxCharacteristicsObject.TYPE_STRING_HORSE,
            BoxCharacteristicsObject.TYPE_STRING_DEER,
            BoxCharacteristicsObject.TYPE_STRING_RABBIT,
            BoxCharacteristicsObject.TYPE_STRING_MOUSE,
            BoxCharacteristicsObject.TYPE_STRING_GOAT,
            BoxCharacteristicsObject.TYPE_STRING_SHEEP,
            BoxCharacteristicsObject.TYPE_STRING_BOAR,
            BoxCharacteristicsObject.TYPE_STRING_BUFFALO,
            BoxCharacteristicsObject.TYPE_STRING_DUCK,
            BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES,
            BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_GRASS,
            BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
            BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
            BoxCharacteristicsObject.TYPE_STRING_GIRAFFE,
            BoxCharacteristicsObject.TYPE_STRING_ELEPHANT
    );

    public volatile CopyOnWriteArrayList<String> typeString = new CopyOnWriteArrayList<>(initialList);
    private Island(int x, int y, int predatorsNumber, int herbivoresNumber, int conditionNumberStopSimulation) {

        Island.x = x;
        Island.y = y;
        Island.predatorsNumber = predatorsNumber;
        Island.herbivoresNumber = herbivoresNumber;
        Island.conditionNumberStopSimulation = conditionNumberStopSimulation;
        islandArray = new IslandSimulationObject[Island.x][Island.y];
    }


    public static Island getIsland() {
        if (instance == null && Island.x > 0) {

            instance = new Island(x, y, predatorsNumber, herbivoresNumber, conditionNumberStopSimulation);
        }
        return instance;
    }


    public void listInitialization() {


        for (int i = 0; i <= predatorsNumber * 2; i++) {
            for (String typeString : typeString) {
                IslandSimulationObject islandSimulationObject = creationIslandSimulationObject.createObject(null, typeString);

                if (islandSimulationObject instanceof Animal) {
                    animals.add((Animal) islandSimulationObject);
                    islandSimulationObject.setNumberAnimalsOfParticularSpecies((islandSimulationObject).getNumberAnimalsOfParticularSpecies() + 1);

                } else if (islandSimulationObject instanceof Plant) {
                    plants.add((Plant) islandSimulationObject);
                    Animal.numberPlants.incrementAndGet();

                }
            }
        }

        islandSimulationObjects.addAll(animals);
        islandSimulationObjects.addAll(plants);
        Animal.numberAnimals.addAndGet(animals.size());
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