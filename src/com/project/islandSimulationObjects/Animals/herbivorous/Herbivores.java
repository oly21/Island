package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Herbivores extends Animal {
    private  final String typePicture = "🐻";
    private final String type = "IslandSimulationObject";
    private final List<String> initialList = Arrays.asList("Rabbit", "Mouse");
    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
    public Label label = new Label(typePicture);

    public Herbivores() {

    }

    public abstract Coordinate getXY();



}
