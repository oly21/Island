package com.project;
import com.project.island.StartingIslandSimulation;


public class IslandSimulationLoader {
    ProcessingInput processingInput = ProcessingInput.getProcessingInput();
    public static IslandSimulationLoader instance = null;
    private IslandSimulationLoader() {

    }

    public static IslandSimulationLoader getIslandSimulationLoader() {
        if (instance == null) {
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