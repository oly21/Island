package com.project;

import com.project.island.Island;
import com.project.island.IslandSimulation;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;
import java.util.Scanner;

//import javafx.animation.Animation;
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.collections.ListChangeListener;
//import javafx.scene.Scene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Pane;
//import javafx.stage.Stage;
//import javafx.util.Duration;

import java.io.InputStream;
import java.util.concurrent.*;
public  class Solution    {

    public static volatile CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();



    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;

    //public  static Island instance;
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, InstantiationException, IllegalAccessException, ExceptionInInitializerError {
         Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте вы запустили islandSimulation , для продолжения введите " +
                        " размеры острова, для начал" +
                "а пожалуйста введите x(целое число)");
        Island.x = scanner.nextInt();
        System.out.println(" теперь введите y");
        Island.y = scanner.nextInt();
        System.out.println("Вам также нужно ввести  начальное количество Predators каждого вида  " +
                "например если введете 10 то создастся 10 лис 10 волков и тд а  ");
        Island.predatorsNumber = scanner.nextInt();
        Island.herbivoresNumber  =  Island.predatorsNumber * 2;

        System.out.println("Выберите условие остановки симуляции " +
                "введите цыфру выброного вами условия: 1)На острове остались только predators(хишники) " +
                "2) сьели все растения " );

        Island.conditionNumberStopSimulation  = scanner.nextInt();
        System.out.println("Спасибо,islandSimulation продолжает свою работу ");
         Island island = Island.getIsland();
        IslandSimulation islandSimulation = IslandSimulation.getIslandSimulation();
        islandSimulation.startSimulation();

    }

}











