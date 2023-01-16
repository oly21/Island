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

        int countHerbivores = 0;
       synchronized (animals) {
           for (Animal animal : animals) {
               if (animal instanceof Herbivores) {
                   countHerbivores++;
               }

           }

           System.out.println("countHerbivores:" + " " + countHerbivores);

       }

       System.out.println("cheсk start");

        if(conditionOfIslandSimulationInt == 1 ){
           ConditionOfIslandSimulation = (countHerbivores <5);
       }
       else if(conditionOfIslandSimulationInt == 2) {
           ConditionOfIslandSimulation = ( Animal.numberPlants.get()<10);
       }
        else if(conditionOfIslandSimulationInt == 3) {
            ConditionOfIslandSimulation = ( animals.size()==0);
        }

        if( ConditionOfIslandSimulation ){
            System.out.println(" конец:" + " countHerbivores"+ " "+  countHerbivores);

            IslandSimulation.executorScheduledServiceDisplay.shutdown();
            IslandSimulation.executorScheduledServiceAnimalLifeCycle.shutdown();
            IslandSimulation.executorScheduledServicePlantGrowth.shutdown();
            IslandSimulation.executorScheduledServicePrintingIslandSimulationStatistics.shutdown();
            IslandSimulation.executorScheduledServiceDisplay.shutdown();

        if(conditionOfIslandSimulationInt == 1) {
            System.out.println("Симуляция закончилась, на острове остались одни хищники или осталось  травояжных не больше 5");
            IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
        }

        else if(conditionOfIslandSimulationInt == 2){
            System.out.println("Симуляция закончилась, на острове закончились растения или их осталось меньше 10 ");
        IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
        }

        else if(conditionOfIslandSimulationInt == 3){
            System.out.println("Симуляция закончилась, к сожелению все погибли ");
            IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
        }
        }
    }



}
