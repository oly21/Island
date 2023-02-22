package com.project.island;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.CreationIslandSimulationObject;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.plants.*;

public class IslandMap {
    CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();
    public CopyOnWriteArrayList<IslandSimulationObject> tasksCopy = new CopyOnWriteArrayList<>();
    public  CopyOnWriteArrayList<Coordinate> freeCells = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Plant> plants = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = new CopyOnWriteArrayList<>();
    public static IslandMap instance = null;
    public int x;
    public int y;
    public int predatorsNumber;
    public int herbivoresNumber;
    public int conditionNumberStopSimulation;
    private volatile Cell[][] islandArray;

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

    private IslandMap(int x, int y, int predatorsNumber, int herbivoresNumber, int conditionNumberStopSimulation) {
        this.x = x;
        this.y = y;
        this.predatorsNumber = predatorsNumber;
        this.herbivoresNumber = herbivoresNumber;
        this.conditionNumberStopSimulation = conditionNumberStopSimulation;
        islandArray = new Cell[x][y];
        for (int i = 0; i <= islandArray.length - 1; i++) {
            for (int j = 0; j <= islandArray[i].length - 1; j++) {
                islandArray[i][j] = new Cell();
            }
        }
    }


    public CopyOnWriteArrayList<String> getTypeString() {
        return typeString;
    }
    public static IslandMap getIslandMap() {
        return instance;
    }

    public static void createIsland(int x, int y, int predatorsNumber, int herbivoresNumber, int conditionNumberStopSimulation) {
        if (instance == null) {
            instance = new IslandMap(x, y, predatorsNumber, herbivoresNumber, conditionNumberStopSimulation);
        }
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

    public synchronized Cell[][] getIslandArray() {
        return islandArray;
    }
    public CopyOnWriteArrayList<Animal> getAnimalList() {
        return animals;
    }
    public CopyOnWriteArrayList<Plant> getPlantList() {
        return plants;
    }

    public CopyOnWriteArrayList<IslandSimulationObject> getIslandSimulationObjectList() {
        return islandSimulationObjects;

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setInitialPositionsSimulationObjects() {
        tasksCopy.addAll(islandSimulationObjects);
        for (IslandSimulationObject islandSimulationObject : tasksCopy) {
            int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();
            Coordinate coordinate1 = freeCells.get(coordinate);
            int x = coordinate1.getX();
            int y = coordinate1.getY();
            islandSimulationObject.setXY(x, y);
            islandArray[x][y].addIslandSimulationObject(islandSimulationObject);
            freeCells.remove(coordinate1);
        }
    }


    public void creatListFreeCells() {
        for (int i = 0; i < islandArray.length - 1; i++) {
            for (int j = 0; j < islandArray[i].length - 1; j++) {
                for (int k = 0; k <= 5; k++) {
                    freeCells.add(new Coordinate(i, j));
                }
            }
        }
    }

    public  CopyOnWriteArrayList<Coordinate> getListFreeCells() {
        return freeCells;
    }
}