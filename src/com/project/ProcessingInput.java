package com.project;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.Cell;
import com.project.island.IslandMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessingInput {
    public static ProcessingInput instance = null;

    private ProcessingInput() {

    }

    public static ProcessingInput getProcessingInput() {
        if (instance == null) {
            instance = new ProcessingInput();
        }
        return instance;
    }

    public void processInput() {
        int x;
        int y;
        int predatorsNumber;
        int herbivoresNumber;
        int conditionNumberStopSimulation;
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_X);
            x = scanner.nextInt();
            if (x < 10 || x > 50) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
                throw new InputMismatchException();
            }

        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }

        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_Y);
            y = scanner.nextInt();
            if (y < 10 || y > 50) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }


        int numberOfSimulationItems = ((x * y) - ((x * y) / 4)) / 41;
        //(predatorsNumber*9) +(herbivoresNumber*6)+(herbivoresNumber*10)

        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_NUMBER_OF_ANIMALS +
                    " " + numberOfSimulationItems);
            predatorsNumber = scanner.nextInt();
            if (predatorsNumber > numberOfSimulationItems) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_TOO_MANY_ANIMALS + numberOfSimulationItems);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }


        herbivoresNumber = predatorsNumber * 2;

        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_STOPPING_CONDITION);
            conditionNumberStopSimulation = scanner.nextInt();
            if (conditionNumberStopSimulation > 3 || conditionNumberStopSimulation <= 0) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_WRONG_COMMAND_NUMBER);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }

        System.out.println(BoxCharacteristicsObject.MESSAGE_THANKS_KEEP_WORKING);

        IslandMap.createIsland(x, y, predatorsNumber, herbivoresNumber, conditionNumberStopSimulation);
    }
}
