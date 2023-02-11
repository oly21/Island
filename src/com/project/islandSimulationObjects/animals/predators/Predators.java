package com.project.islandSimulationObjects.animals.predators;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.animals.Animal;
import com.project.islandSimulationObjects.animals.omnivores.Boar;

import java.util.concurrent.ConcurrentHashMap;

public abstract class Predators extends Animal {

    protected volatile int count = 0;
    public final ConcurrentHashMap<String, Double> chanceToEat = new ConcurrentHashMap<>();


    protected synchronized void initializationMapChanceToEat() {
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_BOA, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_BOA);

    }
    public synchronized ConcurrentHashMap<String, Double> getMapChanceToEat() {
        if (this.count == 0) {
            this.initializationMapChanceToEat();
            this.count++;
        }

        return this.chanceToEat;
    }
    @Override
    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Boar.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return numberAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Boar.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }
    @Override
    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }

    @Override
    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Boar.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }
}
