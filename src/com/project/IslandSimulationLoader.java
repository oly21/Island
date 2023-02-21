package com.project;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.IslandMap;
import com.project.island.StartingIslandSimulation;

import java.util.InputMismatchException;
import java.util.Scanner;
import static com.project.island.IslandMap.getIslandMap;

public class IslandSimulationLoader {

    ProcessingInput processingInput = ProcessingInput.getProcessingInput();
    public static   IslandSimulationLoader instance = null;
    private IslandSimulationLoader() {

    }
    public static   IslandSimulationLoader getIslandSimulationLoader() {
        if (instance == null ) {
            instance = new IslandSimulationLoader();
        }
        return instance;
    }
    public void loadingProgram() {
        processingInput.processInput();
        StartingIslandSimulation islandSimulation = StartingIslandSimulation.getIslandSimulation();
        islandSimulation.startSimulation();
    }
}