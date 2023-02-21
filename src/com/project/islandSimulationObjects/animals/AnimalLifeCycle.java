package com.project.islandSimulationObjects.animals;

import com.project.island.Cell;
import com.project.island.IslandMap;
import java.util.concurrent.*;

public class AnimalLifeCycle implements Runnable {
    public IslandMap islandMap = IslandMap.getIslandMap();

    public  CopyOnWriteArrayList<Animal> animals = islandMap.getAnimalList();
    public static CopyOnWriteArrayList<Callable<Void>> animalsCopy = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Callable<Void>> animalsCopy1 = new CopyOnWriteArrayList<>();
    public  volatile Cell[][] islandArray = islandMap.getIslandArray();;





    public int age;
    private static AnimalLifeCycle instance;

    private AnimalLifeCycle() {


    }


    public static AnimalLifeCycle getAnimalLifeCycle() {

        if (instance == null) {
            instance = new AnimalLifeCycle();
        }
        return instance;
    }


    public synchronized void run() {
        synchronized (System.out) {
            System.out.println("Start AnimalLiveCycle");

            animalsCopy.clear();
            animalsCopy1.clear();

            animalsCopy.addAll(animals);
            animalsCopy1.addAll(animals);

            System.out.println(animals.size());
        }
        ExecutorService executorService = Executors.newFixedThreadPool(animalsCopy.size());


        for (Animal animal : animals) {
            age = animal.getAge() + 1;
            animal.setAge(age);
        }


        for (Callable task : animalsCopy1) {
            int IndexAnimalTask = ThreadLocalRandom.current().nextInt(animalsCopy.size()) % animalsCopy.size();

            executorService.submit(animalsCopy.get(IndexAnimalTask));

            animalsCopy.remove(IndexAnimalTask);

        }
        executorService.shutdown();
    }
}

