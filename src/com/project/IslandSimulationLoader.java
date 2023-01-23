package com.project;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.Island;
import com.project.island.IslandSimulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IslandSimulationLoader {

    public void processingInput() throws InterruptedException, InstantiationException, IllegalAccessException {


        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_X);
            Island.x = scanner.nextInt();
            if (Island.x  < 10||Island.x>50) {
               System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
                throw new InputMismatchException();
           }

        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }

        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_Y);
            Island.y = scanner.nextInt();
            if (Island.y  < 10||Island.y>50) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }


        int numberOfSimulationItems = ((Island.x * Island.y) - ((Island.x * Island.y) / 4)) / 41;
        //(predatorsNumber*9) +(herbivoresNumber*6)+(herbivoresNumber*10)


        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_NUMBER_OF_ANIMALS +
                    " " + numberOfSimulationItems);
            Island.predatorsNumber = scanner.nextInt();
            if (Island.predatorsNumber > numberOfSimulationItems) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_TOO_MANY_ANIMALS + numberOfSimulationItems);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }


        Island.herbivoresNumber = Island.predatorsNumber * 2;


        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_STOPPING_CONDITION);
            Island.conditionNumberStopSimulation = scanner.nextInt();
            if (Island.conditionNumberStopSimulation > 3 || Island.conditionNumberStopSimulation <= 0) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_WRONG_COMMAND_NUMBER);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }

        System.out.println(BoxCharacteristicsObject.MESSAGE_THANKS_KEEP_WORKING);
        Island island = Island.getIsland();
        loadingProgram();
    }

    public void loadingProgram() throws InterruptedException, InstantiationException, IllegalAccessException {
        IslandSimulation islandSimulation = IslandSimulation.getIslandSimulation();
        islandSimulation.startSimulation();
    }
}