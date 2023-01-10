

package com.project.islandSimulationObjects.Animals;

import com.project.island.*;

import java.util.ArrayList;
import java.util.concurrent.*;

import com.project.islandSimulationObjects.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.Animals.herbivorous.*;
import com.project.islandSimulationObjects.Plants.Plant;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal implements IslandSimulationObject, Runnable {

    public static volatile CopyOnWriteArrayList<Coordinate> freeCells = IslandSimulation.getListFreeCells();
    public static volatile CopyOnWriteArrayList<Animal> animals = IslandSimulation.animals;
    public static volatile CopyOnWriteArrayList<Plant> plants = Island.getPlantList();
    // public static PrintingIslandSimulationStatistics printingIslandSimulationStatistics = PrintingIslandSimulationStatistics.getPrintingIslandSimulationStatistics();
    public static volatile Pane root = JavaFXDisplay.getRoot();
    public static Island island = Island.getIsland();
    public static volatile IslandSimulationObject[][] islandArray;

    static {

        islandArray = Island.getIslandArray();

    }

    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;
    public static CopyOnWriteArrayList<Label> label = JavaFXDisplay.getLabelArray();
    public static volatile Label[][] labelArray = JavaFXDisplay.getLabelArray1();

    private CopyOnWriteArrayList<Coordinate> neighboringCells = new CopyOnWriteArrayList<>();
    public boolean isHunger = true;

    public abstract boolean getIsHunger();

    public abstract void setIsHunger(boolean isHunger);

    private boolean eat = false;

    public abstract boolean getEat();

    public ConcurrentHashMap<String, Double> chanceToEatMap = new ConcurrentHashMap<>();

    public abstract CopyOnWriteArrayList<String> getFoodStuffs();


    public abstract void setEat(boolean eat);

    private int progeny = 0;

    public abstract int getProgeny();

    public abstract void setProgeny(int progeny);

    private int eatenKg = 0;

    public abstract int getEatenKg();

    public abstract void setEatenKg(int eatenKg);

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


    public abstract int getNeededFoodKg();

    public abstract Coordinate getXY();

    public abstract int getProgenyLimit();

    public abstract boolean getStop();

    public abstract void setStop(boolean stop);


    public void run() {

        this.setEat(false);
        runStart.incrementAndGet();
        if (this.getStop() == false) {
            this.eat();
            if (this.getStop() == false) {
                this.reproduct();
            }

        }

        if (this.getStop() == false && this.getEat() == false) {
            choiceDirectionForMoveAndCallMove();
            numberAnimalMoves.incrementAndGet();
        }
        runFinish.incrementAndGet();
    }


    public void eat() {
        startEat.incrementAndGet();
        Double chanceToEat = 1.0;
        //synchronized (islandArray) {

        neighboringCells = getListNeighboringCells();
        startFor.incrementAndGet();
        for (Coordinate coordinate1 : neighboringCells) {

            int x = coordinate1.getX();
            int y = coordinate1.getY();
            if (this.getStop() == false && islandArray[x][y] != null) {


                if (this.getFoodStuffs().contains(islandArray[x][y].getTypeString())) {

                    if (this instanceof Predators) {
                        // if  (( (Animal) islandArray[x][y]).getStop() == false){
                        // }
                        chanceToEatMap = (((Predators) this).getMapChanceToEat());
                        chanceToEat = chanceToEatMap.get(islandArray[x][y].getTypeString());

                    }
                  //  if (ThreadLocalRandom.current().nextDouble(0, 1) < chanceToEat) {


                        this.setEatenKg(this.getEatenKg() + islandArray[x][y].getWeight());
                        // if (this.getEatenKg() <= this.getNeededFoodKg()%2) {
                        //    this.setIsHunger(true);

                        //   }

                        //   else{
                        //      this.setIsHunger(false);
                        //   }

                        this.setEat(true);
                        islandSimulationObjects.remove(islandArray[x][y]);


                        islandArray[x][y].setXY(-1, -1);

                        if (islandArray[x][y] instanceof Animal) {
                            numberAnimals.decrementAndGet();
                            numberDeadAnimals.incrementAndGet();
                            animals.remove(islandArray[x][y]);
                            Animal animal = (Animal) islandArray[x][y];
                            animal.setStop(true);

                        } else {
                            numberPlants.decrementAndGet();
                            numberEatenPlants.incrementAndGet();
                            plants.remove(islandArray[x][y]);
                        }
                        int count = 0;


                        startMove.incrementAndGet();





                      /*  for (int i = 0; i < label.size(); i++) {
                            if ((int) root.getChildren().get(i).getLayoutX() / 20 == this.getX() && (int) root.getChildren().get(i).getLayoutY() / 20 == this.getY()) {
                                if (this.getX() != coordinate1.getX())
                                    if (this.getX() > coordinate1.getX()) {
                                        count = this.getX() - coordinate1.getX();
                                    } else if (this.getX() < coordinate1.getX()) {
                                        count = coordinate1.getX() - this.getX();
                                    }

                                if (this.getY() != coordinate1.getY()) {
                                    if (this.getY() > coordinate1.getY()) {
                                        count = this.getY() - coordinate1.getY();
                                    } else if (this.getY() < coordinate1.getY()) {
                                        count = coordinate1.getY() - this.getY();
                                    }
                                }
                                for (int j = 1; j <= count; j++) {
                                    if (this.getX() != coordinate1.getX()) {
                                        if (this.getX() > coordinate1.getX()) {
                                            root.getChildren().get(i).setLayoutX(this.getX() - j);
                                        } else if (this.getX() < coordinate1.getX()) {
                                            root.getChildren().get(i).setLayoutX(this.getX() + j);
                                        }
                                        if (this.getY() != coordinate1.getY()) {
                                            if (this.getY() > coordinate1.getY()) {
                                                root.getChildren().get(i).setLayoutY(this.getY() - j);
                                            }
                                            } else if (this.getY() < coordinate1.getY()) {
                                            root.getChildren().get(i).setLayoutY(this.getY() + j);
                                        }
                                            }



                                    }
                                    //root.getChildren().get(i).setAccessibleText(islandArray[x][y].getTypeString());
                                break;
                                }
                            }
                      */ // }

                    labelArray[coordinate1.getX()][coordinate1.getY()]=labelArray[this.getX()][this.getY()];
                    labelArray[this.getX()][this.getY()]=null;

                    this.move(coordinate1, this);
                        //for (int i = 0; i < label.size(); i++) {
                          //  if ((int) root.getChildren().get(i).getLayoutX() / 20 == this.getX() && (int) root.getChildren().get(i).getLayoutY() / 20 == this.getY()) {
                              //  root.getChildren().get(i).setAccessibleText(islandArray[x][y].getTypeString());
                          // break;
                           // }

                      //  }

                        finishMove.incrementAndGet();

                        break;

                    }

                    //}


                    // }
                }

             else {
                break;
            }

        }

        finishFor.incrementAndGet();
        finishEat.incrementAndGet();
    }

    public void reproduct() {
        startR.incrementAndGet();
        neighboringCells = getListNeighboringCells();
        startFor.incrementAndGet();
        for (Coordinate coordinate1 : neighboringCells) {

            int x = coordinate1.getX();
            int y = coordinate1.getY();
            if (this.getStop() == false && islandArray[x][y] instanceof Animal && ((Animal) islandArray[x][y]).getStop() == false) {

                if (islandArray[x][y] != null) {
                    if (this.getFoodStuffs().contains(islandArray[x][y].getTypeString())) {
                        //progeny < 2 &&
                        if (freeCells.size() > 0) {
                            Animal animalCopy;

                            if (this instanceof Fox) {
                                animalCopy = new Fox(1, 1);
                                // progeny++;
                            } else if (this instanceof Buffalo) {
                                animalCopy = new Buffalo(1, 1);
                                // progeny++;
                            } else if (this instanceof Caterpillar) {
                                animalCopy = new Caterpillar(1, 1);
                                //  progeny++;
                            } else if (this instanceof Deer) {
                                animalCopy = new Deer(1, 1);
                                // progeny++;
                            } else if (this instanceof Horse) {
                                animalCopy = new Horse(1, 1);
                                //   progeny++;
                            } else if (this instanceof Bear) {
                                animalCopy = new Bear(1, 1);
                                // progeny++;
                            } else if (this instanceof Eagle) {
                                animalCopy = new Eagle(1, 1);
                                //  progeny++;
                            } else if (this instanceof Wolf) {
                                animalCopy = new Wolf(1, 1);
                                //   progeny++;
                            } else if (this instanceof Boar) {
                                animalCopy = new Boar(1, 1);
                                //  progeny++;
                            } else if (this instanceof Rabbit) {
                                animalCopy = new Rabbit(1, 1);
                                //   this.progeny++;
                            } else if (this instanceof Duck) {
                                animalCopy = new Duck(1, 1);
                                //   this.progeny++;
                            } else if (this instanceof Goat) {
                                animalCopy = new Goat(1, 1);
                                //  this.progeny++;
                            } else if (this instanceof Mouse) {
                                animalCopy = new Mouse(1, 1);
                                //  this.progeny++;
                            } else if (this instanceof Sheep) {
                                animalCopy = new Sheep(1, 1);
                                //  this.progeny++;
                            } else {
                                break;
                            }
                            Label label1 = new Label(this.getTypeString());



                            for (Coordinate freeCell : IslandSimulation.getListFreeCells()) {
                                setPositionForNewbornAnimal(freeCell, animalCopy);
                                label1.setLayoutX(freeCell.getX() * 20);
                                label1.setLayoutY(freeCell.getY() * 20);
                                root.getChildren().add(label1);
                                label.add(label1);
                                labelArray[freeCell.getX()][freeCell.getY()]=label1 ;
                                freeCells.remove(freeCell);
                                break;
                            }
                            numberAnimals.incrementAndGet();

                            animals.add(animalCopy);
                            numberBornAnimals.incrementAndGet();


                            islandSimulationObjects.add(animalCopy);
                        } else {
                            break;
                        }

                        break;
                    }


                } else {
                    break;
                }
            }
        }
        finishFor.incrementAndGet();
        finishR.incrementAndGet();
    }

    public void choiceDirectionForMoveAndCallMove() {

        startM2.incrementAndGet();

        neighboringCells = getListNeighboringCells();

        for (Coordinate coordinate : neighboringCells) {
            if (this.getStop() == false) {
                if (freeCells.contains(coordinate)) {

                    move(coordinate, this);
                    for (int i = 0; i < label.size(); i++) {

                        labelArray[coordinate.getX()][coordinate.getY()]=  labelArray[this.getX()][this.getY()]  ;
                        labelArray[this.getX()][this.getY()]=null;
                       // if ((int) root.getChildren().get(i).getLayoutX() / 20 == this.getX() && (int) root.getChildren().get(i).getLayoutY() / 20 == this.getY()) {


                         //   root.getChildren().get(i).setLayoutX(coordinate.getX() * 20);
                           // root.getChildren().get(i).setLayoutX(coordinate.getY() * 20);
                      //  }

                    }
                    freeCells.remove(coordinate);
                    break;
                }


            } else {
                break;
            }

        }
        // neighboringCells = getListNeighboringCells();
        finishM2.incrementAndGet();
    }


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


    public CopyOnWriteArrayList<Coordinate> getListNeighboringCells() {
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
        if (this.getStop() == false) {
            startMove.incrementAndGet();
            int x = this.getX();

            int y = this.getY();
            freeCells.add(new Coordinate(x, y));
            this.setXY(coordinate.getX(), coordinate.getY());
            islandArray[coordinate.getX()][coordinate.getY()] = animal;
            islandArray[x][y] = null;

            //neighboringCells=getListNeighboringCells();

        }
        finishMove.incrementAndGet();
    }

    public void setPositionForNewbornAnimal(Coordinate coordinate, Animal animal) {
        startMove.incrementAndGet();

        animal.setXY(coordinate.getX(), coordinate.getY());
        islandArray[coordinate.getX()][coordinate.getY()] = animal;

        finishMove.incrementAndGet();
    }
}