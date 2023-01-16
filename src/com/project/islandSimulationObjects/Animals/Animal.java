

package com.project.islandSimulationObjects.Animals;

import com.project.island.*;

import java.util.ArrayList;
import java.util.concurrent.*;

import com.project.islandSimulationObjects.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.Animals.herbivorous.*;
import com.project.islandSimulationObjects.Plants.Plant;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal implements IslandSimulationObject, Callable<Void> {

    public static volatile CopyOnWriteArrayList<Coordinate> freeCells = IslandSimulation.getListFreeCells();
    public static volatile CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public static volatile CopyOnWriteArrayList<Plant> plants = Island.getPlantList();
    // public static PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();

    public static Island island = Island.getIsland();
    public static volatile IslandSimulationObject[][] islandArray;

    static {

        islandArray = Island.getIslandArray();

    }

    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;
    private ArrayList<Coordinate> neighboringCells = new ArrayList<>();
    // boolean isHunger = true;

    public abstract boolean getIsHunger();

    public abstract void setIsHunger(boolean isHunger);

    // private boolean eat = false;

    public abstract boolean getEat();

    public ConcurrentHashMap<String, Double> chanceToEatMap = new ConcurrentHashMap<>();

    public abstract CopyOnWriteArrayList<String> getFoodStuffs();


    public abstract void setEat(boolean eat);

    //  private int progeny = 0;

    public abstract int getProgeny();

    public abstract void setProgeny(int progeny);

    //   private int eatenKg = 0;

    public abstract int getEatenKg();

    public abstract void setEatenKg(int eatenKg);

    public static volatile int limitRightY = Island.y - 1;
    public static volatile int limitLeftY = 0;
    public static volatile int LimitUpX = 0;
    public static volatile int limitDownX = Island.x - 1;


    public static volatile AtomicInteger numberAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberAnimalMoves = new AtomicInteger(0);
    public static volatile AtomicInteger numberEatenPlants = new AtomicInteger(0);
    public static volatile AtomicInteger numberPlants = new AtomicInteger(0);
    public static volatile AtomicInteger numberTask = new AtomicInteger(0);

    public static volatile AtomicInteger runStart = new AtomicInteger(0);
    public static volatile AtomicInteger runFinish = new AtomicInteger(0);

    public static volatile AtomicInteger startHavingVitality = new AtomicInteger(0);
    public static volatile AtomicInteger finishHavingVitality = new AtomicInteger(0);
    public static volatile AtomicInteger finishDeathFromOldAge = new AtomicInteger(0);
    public static volatile AtomicInteger startDeathFromOldAge = new AtomicInteger(0);

    public static volatile AtomicInteger startGet = new AtomicInteger(0);
    public static volatile AtomicInteger finishGet = new AtomicInteger(0);
    public static volatile AtomicInteger startEat = new AtomicInteger(0);
    public static volatile AtomicInteger finishEat = new AtomicInteger(0);
    public static volatile AtomicInteger startMove = new AtomicInteger(0);
    public static volatile AtomicInteger finishMove = new AtomicInteger(0);






    public static volatile AtomicInteger startSwapPlacesWithNeighbor = new AtomicInteger(0);
    public static volatile AtomicInteger finishSwapPlacesWithNeighbor = new AtomicInteger(0);
    public static volatile AtomicInteger startSetPositionForNewbornAnimal = new AtomicInteger(0);
    public static volatile AtomicInteger finishSetPositionForNewbornAnimal = new AtomicInteger(0);
    public static volatile AtomicInteger startDecreaseTheNumberOfOneTypeOfAnimal = new AtomicInteger(0);
    public static volatile AtomicInteger finishDecreaseTheNumberOfOneTypeOfAnimal = new AtomicInteger(0);
    public static volatile AtomicInteger startChoiceDirectionForMoveAndCallMove = new AtomicInteger(0);
    public static volatile AtomicInteger finishChoiceDirectionForMoveAndCallMove= new AtomicInteger(0);
    public static volatile AtomicInteger startR = new AtomicInteger(0);
    public static volatile AtomicInteger finishR = new AtomicInteger(0);
    public static volatile AtomicInteger startM2 = new AtomicInteger(0);
    public static volatile AtomicInteger finishM2 = new AtomicInteger(0);
    public static volatile AtomicInteger startIf = new AtomicInteger(0);
    public static volatile AtomicInteger finishIf = new AtomicInteger(0);
    public static volatile AtomicInteger startFor = new AtomicInteger(0);
    public static volatile AtomicInteger finishFor = new AtomicInteger(0);
    public static volatile AtomicInteger startFood = new AtomicInteger(0);
    public static volatile AtomicInteger finishFood = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornBoar = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornBuffalo = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornCaterpillar = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornBear = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornDeer = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornDuck = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornGoat = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornHorse = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornMouse = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornRabbit = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornSheep = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornBoa = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornEagle = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornFox = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornWolf = new AtomicInteger(0);


    public static volatile AtomicInteger numberDeadBoar = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadBuffalo = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadCaterpillar = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadBear = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadDeer = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadDuck = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadGoat = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadHorse = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadMouse = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadRabbit = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadSheep = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadBoa = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadEagle = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadFox = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadWolf = new AtomicInteger(0);


    public static volatile AtomicInteger numberBoars = new AtomicInteger(0);
    public static volatile AtomicInteger numberBuffalo = new AtomicInteger(0);
    public static volatile AtomicInteger numberCaterpillars = new AtomicInteger(0);
    public static volatile AtomicInteger numberBears = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeer = new AtomicInteger(0);
    public static volatile AtomicInteger numberDucks = new AtomicInteger(0);
    public static volatile AtomicInteger numberGoats = new AtomicInteger(0);
    public static volatile AtomicInteger numberHorses = new AtomicInteger(0);
    public static volatile AtomicInteger numberMouses = new AtomicInteger(0);
    public static volatile AtomicInteger numberRabbits = new AtomicInteger(0);
    public static volatile AtomicInteger numberSheep = new AtomicInteger(0);
    public static volatile AtomicInteger numberBoas = new AtomicInteger(0);
    public static volatile AtomicInteger numberEagles = new AtomicInteger(0);
    public static volatile AtomicInteger numberFoxes = new AtomicInteger(0);
    public static volatile AtomicInteger numberWolfs = new AtomicInteger(0);


    public abstract int getDaysWithoutFood();


    public abstract void setDaysWithoutFood(int daysWithoutFood);


    public abstract int getCountDays();


    public abstract void setCountDays(int countDays);


    public abstract int getDailyMealCounter();


    public abstract void setDailyMealCounter(int dailyMealCounter);
    // private  volatile int  hungryDaysCounter = 0;

    public abstract int getHungryDaysCounter();


    public abstract void setHungryDaysCounter(int hungryDaysCounter);
    //private volatile int attemptsFindPartnerCounter = 0;


    public abstract int getAttemptsFindPartnerCounter();


    public abstract void setAttemptsFindPartnerCounter(int attemptsFindPartnerCounter);

    public abstract int getX();

    public abstract int getY();

    public abstract void setXY(int x, int y);

    public abstract int getWeight();

    public abstract int getAge();

    public abstract void setAge(int age);

    public abstract int getStep();

    public abstract String getTypePicture();

    public abstract String getTypeString();


    public abstract int getNeededFoodKg();

    public abstract Coordinate getXY();

    public abstract int getProgenyLimit();

    public abstract boolean getStop();

    public abstract void setStop(boolean stop);

    public static volatile AtomicInteger deathFromStarvation = new AtomicInteger(0);
    public static volatile AtomicInteger deathFromOldAge = new AtomicInteger(0);

    public Void call() {
        runStart.incrementAndGet();

        this.setCountDays(this.getCountDays() + 1);
        if (this.getCountDays() % 2 == 0) {
            //System.out.println(" SET progony" +this.getProgeny());
            this.setProgeny(0);
            // System.out.println("AFTER SET"+ this.getProgeny());
        }


        this.setDailyMealCounter(0);
        this.setAttemptsFindPartnerCounter(0);
        //  System.out.println(this.getProgeny());
        //  System.out.println(this.getEat());
        //this.setEat(false);
        //  System.out.println("after set eat"+this.getEat());
        // System.out.println("run start"+ this.getCountDays());
        // System.out.println("Animal method" + animals.size());
        //&& this.getIsHunger()
        if (this.getStop()) {
            System.out.println(" остановлена" + this.getX() + this.getStop() + animals.contains(this) );
        }

        if (!this.getStop() && !deathFromOldAge()) {

            // System.out.println("не остановлена");
            this.eat();

            if (!this.getEat()) {
                this.setDaysWithoutFood(this.getDaysWithoutFood() + 1);
            }

            if (this.getIsHunger()) {
                this.setHungryDaysCounter(this.getHungryDaysCounter() + 1);
            }
            //havingVitality();
        }


//

        if ((!this.getStop() && havingVitality() && !deathFromOldAge())) {
            if (this instanceof Predators) {
                // if (!this.getStop() && (this.progeny < this.getProgenyLimit()) && this.getAge() >= 2 && (checkNumberAnimalsOfAParticularSpecies(this)) < Island.x + 20 ) {
                if (!this.getStop()) {
                    // if (this.getEat() || !this.getIsHunger()) {
                    this.reproduce();
                    //  }
                }
            } else {
                // if (!this.getStop() && this.progeny < this.getProgenyLimit() && numberPlants.get() > 50 && this.getAge() >= 2 && (checkNumberAnimalsOfAParticularSpecies(this)) < (Island.x)) {
                if (!this.getStop()) {
                    // if (this.getEat() || !this.getIsHunger()) {
                    this.reproduce();
                    //   }


                }
            }
        }

        if (!this.getStop() && !this.getEat() && freeCells.size() != 0) {
            choiceDirectionForMoveAndCallMove();
            numberAnimalMoves.incrementAndGet();
        }
        if (!this.getStop() && freeCells.size() == 0) {
            swapPlacesWithNeighbor();
            numberAnimalMoves.incrementAndGet();
        }

        runFinish.incrementAndGet();
        //  System.out.println("run finish"+this.getCountDays());

        return null;
    }


    public void eat() {
        this.setEat(false);
        this.setDailyMealCounter(this.getDailyMealCounter() + 1);
        startEat.incrementAndGet();
        Double chanceToEat = 1.0;


        neighboringCells = getListNeighboringCells();
        startFor.incrementAndGet();
        if (!this.getStop()) {
            synchronized (islandArray) {
                for (Coordinate coordinate1 : neighboringCells) {

                    int x = coordinate1.getX();
                    int y = coordinate1.getY();
                    if (!this.getStop()) {
                        if (!this.getStop() && islandArray[x][y] != null) {


                            if (this.getFoodStuffs().contains(islandArray[x][y].getTypeString())) {
                                if (islandArray[x][y] instanceof Animal) {
                                    if (!((Animal) islandArray[x][y]).getStop()) {
                                    } else {
                                        continue;
                                    }
                                }
                                if (this instanceof Predators) {
                                    // if  (( (Animal) islandArray[x][y]).getStop() == false){
                                    // }
                                    if (chanceToEatMap.containsKey(this)) {
                                        chanceToEatMap = (((Predators) this).getMapChanceToEat());
                                        chanceToEat = chanceToEatMap.get(islandArray[x][y].getTypeString());
                                    }
                                }
                                if (ThreadLocalRandom.current().nextDouble(0, 1) < chanceToEat) {


                                    this.setEatenKg(this.getEatenKg() + islandArray[x][y].getWeight());
                                    if (this.getEatenKg() < this.getNeededFoodKg()) {
                                        this.setIsHunger(true);

                                    } else {
                                        this.setIsHunger(false);
                                    }


                                    // if (this.getEatenKg() <= this.getNeededFoodKg()%2) {
                                    //    this.setIsHunger(true);

                                    //   }

                                    //   else{
                                    //      this.setIsHunger(false);
                                    //   }

                                    this.setEat(true);
                                    //System.out.println(" islandSimulationObjects"+ islandSimulationObjects.size());
                                    islandSimulationObjects.remove(islandArray[x][y]);
                                    //   System.out.println(" After delete islandSimulationObjects"+ islandSimulationObjects.size());
                                    if (islandArray[x][y] instanceof Animal) {
                                        decreaseTheNumberOfOneTypeOfAnimal((Animal) islandArray[x][y]);
                                        numberAnimals.decrementAndGet();
                                        numberDeadAnimals.incrementAndGet();
                                        // System.out.println(" animals" + animals.size());
                                        animals.remove(islandArray[x][y]);
                                        //   System.out.println("animals after" + animals.size());
                                        //  System.out.println(" остановлена now" + this.getX() + this.getStop() + animals.contains(this));
                                        Animal animal = (Animal) islandArray[x][y];
                                        // System.out.println("stop"+((Animal) islandArray[x][y]).getStop() );
                                        animal.setStop(true);
                                        // System.out.println("stop after"+ ((Animal) islandArray[x][y]).getStop());
                                    } else {
                                        numberPlants.decrementAndGet();
                                        numberEatenPlants.incrementAndGet();
                                        //System.out.println(" plants"+ plants.size());
                                        plants.remove(islandArray[x][y]);
                                        // System.out.println("plants after"+ plants.size());
                                    }
                                    islandArray[x][y].setXY(-1, -1);
                                   // startMove.incrementAndGet();
                                    this.move(coordinate1, this);

                                    //   finishMove.incrementAndGet();

                                    break;

                                }

                                //}


                                // }
                            }

                        }

                    } else {
                        break;
                    }
                }

            }
        }
        finishFor.incrementAndGet();
        finishEat.incrementAndGet();
    }

    public void reproduce() {
        startR.incrementAndGet();
        neighboringCells = getListNeighboringCells();
        startFor.incrementAndGet();
        if (!this.getStop()) {
            synchronized (islandArray) {
                // synchronized (freeCells) {
                for (Coordinate coordinate1 : neighboringCells) {

                    int x = coordinate1.getX();
                    int y = coordinate1.getY();
                    if (!this.getStop()) {
                        if (!this.getStop() && islandArray[x][y] instanceof Animal && !((Animal) islandArray[x][y]).getStop()) {

                            if (islandArray[x][y] != null) {
                                if (this.getTypeString().equals(islandArray[x][y].getTypeString())) {
                                    //progeny < 2 &&
                                    if (freeCells.size() > 0) {
                                        // Animal animalCopy;
                                        // System.out.println("reproduce " + this);
                                        if (this instanceof Fox) {

                                            //System.out.println("reproduceFox " + this);
                                            // animalCopy = new Fox(1, 1);
                                            animals.add(new Fox(1, 1));
                                            numberBornFox.incrementAndGet();
                                            numberFoxes.incrementAndGet();
                                        } else if (this instanceof Boa) {
                                            // animalCopy = new Boa(1, 1);
                                            // System.out.println("reproduceBoa " + this);
                                            // System.out.println("reproduceBoa100 " + this);
                                            animals.add(new Boa(1, 1));
                                            numberBornBoa.incrementAndGet();
                                            numberBoas.incrementAndGet();
                                        } else if (this instanceof Buffalo) {
                                            // animalCopy = new Buffalo(1, 1);
                                            animals.add(new Buffalo(1, 1));
                                            numberBornBuffalo.incrementAndGet();
                                            numberBuffalo.incrementAndGet();
                                        } else if (this instanceof Caterpillar) {
                                            //animalCopy = new Caterpillar(1, 1);
                                            animals.add(new Caterpillar(1, 1));
                                            numberBornCaterpillar.incrementAndGet();
                                            numberCaterpillars.incrementAndGet();
                                        } else if (this instanceof Deer) {
                                            // animalCopy = new Deer(1, 1);
                                            animals.add(new Deer(1, 1));
                                            numberBornDeer.incrementAndGet();
                                            numberDeer.incrementAndGet();
                                        } else if (this instanceof Horse) {
                                            // animalCopy = new Horse(1, 1);
                                            animals.add(new Horse(1, 1));
                                            numberBornHorse.incrementAndGet();
                                            numberHorses.incrementAndGet();
                                        } else if (this instanceof Bear) {
                                            //animalCopy = new Bear(1, 1);
                                            animals.add(new Bear(1, 1));
                                            numberBornBear.incrementAndGet();
                                            numberBears.incrementAndGet();
                                        } else if (this instanceof Eagle) {
                                            // animalCopy = new Eagle(1, 1);
                                            animals.add(new Eagle(1, 1));
                                            numberBornEagle.incrementAndGet();
                                            numberEagles.incrementAndGet();
                                        } else if (this instanceof Wolf) {
                                            //animalCopy = new Wolf(1, 1);
                                            animals.add(new Wolf(1, 1));
                                            numberBornWolf.incrementAndGet();
                                            numberWolfs.incrementAndGet();
                                        } else if (this instanceof Boar) {
                                            //animalCopy = new Boar(1, 1);
                                            animals.add(new Boar(1, 1));
                                            numberBornBoar.incrementAndGet();
                                            numberBoars.incrementAndGet();
                                        } else if (this instanceof Rabbit) {
                                            //animalCopy = new Rabbit(1, 1);
                                            animals.add(new Rabbit(1, 1));
                                            numberBornRabbit.incrementAndGet();
                                            numberRabbits.incrementAndGet();
                                        } else if (this instanceof Duck) {
                                            // animalCopy = new Duck(1, 1);
                                            animals.add(new Duck(1, 1));
                                            numberBornDuck.incrementAndGet();
                                            numberDucks.incrementAndGet();
                                        } else if (this instanceof Goat) {
                                            //animalCopy = new Goat(1, 1);
                                            animals.add(new Goat(1, 1));
                                            numberBornGoat.incrementAndGet();
                                            numberGoats.incrementAndGet();
                                        } else if (this instanceof Mouse) {
                                            // animalCopy = new Mouse(1, 1);
                                            animals.add(new Mouse(1, 1));
                                            numberBornMouse.incrementAndGet();
                                            numberMouses.incrementAndGet();
                                        } else if (this instanceof Sheep) {
                                            //animalCopy = new Sheep(1, 1);
                                            // System.out.println("reproduce8 " + animals.get(animals.size()));
                                            animals.add(new Sheep(1, 1));
                                            //System.out.println("reproduce10 " + animals.get(animals.size()));
                                            numberBornSheep.incrementAndGet();
                                            numberSheep.incrementAndGet();
                                        } else {
                                            break;
                                        }
                                        numberAnimals.incrementAndGet();
                                        numberBornAnimals.incrementAndGet();


                                        islandSimulationObjects.add(animals.get(animals.size() - 1));
                                        //System.out.println("reproduce0 " + animals.get(animals.size()-1));

                                        for (Coordinate freeCell : freeCells) {

                                            setPositionForNewbornAnimal(freeCell, animals.get(animals.size() - 1));

                                            freeCells.remove(freeCell);
                                            break;
                                        }


                                    } else {
                                        break;
                                    }

                                    break;
                                }


                            }
                        }
                    } else {
                        break;
                    }
                }

                // }
            }

        }
        finishFor.incrementAndGet();
        finishR.incrementAndGet();
    }

    public void choiceDirectionForMoveAndCallMove() {

        startChoiceDirectionForMoveAndCallMove.incrementAndGet();

        neighboringCells = getListNeighboringCells();
        if (!this.getStop()) {
            for (Coordinate coordinate : neighboringCells) {
                if (!this.getStop()) {
                   if(freeCells.size()>0) {
                       if (freeCells.contains(coordinate)) {

                           move(coordinate, this);
                           freeCells.remove(coordinate);
                           break;
                       }

                   }
                else{
                    break;
                   }
                } else {
                    break;
                }

            }
        }
        // neighboringCells = getListNeighboringCells();
        finishChoiceDirectionForMoveAndCallMove.incrementAndGet();
    }


    public void decreaseTheNumberOfOneTypeOfAnimal(Animal animal) {
     startDecreaseTheNumberOfOneTypeOfAnimal.incrementAndGet();
        if (animal instanceof Fox) {
            numberDeadFox.incrementAndGet();
            numberFoxes.decrementAndGet();
        } else if (this instanceof Boa) {
            numberDeadBoa.incrementAndGet();
            numberBoas.decrementAndGet();
        } else if (animal instanceof Buffalo) {
            numberDeadBuffalo.incrementAndGet();
            numberBuffalo.decrementAndGet();
        } else if (animal instanceof Caterpillar) {
            numberDeadCaterpillar.incrementAndGet();
            numberCaterpillars.decrementAndGet();
        } else if (animal instanceof Deer) {
            numberDeadDeer.incrementAndGet();
            numberDeer.decrementAndGet();
        } else if (animal instanceof Horse) {
            numberDeadHorse.incrementAndGet();
            numberHorses.decrementAndGet();
        } else if (animal instanceof Bear) {
            numberDeadBear.incrementAndGet();
            numberBears.decrementAndGet();
        } else if (animal instanceof Eagle) {
            numberDeadEagle.incrementAndGet();
            numberEagles.decrementAndGet();
        } else if (animal instanceof Wolf) {
            numberDeadWolf.incrementAndGet();
            numberWolfs.decrementAndGet();
        } else if (animal instanceof Boar) {
            numberDeadBoar.incrementAndGet();
            numberBoars.decrementAndGet();
        } else if (animal instanceof Rabbit) {
            numberDeadRabbit.incrementAndGet();
            numberRabbits.decrementAndGet();
        } else if (animal instanceof Duck) {
            numberDeadDuck.incrementAndGet();
            numberDucks.decrementAndGet();
        } else if (animal instanceof Goat) {
            numberDeadGoat.incrementAndGet();
            numberGoats.decrementAndGet();
        } else if (animal instanceof Mouse) {
            numberDeadMouse.incrementAndGet();
            numberMouses.decrementAndGet();
        } else if (animal instanceof Sheep) {
            numberDeadSheep.incrementAndGet();
            numberSheep.decrementAndGet();
        }
        finishDecreaseTheNumberOfOneTypeOfAnimal.incrementAndGet();

    }

    public int checkNumberAnimalsOfAParticularSpecies(Animal animal) {

        if (animal instanceof Fox) {
            return numberFoxes.get();

        } else if (this instanceof Boa) {
            return numberBoas.get();

        } else if (animal instanceof Buffalo) {
            return numberBuffalo.get();

        } else if (animal instanceof Caterpillar) {
            return numberCaterpillars.get();
        } else if (animal instanceof Deer) {
            return numberDeer.get();
        } else if (animal instanceof Horse) {
            return numberHorses.get();
        } else if (animal instanceof Bear) {
            return numberBears.get();
        } else if (animal instanceof Eagle) {
            return numberEagles.get();
        } else if (animal instanceof Wolf) {
            return numberWolfs.get();
        } else if (animal instanceof Boar) {
            return numberBoars.get();
        } else if (animal instanceof Rabbit) {
            return numberRabbits.get();
        } else if (animal instanceof Duck) {
            return numberDucks.get();
        } else if (animal instanceof Goat) {
            return numberGoats.get();
        } else if (animal instanceof Mouse) {
            return numberMouses.get();
        } else if (animal instanceof Sheep) {
            return numberSheep.get();
        } else {
            return 0;
        }
    }

    //public void increaseTheNumberOfOneTypeOfAnimal() {

    // }


    // public void Hunt() throws InstantiationException, IllegalAccessException {

    //  startHunt.incrementAndGet();


    // for (Coordinate Cells : neighboringCells) {
    //  startFor.incrementAndGet();

    // if (this.getStop()) {
    //  int x = Cells.getX();
    // int y = Cells.getY();

    //  if (!eat && progeny < 2 && islandArray[x][y] != null && this.getFoodStuffs().contains(islandArray[x][y].getTypeString())) {

    //       eat(islandArray[x][y], Cells);
    //  move(Cells, this);


    //   }


    //   if (islandArray[x][y].getTypeString().equals(this.getTypeString())) {
    //     reproduct(this);

    //  }
    //   }
    // else{
    //  break;

    //  }


    //  }
    //   finishFor.incrementAndGet();

    //  finishHunt.incrementAndGet();
    // }


    public ArrayList<Coordinate> getListNeighboringCells() {
        neighboringCells.clear();
        startGet.incrementAndGet();
        int xUp = this.getX();
        int yUp = this.getY();
        int xD = this.getX();
        int yD = this.getY();
        int xR = this.getX();
        int yR = this.getY();
        int xL = this.getX();
        int yL = this.getY();
        int j = 1;
        boolean coordinateHave = false;

        for (int i = 1; i < this.getStep() + 1; i++) {
            if (xD != limitDownX) {
                xD = xD + j;
                if (neighboringCells.size() == 0

                ) {

                    neighboringCells.add(new Coordinate(xD, yD));
                } else {

                    for (Coordinate coordinate : neighboringCells) {
                        if (coordinate.getX() == xD && coordinate.getY() == yD) {
                            coordinateHave = true;

                            break;
                        }


                    }
                    if (!coordinateHave) {
                        neighboringCells.add(new Coordinate(xD, yD));
                        coordinateHave = false;
                    }
                }
            }


            if (xUp != LimitUpX) {
                xUp = xUp - j;
                if (neighboringCells.size() == 0) {
                    neighboringCells.add(new Coordinate(xUp, yUp));
                } else {
                    for (Coordinate coordinate : neighboringCells) {
                        if (coordinate.getX() == xUp && coordinate.getY() == yUp) {
                            coordinateHave = true;
                            break;

                        }

                    }
                    if (!coordinateHave) {
                        neighboringCells.add(new Coordinate(xUp, yUp));
                        coordinateHave = false;
                    }
                }

            }


            if (yR != limitRightY) {
                yR = yR + j;
                if (neighboringCells.size() == 0) {
                    neighboringCells.add(new Coordinate(xR, yR));
                } else {
                    for (Coordinate coordinate : neighboringCells) {
                        if (coordinate.getX() == xR && coordinate.getY() == yR) {
                            coordinateHave = true;
                            break;
                        }

                    }
                    if (!coordinateHave) {
                        neighboringCells.add(new Coordinate(xR, yR));
                        coordinateHave = false;
                    }
                }
            }

            if (yL != limitLeftY) {
                yL = yL - j;
                if (neighboringCells.size() == 0) {
                    neighboringCells.add(new Coordinate(xL, yL));
                } else {
                    for (Coordinate coordinate : neighboringCells) {
                        if (coordinate.getX() == xL && coordinate.getY() == yL) {
                            coordinateHave = true;
                            break;

                        }

                    }
                    if (!coordinateHave) {
                        neighboringCells.add(new Coordinate(xL, yL));
                        coordinateHave = false;
                    }
                }
            }

        }
        finishGet.incrementAndGet();
        return neighboringCells;

    }

    public void move(Coordinate coordinate, Animal animal) {
        startMove.incrementAndGet();
        if (!this.getStop()) {

            int x = this.getX();
            int y = this.getY();
            this.setXY(coordinate.getX(), coordinate.getY());
            if (!this.getStop()) {
                islandArray[coordinate.getX()][coordinate.getY()] = animal;
                islandArray[x][y] = null;
                // System.out.println("islandArray[x][y] "+ islandArray[x][y]);
                freeCells.add(new Coordinate(x, y));
                //neighboringCells=getListNeighboringCells();
            }

        }
        finishMove.incrementAndGet();
    }

    public void setPositionForNewbornAnimal(Coordinate coordinate, Animal animal) {
        startSetPositionForNewbornAnimal.incrementAndGet();

        //     if (!this.getStop()) {
        animal.setXY(coordinate.getX(), coordinate.getY());
        islandArray[coordinate.getX()][coordinate.getY()] = animal;


        //  }
        finishSetPositionForNewbornAnimal.incrementAndGet();
    }

    public void swapPlacesWithNeighbor() {
        startSwapPlacesWithNeighbor.incrementAndGet();
        if (!this.getStop()) {
            synchronized (islandArray) {


                neighboringCells = getListNeighboringCells();
                if (!this.getStop()) {
                    for (Coordinate coordinate : neighboringCells) {
                        if (!this.getStop()) {
                            if (!this.getStop() && islandArray[coordinate.getX()][coordinate.getY()] != null) {
                                int x = this.getX();

                                int y = this.getY();


                                islandArray[x][y] = islandArray[coordinate.getX()][coordinate.getY()];
                                islandArray[x][y].setXY(x, y);
                                islandArray[coordinate.getX()][coordinate.getY()] = this;
                                this.setXY(coordinate.getX(), coordinate.getY());
                                break;
                            } else {
                                break;
                            }

                        } else {
                            break;
                        }
                    }
                }

            }
        }
        finishSwapPlacesWithNeighbor.incrementAndGet();
    }

    public boolean havingVitality() {
        startHavingVitality.incrementAndGet();
        if (this.getCountDays() % 2 == 0 && this.getCountDays() != 0 || this.getCountDays() % 5 == 0 && this.getCountDays() != 0) {
            // System.out.println("четные дни" + this.getCountDays());
            //  System.out.println("дней без еды" + this.getDaysWithoutFood());
            //   System.out.println("голодные дни " + this.getHungryDaysCounter());
            if (this.getDaysWithoutFood() >= 2 || this.getHungryDaysCounter() >= 5) {
                // System.out.println("2 дня без еды " + this.getCountDays());
                synchronized (islandArray) {

                    islandSimulationObjects.remove(this);

                    // System.out.println("animals "+ animals.size());
                    animals.remove(this);
                    islandArray[this.getX()][this.getY()] = null;
                    this.setStop(true);
                    freeCells.add(new Coordinate(this.getX(), this.getY()));
                    this.setXY(-1, -1);
                    // System.out.println("animals after "+ animals.size());
                    numberDeadAnimals.incrementAndGet();
                    deathFromStarvation.incrementAndGet();
                    numberAnimals.decrementAndGet();
                    decreaseTheNumberOfOneTypeOfAnimal(this);





                }
                finishHavingVitality.incrementAndGet();
                return false;
            } else {
                // System.out.println("h");
                if (this.getCountDays() % 2 == 0 && this.getCountDays() != 0) {
                    this.setDaysWithoutFood(0);
                    this.setIsHunger(true);
                    this.setEatenKg(0);
                } else if (this.getCountDays() % 5 == 0 & this.getCountDays() != 0) {
                    // System.out.println("h1");
                    this.setHungryDaysCounter(0);
                    this.setIsHunger(true);
                    this.setEatenKg(0);
                }
                finishHavingVitality.incrementAndGet();
                return true;
            }
        } else {
            finishHavingVitality.incrementAndGet();
            return true;
        }

    }

    public boolean deathFromOldAge() {
        startDeathFromOldAge.incrementAndGet();
        if (!this.getStop()) {
            if (this.getAge() >= 8) {
                if (!this.getStop()) {
                    synchronized (islandArray) {

                        animals.remove(this);

                        islandArray[this.getX()][this.getY()] = null;

                        this.setStop(true);
                        freeCells.add(new Coordinate(this.getX(), this.getY()));
                        this.setXY(-1, -1);

                        numberDeadAnimals.incrementAndGet();
                        deathFromOldAge.incrementAndGet();
                        numberAnimals.decrementAndGet();
                        decreaseTheNumberOfOneTypeOfAnimal(this);


                        islandSimulationObjects.remove(this);


                        finishDeathFromOldAge.incrementAndGet();
                        return true;
                    }
                }
                else {
                    finishDeathFromOldAge.incrementAndGet();
                    return false;
                }
            } else {
                finishDeathFromOldAge.incrementAndGet();
                return false;
            }
        }
        return true;
    }

}