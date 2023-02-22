package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.CreationIslandSimulationObject;
import com.project.islandSimulationObjects.plants.PlantGrowth;
import java.util.concurrent.CopyOnWriteArrayList;
import static com.project.island.IslandMap.getIslandMap;

public class PrintingIslandSimulationStatistics implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static PrintingIslandSimulationStatistics instance;
    public IslandMap islandMap = getIslandMap();
    public volatile Cell[][] islandArray = islandMap.getIslandArray();
    CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();

    private PrintingIslandSimulationStatistics() {

    }

    public volatile CopyOnWriteArrayList<String> typeString = islandMap.getTypeString();

    public static PrintingIslandSimulationStatistics getPrintingIslandSimulationStatistics() {

        if (instance == null) {
            instance = new PrintingIslandSimulationStatistics();
        }
        return instance;
    }

    public synchronized void run() {
        synchronized (System.out) {
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numberAnimals:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.numberAnimals.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numberBornAnimals:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.numberBornAnimals.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numberDeadAnimals:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.numberDeadAnimals.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numberAnimalMoves:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.numberAnimalMoves.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numbersPlantsGrew:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, PlantGrowth.numbersPlantsGrew.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numberPlants:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.numberPlants.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "numberEatenPlants:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.numberEatenPlants.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "\ndeathFromStarvation:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.deathFromStarvation.get(), ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "deathFromOldAge:", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.deathFromOldAge.get(), ANSI_RESET));

            for (int i = -1; i < typeString.size() - 1; i++) {
                stringBuilder.append(String.format("%s%s %s ", "numberDead", typeString.get(i + 1), (creationIslandSimulationObject.createObject(null, typeString.get(i + 1))).getNumberDeadAnimalsOfParticularSpecies()));
                stringBuilder.append(String.format("%s%s %s ", "number", typeString.get(i + 1), (creationIslandSimulationObject.createObject(null, typeString.get(i + 1))).getNumberAnimalsOfParticularSpecies()));
                stringBuilder.append(String.format("%s%s %s ", "numberBorn", typeString.get(i + 1), (creationIslandSimulationObject.createObject(null, typeString.get(i + 1))).getNumberBornAnimalsOfParticularSpecies()));
                if (i % 3 == 0) {
                    stringBuilder.append("\n");
                }
            }

            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, "\n\nstartRun(StartThreads):", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.runStart, ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, " finishRun(FinishThreads)", ANSI_RESET));
            stringBuilder.append(String.format("%s %s %s", ANSI_GREEN, Animal.runFinish, ANSI_RESET));

            String message = stringBuilder.toString();
            System.out.println(message);
        }
    }
}

