package com.project.islandSimulationObjects.Plants;
import com.project.island.BoxCharacteristicsObject;
import com.project.island.Island;
import com.project.island.IslandSimulation;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;



public class PlantGrowth implements Runnable {
    public volatile static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.getIslandSimulationObjectList();

    public static IslandSimulationObject[][] islandArray = Island.getIslandArray();
    public static CopyOnWriteArrayList<Coordinate> freeCells = IslandSimulation.getListFreeCells();

    public Island island = Island.getIsland();
    public List<Plant> plants = Island.getPlantList();
    private int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    private int age;
    public static volatile AtomicInteger numbersPlantsGrew = new AtomicInteger(100);
    @Override
    public void run() {




        for (Plant plant :plants) {
            weight = plant.getWeight();
            weight++;
            plant.setWeight( weight);
            age = plant.getAge();
            age++;
            plant.setAge(age);
        }

        for (int i = 0; i <= 2; i++) {
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
        Animal.numberPlants.addAndGet(10);
        setInitialPositionsGrowPlants();

    }

    public  void setInitialPositionsGrowPlants() {


        for (IslandSimulationObject islandSimulationObject : plants) {
            int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();

            Coordinate coordinate1 = freeCells.get(coordinate);
            int x = coordinate1.getX();
            int  y = coordinate1.getY();


            // synchronized (islandArray) {
            islandSimulationObject.setXY(x,y);
            islandArray[x][y] = islandSimulationObject;
            //  }
            freeCells.remove(coordinate1);
            //tasksCopy.remove(islandSimulationObject);



        }

    }
}
