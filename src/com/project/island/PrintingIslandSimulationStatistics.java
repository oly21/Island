package com.project.island;

import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.CreationIslandSimulationObject;
import com.project.islandSimulationObjects.plants.PlantGrowth;

public class PrintingIslandSimulationStatistics implements Runnable {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static PrintingIslandSimulationStatistics instance;
    public static volatile Cell[][] islandArray;

    static {

        islandArray = IslandMap.getIslandArray();
    }

    CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();
    private PrintingIslandSimulationStatistics() {

    }
    public static PrintingIslandSimulationStatistics getPrintingIslandSimulationStatistics() {

        if (instance == null) {
            instance = new PrintingIslandSimulationStatistics();
        }
        return instance;
    }

    public synchronized void run() {
        synchronized (System.out) {
            System.out.println(ANSI_GREEN + "numberAnimals:" + ANSI_RESET+  " " + ANSI_GREEN + Animal.numberAnimals.get()+ ANSI_RESET
                    + " " + ANSI_GREEN + "numberBornAnimals:" + ANSI_RESET+  " " +ANSI_GREEN  + Animal.numberBornAnimals.get() + ANSI_RESET+   " " +
                    ANSI_GREEN + "numberDeadAnimals:"+ ANSI_RESET  + " " + ANSI_GREEN + Animal.numberDeadAnimals.get() + ANSI_RESET  + " " +
                    ANSI_GREEN +   "numberAnimalMoves:" + ANSI_RESET + " " + ANSI_GREEN +  Animal.numberAnimalMoves.get()+ ANSI_RESET + " " +
                    ANSI_GREEN + "numbersPlantsGrew:" + ANSI_RESET+ " " + ANSI_GREEN +  PlantGrowth.numbersPlantsGrew.get()+ ANSI_RESET + " " +
                    ANSI_GREEN + "numberPlants:"+ ANSI_RESET + " " + ANSI_GREEN +  Animal.numberPlants.get()+ ANSI_RESET + " " +
                    ANSI_GREEN +  "numberEatenPlants:"+ ANSI_RESET + " " + ANSI_GREEN +  Animal.numberEatenPlants.get()+ ANSI_RESET + " " +
                    ANSI_GREEN +  "\ndeathFromStarvation:"+ ANSI_RESET + " " + ANSI_GREEN + Animal.deathFromStarvation.get()+ ANSI_RESET + " " +
                    ANSI_GREEN +  "deathFromOldAge:"+ ANSI_RESET + " " +ANSI_GREEN +  Animal.deathFromOldAge.get()+ ANSI_RESET + " " +

                    "numberDeadGiraffe:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_GIRAFFE))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberGiraffe" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_GIRAFFE))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberBornGiraffe:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_GIRAFFE))).getNumberBornAnimalsOfParticularSpecies()) + " " +

                    "numberDeadElephant:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_ELEPHANT))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberElephant:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_ELEPHANT))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "\nnumberBornElephant:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_ELEPHANT))).getNumberBornAnimalsOfParticularSpecies()) + " " +

                    "numberBornBoar:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BOAR))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornBuffalo:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BUFFALO))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornCaterpillar:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornDeer:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_DEER))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornDuck:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_DUCK))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornGoat:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_GOAT))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "\nnumberBornHorse:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_HORSE))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornMouse:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_MOUSE))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornRabbit:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_RABBIT))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornSheep:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_SHEEP))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornBear:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BEAR))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornBoa:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BOA))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornFox:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_FOX))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "numberBornWolf:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_WOLF))).getNumberBornAnimalsOfParticularSpecies()) + " " +
                    "\nnumberBornEagle:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_EAGLE))).getNumberBornAnimalsOfParticularSpecies()) + " " +

                    "numberBoars:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BOAR))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberBuffalo:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BUFFALO))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberCaterpillars:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberDeer:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_DEER))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberDucks:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_DUCK))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberGoats:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_GOAT))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberHorses:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_HORSE))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberMouses:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_MOUSE))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "\nnumberRabbits:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_RABBIT))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberSheep:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_SHEEP))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberBears:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BEAR))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberBoas:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BOA))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberFoxes:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_FOX))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberWolfs:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_WOLF))).getNumberAnimalsOfParticularSpecies()) + " " +
                    "numberEagles:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_EAGLE))).getNumberAnimalsOfParticularSpecies()) + " " +

                    "numberDeadBoar:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BOAR))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadBuffalo:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BUFFALO))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "\nnumberDeadCaterpillar:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadDeer:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_DEER))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadDuck:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_DUCK))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadGoat:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_GOAT))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadHorse:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_HORSE))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadMouse:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_MOUSE))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadRabbit:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_RABBIT))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadSheep:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_SHEEP))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "\nnumberDeadBear:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BEAR))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadBoa:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_BOA))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadFox:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_FOX))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadWolf:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_WOLF))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    "numberDeadEagle:" + " " + (((creationIslandSimulationObject.createObject(null, BoxCharacteristicsObject.TYPE_STRING_EAGLE))).getNumberDeadAnimalsOfParticularSpecies()) + " " +
                    ANSI_GREEN + "\n\nstartRun(StartThreads):"+ ANSI_RESET + " " + ANSI_GREEN +  Animal.runStart+ ANSI_RESET + " " + ANSI_GREEN + " finishRun(FinishThreads)"+ ANSI_RESET + " " + ANSI_GREEN +  Animal.runFinish+ ANSI_RESET + " " +

                    "startM " + " " + Animal.startMove + " " + "finishM: " + " " + Animal.finishMove + " "
                    + " startR:" + " " + Animal.startR + " " + "finishR " + " " + Animal.finishR + " " +
                    "startGet: " + " " + Animal.startGet + " " + " finishGet" + " " + Animal.finishGet + " " +
                    "startSwapPlacesWithNeighbor: " + " " + Animal.startSwapPlacesWithNeighbor + " " +
                    "finishSwapPlacesWithNeighbor: " + " " + Animal.finishSwapPlacesWithNeighbor + " " +
                    "startSetPositionForNewbornAnima: " + " " + Animal.startSetPositionForNewbornAnimal + " "
                    + "finishSetPositionForNewbornAnima: " + " " + Animal.finishSetPositionForNewbornAnimal + " " +
                    "startChoiceDirectionForMoveAndCallMove: " + " " + Animal.startChoiceDirectionForMoveAndCallMove +
                    " " + "finishChoiceDirectionForMoveAndCallMove: " + " " + Animal.finishChoiceDirectionForMoveAndCallMove + " " +
                    "startDecreaseTheNumberOfOneTypeOfAnimal: " + " " + Animal.startDecreaseTheNumberOfOneTypeOfAnimal +
                    " " + "finishDecreaseTheNumberOfOneTypeOfAnimal: " + " " + Animal.finishDecreaseTheNumberOfOneTypeOfAnimal + " " +
                    "startHavingVitality: " + " " + Animal.finishHavingVitality + " " +
                    "finishHavingVitality " + " " + Animal.finishHavingVitality + " " +
                    " startEat:" + " " + Animal.startEat + " " + " finishEat" + " " + Animal.finishEat +
                    " " + " startDeathFromOldAge:" + " " + Animal.startDeathFromOldAge + " " +
                    " finishDeathFromOldAge" + " " + Animal.finishDeathFromOldAge + " " +
                    " startFor:" + " " + Animal.startFor + " " + " finishFor" + " " + Animal.finishFor
            );
        }
    }
}

