package com.project.islandSimulationObjects.Animals;

import com.project.island.Island;
import java.util.concurrent.*;

public class AnimalLifeCycle implements Runnable {
    public Island island = Island.getIsland();

    public static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public static CopyOnWriteArrayList<Animal> animalsCopy = new CopyOnWriteArrayList<>();
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



    public void run() {

        animalsCopy.clear();
        //executorService.shutdown();
        animalsCopy.addAll(animals);
        ExecutorService executorService  = Executors.newFixedThreadPool(animals.size());
        System.out.println("Start AnimalLiveCycle");
        for (Animal animal : animals) {
            age = animal.getAge()+1;
            animal.setAge(age);
        }


        // for (Animal task : animals) {
        //  task.isHunger = true;

        //  }


        for (Runnable task : animalsCopy) {

           // int IndexAnimalTask = ThreadLocalRandom.current().nextInt(animalsCopy.size()) % animalsCopy.size();

           // Runnable animalTask = animalsCopy.get(IndexAnimalTask);
            executorService.submit(task);
           // animalsCopy.remove(IndexAnimalTask);


            // try {
            //  executorService.awaitTermination(40, TimeUnit.SECONDS);
            //} catch (InterruptedException e) {
            //    throw new RuntimeException(e);
            // }


            // executorService.shutdown();

        }
       executorService.shutdown();

    }
}