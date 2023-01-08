package com.project.islandSimulationObjects.Animals.predators;

import com.project.islandSimulationObjects.Animals.Animal;

import java.util.concurrent.ConcurrentHashMap;

public abstract class Predators extends Animal {
    public  abstract ConcurrentHashMap<String, Double> getMapChanceToEat();

}
