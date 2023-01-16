package com.project.island;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Plants.Plant;
import com.project.islandSimulationObjects.Plants.PlantGrowth;

public class PrintingIslandSimulationStatistics implements Runnable {
    private static PrintingIslandSimulationStatistics instance;

    private PrintingIslandSimulationStatistics() {

    }


    public static PrintingIslandSimulationStatistics getPrintingIslandSimulationStatistics() {

        if (instance == null) {
            instance = new PrintingIslandSimulationStatistics();
        }
        return instance;
    }


    public void run() {
        System.out.println("numberAnimals:" + " " + Animal.numberAnimals.get()
                        + " " + "numberBornAnimals:" + " " + Animal.numberBornAnimals.get() + " " +
                        "numberDeadAnimals:" + " " + Animal.numberDeadAnimals.get() + " " +
                        "numberAnimalMoves:" + " " + Animal.numberAnimalMoves.get() + " " +
                        " numbersPlantsGrew:" + " " + PlantGrowth.numbersPlantsGrew.get() + " " +
                        " numberPlants:" + " " + Animal.numberPlants.get() + " " +
                        "numberEatenPlants:" + " " + Animal.numberEatenPlants.get() + " " +
                        " deathFromStarvation:" + " " + Animal.deathFromStarvation.get() + " " +
                        " deathFromOldAge:" + " " + Animal.deathFromOldAge.get() + " " +
                        " numberBornBoar:" + " " + Animal.numberBornBoar.get() + " " +
                        " numberBornBuffalo:" + " " + Animal.numberBornBuffalo.get() + " " +
                        " numberBornCaterpillar:" + " " + Animal.numberBornCaterpillar.get() + " " +
                        " numberBornDeer:" + " " + Animal.numberBornDeer.get() + " " +
                        " numberBornDuck:" + " " + Animal.numberBornDuck.get() + " " +
                        " numberBornGoat:" + " " + Animal.numberBornGoat.get() + " " +
                        " numberBornHorse:" + " " + Animal.numberBornHorse.get() + " " +
                        " numberBornMouse:" + " " + Animal.numberBornMouse.get() + " " +
                        " numberBornRabbit:" + " " + Animal.numberBornRabbit.get() + " " +
                        " numberBornSheep:" + " " + Animal.numberBornSheep.get() + " " +
                        " numberBornBear:" + " " + Animal.numberBornBear.get() + " " +
                        " numberBornBoa:" + " " + Animal.numberBornBoa.get() + " " +
                        " numberBornFox:" + " " + Animal.numberBornFox.get() + " " +
                        " numberBornWolf:" + " " + Animal.numberBornWolf.get() + " " +
                        "numberBornEagle:" + " " + Animal.numberBornEagle.get() + " " +

                        " numberBoars:" + " " + Animal.numberBoars.get() + " " +
                        " numberBuffalo:" + " " + Animal.numberBuffalo.get() + " " +
                        " numberCaterpillars:" + " " + Animal.numberCaterpillars.get() + " " +
                        " numberDeer:" + " " + Animal.numberDeer.get() + " " +
                        " numberDucks:" + " " + Animal.numberDucks.get() + " " +
                        " numberGoats:" + " " + Animal.numberGoats.get() + " " +
                        " numberHorses:" + " " + Animal.numberHorses.get() + " " +
                        " numberMouses:" + " " + Animal.numberMouses.get() + " " +
                        " numberRabbits:" + " " + Animal.numberRabbits.get() + " " +
                        " numberSheep:" + " " + Animal.numberSheep.get() + " " +
                        " numberBears:" + " " + Animal.numberBears.get() + " " +
                        " numberBoas:" + " " + Animal.numberBoas.get() + " " +
                        " numberFoxes:" + " " + Animal.numberFoxes.get() + " " +
                        " numberWolfs:" + " " + Animal.numberWolfs.get() + " " +
                        "numberEagles:" + " " + Animal.numberEagles.get() + " " +
                        " numberDeadBoar:" + " " + Animal.numberDeadBoar.get() + " " +
                        " numberDeadBuffalo:" + " " + Animal.numberDeadBuffalo.get() + " " +
                        " numberDeadCaterpillar:" + " " + Animal.numberDeadCaterpillar.get() + " " +
                        " numberDeadDeer:" + " " + Animal.numberDeadDeer.get() + " " +
                        " numberDeadDuck:" + " " + Animal.numberDeadDuck.get() + " " +
                        " numberDeadGoat:" + " " + Animal.numberDeadGoat.get() + " " +
                        " numberDeadHorse:" + " " + Animal.numberDeadHorse.get() + " " +
                        " numberDeadMouse:" + " " + Animal.numberDeadMouse.get() + " " +
                        " numberDeadRabbit:" + " " + Animal.numberDeadRabbit.get() + " " +
                        " numberDeadSheep:" + " " + Animal.numberDeadSheep.get() + " " +
                        " numberDeadBear:" + " " + Animal.numberDeadBear.get() + " " +
                        " numberDeadBoa:" + " " + Animal.numberDeadBoa.get() + " " +
                        " numberDeadFox:" + " " + Animal.numberDeadFox.get() + " " +
                        " numberDeadWolf:" + " " + Animal.numberDeadWolf.get() + " " +
                        "numberDeadEagle:" + " " + Animal.numberDeadEagle.get() + " " +
                        "startM " + " " + Animal.startMove + " " + "finishM: " + " " + Animal.finishMove + " "
                        + " startR:" + " " + Animal.startR + " " + "finishR " + " " + Animal.finishR + " " +
                        "startGet: " + " " + Animal.startGet + " " + " finishGet" + " " + Animal.finishGet + " " +
                        " startRun:" + " " + Animal.runStart + " " + " finishRun" + " " + Animal.runFinish + " " +
                        "startSwapPlacesWithNeighbor: " + " " + Animal.startSwapPlacesWithNeighbor + " " + "finishSwapPlacesWithNeighbor: " + " " + Animal.finishSwapPlacesWithNeighbor + " " +
                        "startSetPositionForNewbornAnima: " + " " + Animal.startSetPositionForNewbornAnimal + " " + "finishSetPositionForNewbornAnima: " + " " + Animal.finishSetPositionForNewbornAnimal + " " +
                        "startChoiceDirectionForMoveAndCallMove: " + " " + Animal.startChoiceDirectionForMoveAndCallMove + " " + "finishChoiceDirectionForMoveAndCallMove: " + " " + Animal.finishChoiceDirectionForMoveAndCallMove + " " +
                        "startDecreaseTheNumberOfOneTypeOfAnimal: " + " " + Animal.startDecreaseTheNumberOfOneTypeOfAnimal + " " + "finishDecreaseTheNumberOfOneTypeOfAnimal: " + " " + Animal.finishDecreaseTheNumberOfOneTypeOfAnimal + " " +
                        "startHavingVitality: " + " " + Animal.finishHavingVitality + " " + "finishHavingVitality " + " " + Animal.finishHavingVitality +
                        " " + " startEat:" + " " + Animal.startEat + " " + " finishEat" + " " + Animal.finishEat +
                        " " + " startDeathFromOldAge:" + " " + Animal.startDeathFromOldAge + " " + " finishDeathFromOldAge" + " " + Animal.finishDeathFromOldAge + " " +
                        " startFor:" + " " + Animal.startFor + " " + " finishFor" + " " + Animal.finishFor
                //   + " " + " startFood:" + " " + Animal.startFood + " " + " finishFood" + " " + Animal.finishFood


        );
    }
}
