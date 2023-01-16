package com.project.island;

import java.util.concurrent.CopyOnWriteArrayList;

import com.project.Solution;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Animals.herbivorous.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.Plants.*;

public class Island {


    public  static  Island instance = null;
    public static volatile int x;
    public static  volatile int y;

   public static int predatorsNumber;
    public static int herbivoresNumber;
     public  static int conditionNumberStopSimulation ;
    private  static volatile IslandSimulationObject[][] islandArray;
    private Island(int x, int y, int predatorsNumber, int herbivoresNumber, int conditionNumberStopSimulation) {

        Island.x = x;
        Island.y = y;
       this.predatorsNumber = predatorsNumber;
       this.herbivoresNumber = herbivoresNumber;
       this.conditionNumberStopSimulation =  conditionNumberStopSimulation;
        islandArray =   new IslandSimulationObject[Island.x][Island.y];
    }


    public static Island getIsland() {
        if(instance == null&&Island.x>0){

        instance = new Island( x,  y,  predatorsNumber,  herbivoresNumber,  conditionNumberStopSimulation);
        }
        return instance;
    }
    public   void setInstance(Island instance){
        this.instance = instance;
    }



    public volatile static CopyOnWriteArrayList<Animal> animals = new CopyOnWriteArrayList<>();

    public volatile static CopyOnWriteArrayList<Plant> plants = new CopyOnWriteArrayList<>();
    public volatile static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects =
            new CopyOnWriteArrayList<>();


    public void listInitialization() {



        for (int i = 0; i <= predatorsNumber; i++) {

            animals.add(new Fox(1, 2));
            Animal.numberFoxes.incrementAndGet();
            animals.add(new Wolf(1, 2));
            Animal.numberWolfs.incrementAndGet();
            animals.add(new Deer(1, 5));
            Animal.numberDeer.incrementAndGet();
            animals.add(new Horse(1, 4));
            Animal.numberHorses.incrementAndGet();
            animals.add(new Bear(1, 2));
            Animal.numberBears.incrementAndGet();
            animals.add(new Boar(1, 4));
            Animal.numberBoars.incrementAndGet();
            animals.add(new Eagle(1, 3));
            Animal.numberEagles.incrementAndGet();
            animals.add(new Buffalo(1, 4));
            Animal.numberBuffalo.incrementAndGet();
            animals.add(new Boa(1, 2));
            Animal.numberBoas.incrementAndGet();
        }
        for (int i = 0; i <= herbivoresNumber; i++) {


            animals.add(new Caterpillar(1, 2));
            Animal.numberCaterpillars.incrementAndGet();
            animals.add(new Mouse(1, 4)  );
            Animal.numberMouses.incrementAndGet();
            animals.add( new Rabbit(  1, 4));
            Animal.numberRabbits.incrementAndGet();
            animals.add(new Sheep(1, 2));
            Animal.numberSheep.incrementAndGet();

            animals.add(new Duck(1, 2));
            Animal.numberDucks.incrementAndGet();

            animals.add(new Goat(1, 2));
            Animal.numberGoats.incrementAndGet();
            plants.add(new Berries(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Fruit(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new PlantLeaves(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Vegetables(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Grass(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Berries(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Fruit(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new PlantLeaves(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Vegetables(1, 1));
            Animal.numberPlants.incrementAndGet();
            plants.add(new Grass(1, 1));
            Animal.numberPlants.incrementAndGet();
        }
           islandSimulationObjects.addAll(animals);
            islandSimulationObjects.addAll(plants);
            Animal.numberAnimals.addAndGet(animals.size());
           // Animal.numberPlants.addAndGet(plants.size());









}
    public void  initializeIslandVariables(int x, int y, int predatorsNumber, int herbivoresNumber, int conditionNumberStopSimulation){
        Island.x = x;
        Island.y = y;
        Island.predatorsNumber = predatorsNumber;
        Island.herbivoresNumber = herbivoresNumber;
        this.conditionNumberStopSimulation =  conditionNumberStopSimulation;
    }




    public static  synchronized   IslandSimulationObject[][] getIslandArray() {


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