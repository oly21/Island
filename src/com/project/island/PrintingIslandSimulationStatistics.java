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
                        " deathFromOldAge:" + " " + Animal.deathFromOldAge.get() + " "+
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
                        " numberBornEagle:" + " " + Animal.numberBornEagle.get() + " " +
                        " numberBornFox:" + " " + Animal.numberBornFox.get() + " " +
                        " numberBornWolf:" + " " + Animal.numberBornWolf.get() + " "
                        + "finishM: " + " " + Animal.finishMove + " " + "startM " + " " + Animal.startMove + " "
                        + " startR:" + " " + Animal.startR + " " + "finishR " + " " + Animal.finishR + " " +
                        "startGet: " + " " + Animal.startGet + " " + " finishGet" + " " + Animal.finishGet + " " +
                        " startRun:" + " " + Animal.runStart + " " + " finishRun" + " " + Animal.runFinish + " " +
                        "startM2: " + " " + Animal.startM2 + " " + "finishM2 " + " " + Animal.finishM2 + " " +
                        //"startH: " + " " + Animal.startHunt + " " + "finishH " + " " + Animal.finishHunt +
                        " " + " startEat:" + " " + Animal.startEat + " " + " finishEat" + " " + Animal.finishEat+
                //  + " " + " startIf:" + " " + Animal.startIf + " " + " finishIf" + " " + Animal.finishIf + " " +
                " startFor:" + " " + Animal.startFor + " " + " finishFor" + " " + Animal.finishFor
                //   + " " + " startFood:" + " " + Animal.startFood + " " + " finishFood" + " " + Animal.finishFood


        );
    }
}
