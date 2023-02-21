

package com.project.islandSimulationObjects.animals;

import com.project.island.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import com.project.islandSimulationObjects.*;
import com.project.islandSimulationObjects.animals.predators.*;
import com.project.islandSimulationObjects.plants.Plant;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal implements IslandSimulationObject, Callable<Void> {
    public IslandMap islandMap = IslandMap.getIslandMap();
    StartingIslandSimulation startingIslandSimulation = StartingIslandSimulation.getIslandSimulation();
    public volatile CopyOnWriteArrayList<Coordinate> freeCells = startingIslandSimulation.getListFreeCells();
    public volatile CopyOnWriteArrayList<Animal> animals = islandMap.getAnimalList();
    public volatile CopyOnWriteArrayList<Plant> plants = islandMap.getPlantList();

    protected List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
            BoxCharacteristicsObject.TYPE_STRING_FRUIT, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);


    private ArrayList<Coordinate> neighboringCells = new ArrayList<>();
    protected CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
    public ConcurrentHashMap<String, Double> chanceToEatMap = new ConcurrentHashMap<>();


    public volatile Cell[][] islandArray = islandMap.getIslandArray();
    ;
    CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();
    public CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = islandMap.getIslandSimulationObjectList();

    protected String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_RABBIT;
    protected String typeString = BoxCharacteristicsObject.TYPE_STRING_RABBIT;

    protected volatile int x;
    protected volatile int y;
    protected volatile int age;
    protected volatile int progeny = 0;
    protected int progenyLimit = 20;
    protected int step = BoxCharacteristicsObject.SPEED_RABBIT;
    protected volatile int weight = BoxCharacteristicsObject.WEIGHT_RABBIT;
    protected int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_RABBIT;

    protected volatile int eatenKg = 0;
    protected volatile int daysWithoutFood = 0;
    protected volatile int countDays = 0;

    private volatile int hungryDaysCounter = 0;
    protected volatile boolean isHunger = true;
    protected volatile boolean eat = false;
    protected volatile boolean stop = false;

    public static int numberBornAnimalsOfParticularSpecies = 0;
    public static int numberAnimalsOfParticularSpecies = 0;
    public static int numberDeadAnimalsOfParticularSpecies = 0;

    public volatile int limitRightY = islandMap.getY() - 1;
    public volatile int limitLeftY = 0;
    public volatile int LimitUpX = 0;
    public int limitDownX = islandMap.getX() - 1;

    public static volatile AtomicInteger numberAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberDeadAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberBornAnimals = new AtomicInteger(0);
    public static volatile AtomicInteger numberAnimalMoves = new AtomicInteger(0);
    public static volatile AtomicInteger numberEatenPlants = new AtomicInteger(0);
    public static volatile AtomicInteger numberPlants = new AtomicInteger(0);


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
    public static volatile AtomicInteger finishChoiceDirectionForMoveAndCallMove = new AtomicInteger(0);

    public static volatile AtomicInteger startR = new AtomicInteger(0);
    public static volatile AtomicInteger finishR = new AtomicInteger(0);
    public static volatile AtomicInteger startFor = new AtomicInteger(0);
    public static volatile AtomicInteger finishFor = new AtomicInteger(0);
    public static volatile AtomicInteger deathFromStarvation = new AtomicInteger(0);
    public static volatile AtomicInteger deathFromOldAge = new AtomicInteger(0);

    public synchronized boolean getIsHunger() {
        return this.isHunger;
    }

    public synchronized void setIsHunger(boolean isHunger) {
        this.isHunger = isHunger;
    }

    public synchronized boolean getEat() {
        return this.eat;
    }

    public synchronized void setEat(boolean eat) {
        this.eat = eat;
    }

    public synchronized int getProgeny() {
        return this.progeny;
    }

    public synchronized void setProgeny(int progeny) {
        this.progeny = progeny;
    }

    public synchronized int getEatenKg() {
        return this.eatenKg;
    }

    public synchronized void setEatenKg(int eatenKg) {
        this.eatenKg = eatenKg;
    }

    public synchronized boolean getStop() {
        return this.stop;
    }

    public synchronized void setStop(boolean stop) {
        this.stop = stop;
    }

    public synchronized int getX() {
        return this.x;
    }

    public synchronized int getY() {
        return this.y;
    }

    public synchronized void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int getWeight() {
        return this.weight;
    }


    public synchronized int getAge() {
        return this.age;
    }

    public synchronized void setAge(int age) {
        this.age = age;
    }


    public synchronized Coordinate getXY() {

        return new Coordinate(x, y);
    }


    public String getTypePicture() {
        return this.typePicture;
    }

    public String getTypeString() {
        return this.typeString;
    }

    public CopyOnWriteArrayList<String> getFoodStuffs() {
        return this.foodStuffs;
    }

    public int getNeededFoodKg() {
        return this.neededFoodKg;
    }

    public int getProgenyLimit() {
        return this.progenyLimit;
    }

    public int getStep() {
        return this.step;
    }

    public synchronized int getDaysWithoutFood() {
        return this.daysWithoutFood;
    }

    public synchronized void setDaysWithoutFood(int daysWithoutFood) {
        this.daysWithoutFood = daysWithoutFood;
    }

    public synchronized int getCountDays() {
        return this.countDays;
    }

    public synchronized void setCountDays(int countDays) {
        this.countDays = countDays;

    }


    public synchronized int getNumberBornAnimalsOfParticularSpecies() {
        return numberBornAnimalsOfParticularSpecies;
    }

    public synchronized void setNumberBornAnimalsOfParticularSpecies(int numberBornAnimalsOfParticularSpecies) {
        Animal.numberBornAnimalsOfParticularSpecies = numberBornAnimalsOfParticularSpecies;
    }

    public synchronized int getNumberAnimalsOfParticularSpecies() {
        return this.numberAnimalsOfParticularSpecies;
    }

    public synchronized void setNumberAnimalsOfParticularSpecies(int numberAnimalsOfParticularSpecies) {
        Animal.numberAnimalsOfParticularSpecies = numberAnimalsOfParticularSpecies;
    }

    public synchronized int getNumberDeadAnimalsOfParticularSpecies() {
        return numberDeadAnimalsOfParticularSpecies;
    }


    public synchronized void setNumberDeadAnimalsOfParticularSpecies(int numberDeadAnimalsOfParticularSpecies) {
        Animal.numberDeadAnimalsOfParticularSpecies = numberDeadAnimalsOfParticularSpecies;
    }

    public synchronized int getHungryDaysCounter() {
        return this.hungryDaysCounter;
    }

    public synchronized void setHungryDaysCounter(int hungryDaysCounter) {
        this.hungryDaysCounter = hungryDaysCounter;
    }


    public Void call() {
        runStart.incrementAndGet();
        this.setCountDays(this.getCountDays() + 1);

        if (this.getCountDays() % 2 == 0) {
            this.setProgeny(0);
        }

        if (!this.getStop() && !deathFromOldAge() && this.getIsHunger()) {
            this.eat();

            if (!this.getEat()) {
                this.setDaysWithoutFood(this.getDaysWithoutFood() + 1);
            }

            if (this.getIsHunger()) {
                this.setHungryDaysCounter(this.getHungryDaysCounter() + 1);
            }
        }

        boolean CanProgeny = this.getProgeny() < this.getProgenyLimit();
        boolean plantLimitPredators = numberPlants.get() > 50;
        boolean suitableAge = this.getAge() >= 2;
        boolean animalLimitPredators = checkNumberAnimalsOfAParticularSpecies(this) < islandMap.getX() + 10;
        boolean animalLimit = checkNumberAnimalsOfAParticularSpecies(this) < islandMap.getX() + 20;
        boolean plantLimit = numberPlants.get() > 10;
        if ((!this.getStop() && havingVitality() && !deathFromOldAge())) {
            if (this instanceof Predators) {
                if (!this.getStop() && CanProgeny && plantLimitPredators && suitableAge && animalLimitPredators) {
                    if (this.getEat() || !this.getIsHunger()) {
                        this.reproduce();
                    }
                }

            } else {
                if (!this.getStop() && CanProgeny && plantLimit && suitableAge && animalLimit) {
                    this.reproduce();
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
        }
        runFinish.incrementAndGet();

        return null;
    }

    public void eat() {
        startEat.incrementAndGet();
        this.setEat(false);
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
                            IslandSimulationObject islandSimulationObject = islandArray[x][y].getIslandSimulationObjectIfContains(this.getFoodStuffs());
                            if (islandSimulationObject != null) {
                                if (islandSimulationObject instanceof Animal && ((Animal) islandSimulationObject).getStop()) {
                                    continue;
                                }

                                if (this instanceof Predators) {
                                    chanceToEatMap = (((Predators) this).getMapChanceToEat());
                                    if (chanceToEatMap.containsKey(islandSimulationObject.getTypeString())) {
                                        chanceToEat = chanceToEatMap.get(islandSimulationObject.getTypeString());
                                    }
                                }
                                if (ThreadLocalRandom.current().nextDouble(0, 1) < chanceToEat) {
                                    this.setEatenKg(this.getEatenKg() + islandSimulationObject.getWeight());
                                    this.setIsHunger(this.getEatenKg() < (this.getNeededFoodKg() / 2));
                                    this.setEat(true);

                                    deathIslandSimulationObject(islandSimulationObject, x, y);
                                    this.move(coordinate1, this);
                                    break;
                                }
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
        if (!this.getStop()) {
            synchronized (islandArray) {
                startFor.incrementAndGet();
                for (Coordinate coordinate1 : neighboringCells) {

                    int x = coordinate1.getX();
                    int y = coordinate1.getY();

                    if (!this.getStop()) {
                        if (!this.getStop() && islandArray[x][y] != null) {
                            boolean sameType = islandArray[x][y].getIslandSimulationObject(this.typeString);
                            if (islandArray[x][y].getIslandSimulationObjectInCellSize() != 0 && sameType && !this.getStop()) {
                                if (freeCells.size() > 0) {
                                    IslandSimulationObject islandSimulationObjectCopy = creationIslandSimulationObject.createObject(this, this.typeString);
                                    animals.add((Animal) islandSimulationObjectCopy);
                                    islandSimulationObjectCopy.setNumberBornAnimalsOfParticularSpecies((islandSimulationObjectCopy).getNumberBornAnimalsOfParticularSpecies() + 1);
                                    islandSimulationObjectCopy.setNumberAnimalsOfParticularSpecies((islandSimulationObjectCopy).getNumberAnimalsOfParticularSpecies() + 1);

                                    numberAnimals.incrementAndGet();
                                    numberBornAnimals.incrementAndGet();
                                    islandSimulationObjects.add(islandSimulationObjectCopy);

                                    for (Coordinate freeCell : freeCells) {
                                        int coordinate = ThreadLocalRandom.current().nextInt(freeCells.size()) % freeCells.size();
                                        Coordinate coordinate2 = freeCells.get(coordinate);
                                        setPositionForNewbornAnimal(coordinate2, (Animal) islandSimulationObjectCopy);

                                        freeCells.remove(coordinate2);
                                        break;
                                    }
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
                if (!this.getStop() && freeCells.size() > 0) {
                    if (freeCells.contains(coordinate)) {
                        move(coordinate, this);
                        freeCells.remove(coordinate);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        finishChoiceDirectionForMoveAndCallMove.incrementAndGet();
    }


    public void decreaseTheNumberOfOneTypeOfAnimal(Animal animal) {
        startDecreaseTheNumberOfOneTypeOfAnimal.incrementAndGet();

        IslandSimulationObject islandSimulationObject = creationIslandSimulationObject.createObject(animal, animal.getTypeString());
        islandSimulationObject.setNumberAnimalsOfParticularSpecies(islandSimulationObject.getNumberAnimalsOfParticularSpecies() - 1);
        islandSimulationObject.setNumberDeadAnimalsOfParticularSpecies(islandSimulationObject.getNumberDeadAnimalsOfParticularSpecies() + 1);

        finishDecreaseTheNumberOfOneTypeOfAnimal.incrementAndGet();
    }

    public int checkNumberAnimalsOfAParticularSpecies(Animal animal) {
        IslandSimulationObject islandSimulationObject = creationIslandSimulationObject.createObject(animal, animal.getTypeString());
        return islandSimulationObject.getNumberAnimalsOfParticularSpecies();
    }

    public void AddNeighboringCells(int x, int y) {
        boolean coordinateHave = false;
        if (neighboringCells.size() == 0) {
            neighboringCells.add(new Coordinate(x, y));
        } else {
            for (Coordinate coordinate : neighboringCells) {
                if (coordinate.getX() == x && coordinate.getY() == y) {
                    coordinateHave = true;
                    break;
                }
            }
            if (!coordinateHave) {
                neighboringCells.add(new Coordinate(x, y));
            }
        }
    }

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

        for (int i = 1; i < this.getStep() + 1; i++) {
            if (xD != limitDownX) {
                xD = xD + j;
                AddNeighboringCells(xD, yD);
            }

            if (xUp != LimitUpX) {
                xUp = xUp - j;
                AddNeighboringCells(xUp, yUp);
            }

            if (yR != limitRightY) {
                yR = yR + j;
                AddNeighboringCells(xR, yR);
            }

            if (yL != limitLeftY) {
                yL = yL - j;
                AddNeighboringCells(xL, yL);
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
                islandArray[coordinate.getX()][coordinate.getY()].addIslandSimulationObject(animal);
                islandArray[x][y].removeIslandSimulationObject(animal);
                freeCells.add(new Coordinate(x, y));
            }
        }
        finishMove.incrementAndGet();
    }

    public void setPositionForNewbornAnimal(Coordinate coordinate, Animal animal) {
        startSetPositionForNewbornAnimal.incrementAndGet();
        animal.setXY(coordinate.getX(), coordinate.getY());
        islandArray[coordinate.getX()][coordinate.getY()].addIslandSimulationObject(animal);
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
                            if (!this.getStop() && (islandArray[coordinate.getX()][coordinate.getY()].getIslandSimulationObjectInCellSize()) > 0) {
                                int x = this.getX();
                                int y = this.getY();
                                IslandSimulationObject islandSimulationObject = islandArray[coordinate.getX()][coordinate.getY()].getRandomIslandSimulationObject();
                                islandArray[x][y].addIslandSimulationObject(islandSimulationObject);
                                islandSimulationObject.setXY(x, y);
                                islandArray[coordinate.getX()][coordinate.getY()].addIslandSimulationObject(this);
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
        if (this.getCountDays() % 4 == 0 && this.getCountDays() != 0 || this.getCountDays() % 5 == 0 && this.getCountDays() != 0) {
            if (this.getDaysWithoutFood() >= 4 || this.getHungryDaysCounter() >= 5) {
                synchronized (islandArray) {
                    deathIslandSimulationObject(this, this.getX(), this.getY());
                    deathFromStarvation.incrementAndGet();
                }
                finishHavingVitality.incrementAndGet();
                return false;
            } else {
                if (this.getCountDays() % 4 == 0 && this.getCountDays() != 0) {
                    this.setDaysWithoutFood(0);
                    this.setIsHunger(true);
                    this.setEatenKg(0);
                } else if (this.getCountDays() % 5 == 0 & this.getCountDays() != 0) {
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


    public void deathIslandSimulationObject(IslandSimulationObject islandSimulationObject, int x, int y) {
        islandSimulationObjects.remove(islandSimulationObject);
        islandArray[x][y].removeIslandSimulationObject(islandSimulationObject);
        islandSimulationObject.setXY(-1, -1);
        freeCells.add(new Coordinate(x, y));
        if (islandSimulationObject instanceof Animal) {
            decreaseTheNumberOfOneTypeOfAnimal(((Animal) islandSimulationObject));
            numberAnimals.decrementAndGet();
            numberDeadAnimals.incrementAndGet();
            animals.remove(islandSimulationObject);
            ((Animal) islandSimulationObject).setStop(true);
        } else {
            numberPlants.decrementAndGet();
            numberEatenPlants.incrementAndGet();
            plants.remove(islandSimulationObject);
        }
    }

    public boolean deathFromOldAge() {
        startDeathFromOldAge.incrementAndGet();
        if (this.getAge() >= 10 && !this.getStop()) {
            synchronized (islandArray) {
                deathIslandSimulationObject(this, this.getX(), this.getY());
                deathFromOldAge.incrementAndGet();
                islandSimulationObjects.remove(this);
                finishDeathFromOldAge.incrementAndGet();
                return true;
            }
        } else {
            finishDeathFromOldAge.incrementAndGet();
            return false;
        }
    }
}