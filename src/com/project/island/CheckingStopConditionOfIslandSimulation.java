package com.project.island;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Animals.herbivorous.Herbivores;
import com.project.islandSimulationObjects.Plants.Plant;

import java.util.concurrent.CopyOnWriteArrayList;

public class CheckingStopConditionOfIslandSimulation implements  Runnable{
    public volatile static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public volatile static CopyOnWriteArrayList<Plant> plants = Island.getPlantList();
  // IslandSimulation islandSimulation = IslandSimulation.getIslandSimulation();
   Island  island = Island.getIsland();
    private static CheckingStopConditionOfIslandSimulation instance;
      int conditionOfIslandSimulationInt  =  island.conditionNumberStopSimulation;
    static boolean  ConditionOfIslandSimulation;
    private CheckingStopConditionOfIslandSimulation() {


    }


    public static CheckingStopConditionOfIslandSimulation getCheckingStopConditionOfIslandSimulation() {



        if (instance == null) {
            instance = new CheckingStopConditionOfIslandSimulation();
        }
        return instance;
    }


   @Override
    public void run() {
       System.out.println("cheсk start");
        int countHerbivores = 0;
        for (Animal animal : animals) {
            if (animal instanceof Herbivores) {
                countHerbivores++;
            }

        }

   System.out.println("countHerbivores:"+" "+ countHerbivores);





        if(conditionOfIslandSimulationInt == 1 ){
           ConditionOfIslandSimulation = (countHerbivores == 0);
       }
       else{
           ConditionOfIslandSimulation = ( plants.size()==0);
       }
        if( ConditionOfIslandSimulation ){

            IslandSimulation.executorScheduledServiceDisplay.shutdown();
            IslandSimulation.executorScheduledServiceAnimalLifeCycle.shutdown();
            IslandSimulation.executorScheduledServicePlantGrowth.shutdown();
            IslandSimulation.executorScheduledServicePrintingIslandSimulationStatistics.shutdown();
            IslandSimulation.executorScheduledServiceDisplay.shutdown();

        if(conditionOfIslandSimulationInt == 1) {
            System.out.println("Симуляция закончилась, на острове остались одни хищники");
            IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
        }

        else if(conditionOfIslandSimulationInt == 2){
            System.out.println("Симуляция закончилась, на острове закончились растения ");
        IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
        }


        }
    }



}
