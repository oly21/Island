

        package com.project.islandSimulationObjects.Animals;

import com.project.island.*;

import java.util.ArrayList;
import java.util.concurrent.*;

import com.project.islandSimulationObjects.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.Animals.herbivorous.*;
import com.project.islandSimulationObjects.Plants.Plant;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal implements IslandSimulationObject, Runnable {
    public static volatile CopyOnWriteArrayList<Coordinate> freeCells = IslandSimulation.getListFreeCells();
    public static volatile CopyOnWriteArrayList<Animal> animals = IslandSimulation.animals;
    public static volatile CopyOnWriteArrayList<Plant> plants = Island.getPlantList();
    // public static PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();

    public static Island island = Island.getIsland();
    public static volatile IslandSimulationObject[][] islandArray = Island.getIslandArray();

    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;
    private ArrayList<Coordinate> neighboringCells = new ArrayList<>();
    public boolean isHunger = true;
    private boolean eat = false;
    private int progeny = 0;
    private int eatenKg = 0;
    public static volatile int limitRightY = Island.y - 1;
    public static volatile int limitLeftY = 0;
    public static volatile int LimitUpX = 0;
    public static volatile int limitDownX = Island.x - 1;


    public static volatile AtomicInteger numberAnimals = new AtomicInteger();
    public static volatile AtomicInteger numberDeadAnimals = new AtomicInteger();
    public static volatile AtomicInteger numberBornAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberAnimalMoves = new AtomicInteger(0);
    public static volatile AtomicInteger numberEatenPlants = new AtomicInteger(0);
    public static volatile AtomicInteger numberPlants = new AtomicInteger(plants.size());
    public static volatile AtomicInteger numberTask = new AtomicInteger(0);

    public static volatile AtomicInteger runStart = new AtomicInteger(0);
    public static volatile AtomicInteger runFinish = new AtomicInteger(0);
    public static volatile AtomicInteger startHunt = new AtomicInteger(plants.size());
    public static volatile AtomicInteger finishHunt = new AtomicInteger(0);

    public static volatile AtomicInteger startGet = new AtomicInteger(0);
    public static volatile AtomicInteger finishGet = new AtomicInteger(0);
    public static volatile AtomicInteger startEat = new AtomicInteger(0);
    public static volatile AtomicInteger finishEat = new AtomicInteger(0);
    public static volatile AtomicInteger startMove = new AtomicInteger(0);
    public static volatile AtomicInteger finishMove = new AtomicInteger(0);
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


    public abstract int getX();

    public abstract int getY();

    public abstract void setXY(int x, int y);

    public abstract int getWeight();

    public abstract int getAge();

    public abstract void setAge(int age);

    public abstract int getStep();

    public abstract String getTypePicture();

    public abstract String getTypeString();



    public abstract  CopyOnWriteArrayList<String> getFoodStuffs();

    public abstract int getNeededFoodKg();

    public abstract Coordinate getXY();

    public abstract int getProgenyLimit();

    public synchronized void run() {

        runStart.incrementAndGet();

        int AnimalMove = 0;
        isHunger = true;
        eat = false;
        //  while (isHunger || progeny < this.getProgenyLimit()) {

        try {
            Hunt();

        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        if (!eat && AnimalMove == 1) {

            startIf.incrementAndGet();
            move2();
            numberAnimalMoves.incrementAndGet();
            finishIf.incrementAndGet();
            AnimalMove++;
        }

        numberTask.incrementAndGet();
        //}
        runFinish.incrementAndGet();
    }

    public void eat(IslandSimulationObject islandSimulationObject, Coordinate coordinate) {
        //synchronized (islandArray) {
        startEat.incrementAndGet();
        // int xFood = coordinate.getX();
        // int yFood = coordinate.getY();
        eatenKg = eatenKg + islandSimulationObject.getWeight();
        eat = true;
        // }
        if (eatenKg == this.getNeededFoodKg() || eatenKg < 0) {
            isHunger = false;
        }
        islandSimulationObjects.remove(islandSimulationObject);
        islandSimulationObject.setXY(-1, -1);
        if (islandSimulationObject instanceof Animal) {
            numberAnimals.decrementAndGet();
            numberDeadAnimals.incrementAndGet();
            animals.remove(islandSimulationObject);

        } else {
            numberPlants.decrementAndGet();
            numberEatenPlants.incrementAndGet();
            plants.remove(islandSimulationObject);
        }

        finishEat.incrementAndGet();
    }

    public void reproduct(Animal animal) throws InstantiationException, IllegalAccessException {

        startR.incrementAndGet();
        if (progeny < 2) {
            Animal animalCopy = null;

            if (this instanceof Fox) {
                animalCopy = new Fox(1, 1);
                progeny++;
            } else if (this instanceof Buffalo) {
                animalCopy = new Buffalo(1, 1);
                progeny++;
            } else if (this instanceof Caterpillar) {
                animalCopy = new Caterpillar(1, 1);
                progeny++;
            } else if (this instanceof Deer) {
                animalCopy = new Deer(1, 1);
                progeny++;
            } else if (this instanceof Horse) {
                animalCopy = new Horse(1, 1);
                progeny++;
            } else if (this instanceof Bear) {
                animalCopy = new Bear(1, 1);
                progeny++;
            } else if (this instanceof Eagle) {
                animalCopy = new Eagle(1, 1);
                progeny++;
            } else if (this instanceof Wolf) {
                animalCopy = new Wolf(1, 1);
                progeny++;
            } else if (this instanceof Boar) {
                animalCopy = new Boar(1, 1);
                progeny++;
            } else if (this instanceof Rabbit) {
                animalCopy = new Rabbit(1, 1);
                this.progeny++;
            } else if (this instanceof Duck) {
                animalCopy = new Duck(1, 1);
                this.progeny++;
            } else if (this instanceof Goat) {
                animalCopy = new Goat(1, 1);
                this.progeny++;
            } else if (this instanceof Mouse) {
                animalCopy = new Mouse(1, 1);
                this.progeny++;
            } else if (this instanceof Sheep) {
                animalCopy = new Sheep(1, 1);
                this.progeny++;
            }

            numberAnimals.incrementAndGet();
            animals.add(animalCopy);
            numberBornAnimals.incrementAndGet();
            islandSimulationObjects.add(animalCopy);

            for (Coordinate freeCell : IslandSimulation.getListFreeCells()) {
                move10(freeCell, animalCopy);

                freeCells.remove(freeCell);
                break;
            }
        }


        finishR.incrementAndGet();
    }


    public void move2() {

        startM2.incrementAndGet();

        neighboringCells = getListNeighboringCells();
        for (Coordinate coordinate : neighboringCells) {
            if (freeCells.contains(coordinate)) {

                move(coordinate, this);
                freeCells.remove(coordinate);
                break;
            }

        }
        //  System.out.println("move2 завершена"+ " " +numberTask);
        finishM2.incrementAndGet();
    }


    public void Hunt() throws InstantiationException, IllegalAccessException {
        if (this.getX() == -1 || this.getY() == -1) {
            finishFor.incrementAndGet();
            finishHunt.incrementAndGet();
            return;
        }


        // System.out.println("start hunt"+ " " +numberTask);
        startHunt.incrementAndGet();
        neighboringCells = getListNeighboringCells();
        if (neighboringCells.size() >= 1) {
            for (Coordinate Cells : neighboringCells) {
                if (this.getX() == -1 || this.getY() == -1) {
                    break;
                }
                if (this.getX() == -1 || this.getY() == -1) {
                    return;
                }


                startFor.incrementAndGet();

                if (!eat || progeny < 1) {

                    int x = Cells.getX();
                    int y = Cells.getY();
                    if (this.getX() != -1 && this.getY() != -1) {
                        if (islandArray[x][y] != null) {

                            if (this.getFoodStuffs().contains(islandArray[x][y].getTypeString())) {
                                if (this.getX() == -1 || this.getY() == -1) {
                                    finishFor.incrementAndGet();
                                    break; //r
                                }

                                // synchronized (islandArray) {
                                if (islandArray[x][y] != null && this.getX() != -1 && this.getY() != -1) {

                                    if (this.getX() == -1 || this.getY() == -1) {
                                        finishFor.incrementAndGet();
                                        break;//r
                                    }

                                    if (islandArray[x][y] != null && this.getX() != -1 && this.getY() != -1) {
                                        eat(islandArray[x][y], Cells);
                                    }
                                    if (islandArray[x][y] != null && this.getX() != -1 && this.getY() != -1) {
                                        move(Cells, this);
                                        // neighboringCells = getListNeighboringCells();

                                    }

                                }

                            }
                        }

                        //  synchronized (islandArray) {
                        if (islandArray[x][y] != null && this.getX() != -1 && this.getY() != -1) {
                            if (islandArray[x][y].getTypeString().equals(this.getTypeString())) {
                                reproduct(this);

                            }
                        } //  }
                    }
                } else {
                    break;
                }


            }

        }


        finishFor.incrementAndGet();

        finishHunt.incrementAndGet();
    }


    public ArrayList<Coordinate> getListNeighboringCells() {

        startGet.incrementAndGet();
        int xUp = this.getX();
        int yUp = this.getY();
        int xD =this.getX();
        int yD = this.getY();
        int xR = this.getX();
        int yR = this.getY();
        int xL = this.getX();
        int yL = this.getY();
        int j = 1;
        boolean coordinateHave = false;

        for (int i = 1; i < this.getStep() + 1; i++) {
            if (xD != limitDownX) {
                xD = xD+j;
                if (neighboringCells.size() == 0

                ) {

                    neighboringCells.add(new Coordinate(xD, yD));
                } else {

                    for (Coordinate coordinate : neighboringCells) {
                        if (coordinate.getX() == xD &&coordinate.getY() == yD){
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
        int x = this.getX();

        int y = this.getY();
        this.setXY(coordinate.getX(), coordinate.getY());
        islandArray[coordinate.getX()][coordinate.getY()] = animal;
        islandArray[x][y] = null;
        freeCells.add(new Coordinate(x, y));

        finishMove.incrementAndGet();
    }

    public void move10(Coordinate coordinate, Animal animal) {
        startMove.incrementAndGet();

        animal.setXY(coordinate.getX(), coordinate.getY());
        islandArray[coordinate.getX()][coordinate.getY()] = animal;

        finishMove.incrementAndGet();
    }
}