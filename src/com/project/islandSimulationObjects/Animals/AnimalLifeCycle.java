package com.project.islandSimulationObjects.Animals;

import com.project.island.Island;

import java.util.List;
import java.util.concurrent.*;

public class AnimalLifeCycle implements Runnable {
    public Island island = Island.getIsland();

    public static CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public static CopyOnWriteArrayList<Callable<Void>> animalsCopy = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Callable<Void>> animalsCopy1 = new CopyOnWriteArrayList<>();
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
        System.out.println("Start AnimalLiveCycle");
        System.out.println("Animallive" + animals.size());
        animalsCopy.clear();
        //executorService.shutdown(); animals.size()
        animalsCopy.addAll(animals);
        ExecutorService executorService = Executors.newFixedThreadPool(animalsCopy.size());
        System.out.println("Start AnimalLiveCycle000000000");
        System.out.println(animals.size());
      //  System.out.println(animalsCopy.size());
        for (Animal animal : animals) {
            age = animal.getAge() + 1;
            animal.setAge(age);
        }
        int count = 0;

        // for (Animal task : animals) {
        //  task.isHunger = true;

        //  }


        //   for (Callable task : animals) {
        // try {
        // try {
        //  List<Future<Void>> futures = executorService.invokeAll(animalsCopy1);
        //   for (Future<Void> future : futures) {
        //    future.get();
        // }
        // } catch (InterruptedException | ExecutionException e) {
        //  throw new RuntimeException(e);

        // }

        //     } catch (InterruptedException | ExecutionException e) {
        //        throw new RuntimeException(e);
        //  } finally {
        //    executorService.shutdown();
        // }
        System.out.println("Start AnimalLiveCycleiuoiuio");
        //int IndexAnimalTask = ThreadLocalRandom.current().nextInt(animalsCopy.size()) % animalsCopy.size();
        for (Callable task : animals) {

            {
                //// Runnable animalTask = animalsCopy.get(IndexAnimalTask);
                executorService.submit(task);
            }
        }
        executorService.shutdown();
    }

}
          // count++;
           //animalsCopy.remove(IndexAnimalTask);

          //   try {
           //  executorService.awaitTermination(40, TimeUnit.SECONDS);
         //   } catch (InterruptedException e) {
           //     throw new RuntimeException(e);
          //   }




      //  }
       // System.out.println("Start AnimalLiveCycleiuoiuio"+count);
     //executorService.shutdown();

   // }
