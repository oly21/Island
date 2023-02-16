package com.project;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.IslandMap;
import com.project.island.StartingIslandSimulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IslandSimulationLoader {

    public void processingInput()  {


        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_X);
            IslandMap.x = scanner.nextInt();
            if (IslandMap.x  < 10|| IslandMap.x>50) {
               System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
                throw new InputMismatchException();
           }

        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }

        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_Y);
            IslandMap.y = scanner.nextInt();
            if (IslandMap.y  < 10|| IslandMap.y>50) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }


        int numberOfSimulationItems = ((IslandMap.x * IslandMap.y) - ((IslandMap.x * IslandMap.y) / 4)) / 41;
        //(predatorsNumber*9) +(herbivoresNumber*6)+(herbivoresNumber*10)


        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_ENTER_NUMBER_OF_ANIMALS +
                    " " + numberOfSimulationItems);
            IslandMap.predatorsNumber = scanner.nextInt();
            if (IslandMap.predatorsNumber > numberOfSimulationItems) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_TOO_MANY_ANIMALS + numberOfSimulationItems);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }


        IslandMap.herbivoresNumber = IslandMap.predatorsNumber * 2;


        try {
            System.out.println(BoxCharacteristicsObject.MESSAGE_STOPPING_CONDITION);
            IslandMap.conditionNumberStopSimulation = scanner.nextInt();
            if (IslandMap.conditionNumberStopSimulation > 3 || IslandMap.conditionNumberStopSimulation <= 0) {
                System.out.println(BoxCharacteristicsObject.MESSAGE_WRONG_COMMAND_NUMBER);
                throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println(BoxCharacteristicsObject.MESSAGE_INPUT_INCORRECT);
            throw new InputMismatchException();
        }

        System.out.println(BoxCharacteristicsObject.MESSAGE_THANKS_KEEP_WORKING);
        IslandMap.getIsland();
        loadingProgram();
    }

    public void loadingProgram()  {
        StartingIslandSimulation islandSimulation = StartingIslandSimulation.getIslandSimulation();
        islandSimulation.startSimulation();
    }
}