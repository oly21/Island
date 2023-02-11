package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.animals.herbivorous.Herbivores;
import com.project.islandSimulationObjects.IslandSimulationObject;
import com.project.islandSimulationObjects.plants.Plant;

import java.util.concurrent.CopyOnWriteArrayList;

public class CheckingStopConditionOfIslandSimulation implements Runnable {
    public volatile static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public volatile static CopyOnWriteArrayList<Plant> plants = Island.getPlantList();
    public static volatile IslandSimulationObject[][] islandArray;

    static {

        islandArray = Island.getIslandArray();

    }

    private static CheckingStopConditionOfIslandSimulation instance;
    int conditionOfIslandSimulationInt = Island.conditionNumberStopSimulation;
    static boolean ConditionOfIslandSimulation;

    private CheckingStopConditionOfIslandSimulation() {


    }


    public static CheckingStopConditionOfIslandSimulation getCheckingStopConditionOfIslandSimulation() {


        if (instance == null) {
            instance = new CheckingStopConditionOfIslandSimulation();
        }
        return instance;
    }


    @Override
    public synchronized void run() {
        synchronized (System.out) {
            int countHerbivores = 0;
            synchronized (System.out) {
                synchronized (animals) {
                    for (Animal animal : animals) {
                        if (animal instanceof Herbivores) {
                            countHerbivores++;
                        }

                    }


                }

                System.out.println("cheсk start");
                System.out.println("countHerbivores:" + " " + countHerbivores);

                if (conditionOfIslandSimulationInt == 1) {
                    ConditionOfIslandSimulation = (countHerbivores < 5);
                } else if (conditionOfIslandSimulationInt == 2) {
                    ConditionOfIslandSimulation = (Animal.numberPlants.get() < 10);
                } else if (conditionOfIslandSimulationInt == 3) {
                    ConditionOfIslandSimulation = (animals.size() == 0);
                }

                if (ConditionOfIslandSimulation) {

                    IslandSimulationDisplay islandSimulationDisplay = IslandSimulationDisplay.getIslandSimulation();
                    islandSimulationDisplay.run();
                    PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();
                    printingIslandSimulationStatistics.run();
                    IslandSimulation.executorScheduledServiceDisplay.shutdown();
                    IslandSimulation.executorScheduledServiceAnimalLifeCycle.shutdown();
                    IslandSimulation.executorScheduledServicePlantGrowth.shutdown();
                    IslandSimulation.executorScheduledServicePrintingIslandSimulationStatistics.shutdown();
                    IslandSimulation.executorScheduledServiceDisplay.shutdown();

                    if (conditionOfIslandSimulationInt == 1) {
                        System.out.println("\nСимуляция закончилась, на острове остались одни хищники или   травоядных, на которых могут напасть хищники осталось не больше 5");
                        IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
                    } else if (conditionOfIslandSimulationInt == 2) {
                        System.out.println("\nСимуляция закончилась, на острове закончились растения или их осталось меньше 10 ");
                        IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
                    } else if (conditionOfIslandSimulationInt == 3) {
                        System.out.println("\nСимуляция закончилась, к сожелению все погибли  ");
                        IslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
                    }
                }
            }
        }
    }
}
