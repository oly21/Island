package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.animals.herbivorous.Herbivores;
import com.project.islandSimulationObjects.plants.Plant;

import java.util.concurrent.CopyOnWriteArrayList;

import static com.project.island.IslandMap.getIslandMap;

public class CheckingStopConditionOfIslandSimulation implements Runnable {
    public final String ANSI_RESET = "\u001B[0m";
    public IslandMap islandMap = getIslandMap();
    public final String ANSI_GREEN = "\u001B[32m";
    public volatile CopyOnWriteArrayList<Animal> animals = islandMap.getAnimalList();
    public volatile CopyOnWriteArrayList<Plant> plants = islandMap.getPlantList();
    public volatile Cell[][] islandArray = islandMap.getIslandArray();
    private static CheckingStopConditionOfIslandSimulation instance;
    private int conditionOfIslandSimulationInt = islandMap.conditionNumberStopSimulation;
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
                PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();

                islandSimulationDisplay.run();
                printingIslandSimulationStatistics.run();

                StartingIslandSimulation.executorScheduledServiceDisplay.shutdown();
                StartingIslandSimulation.executorScheduledServiceAnimalLifeCycle.shutdown();
                StartingIslandSimulation.executorScheduledServicePlantGrowth.shutdown();
                StartingIslandSimulation.executorScheduledServicePrintingIslandSimulationStatistics.shutdown();
                StartingIslandSimulation.executorScheduledServiceDisplay.shutdown();

                if (conditionOfIslandSimulationInt == 1) {
                    System.out.println(ANSI_GREEN + "\nСимуляция закончилась, на острове остались одни хищники или травоядных, на которых могут напасть хищники осталось не больше 5" + ANSI_RESET);
                    StartingIslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
                } else if (conditionOfIslandSimulationInt == 2) {
                    System.out.println(ANSI_GREEN + "\nСимуляция закончилась, на острове закончились растения или их осталось меньше 10 " + ANSI_RESET);
                    StartingIslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
                } else if (conditionOfIslandSimulationInt == 3) {
                    System.out.println(ANSI_GREEN + "\nСимуляция закончилась, к сожелению все погибли  " + ANSI_RESET);
                    StartingIslandSimulation.executorScheduledCheckStopConditionOfIslandSimulation.shutdown();
                }
            }
        }
    }
}
