package com.project;

import com.project.island.Island;
import com.project.island.IslandSimulation;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.IslandSimulationObject;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;
import java.util.concurrent.*;
public  class Solution    {

    public static volatile CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public static volatile IslandSimulationObject[][] islandArray = Island.getIslandArray();

    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException, InstantiationException, IllegalAccessException, ExceptionInInitializerError {

        IslandSimulation islandSimulation = IslandSimulation.getIslandSimulation();
        islandSimulation.startSimulation();

    }

}











