

package com.project.islandSimulationObjects.Animals;

import com.project.island.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import com.project.islandSimulationObjects.*;
import com.project.islandSimulationObjects.Animals.predators.*;
import com.project.islandSimulationObjects.Plants.Plant;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Animal implements IslandSimulationObject, Callable<Void> {

    public static volatile CopyOnWriteArrayList<Coordinate> freeCells = IslandSimulation.getListFreeCells();
    public static volatile CopyOnWriteArrayList<Animal> animals = Island.getAnimalList();
    public static volatile CopyOnWriteArrayList<Plant> plants = Island.getPlantList();
    public static Island island = Island.getIsland();
    public static volatile IslandSimulationObject[][] islandArray;
    public static CreationIslandSimulationObject creationIslandSimulationObject = CreationIslandSimulationObject.getCreationIslandSimulationObject();

    static {

        islandArray = Island.getIslandArray();

    }

    protected List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
            BoxCharacteristicsObject.TYPE_STRING_FRUIT, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);

    public static CopyOnWriteArrayList<IslandSimulationObject> islandSimulationObjects = Island.islandSimulationObjects;
    private ArrayList<Coordinate> neighboringCells = new ArrayList<>();
    protected CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
    public ConcurrentHashMap<String, Double> chanceToEatMap = new ConcurrentHashMap<>();
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
    protected volatile int attemptsFindPartnerCounter = 0;
    protected volatile int eatenKg = 0;
    protected volatile int daysWithoutFood = 0;
    protected volatile int countDays = 0;
    protected volatile int dailyMealCounter = 0;


    protected volatile boolean isHunger = true;
    protected volatile boolean eat = false;
    protected volatile boolean stop = false;
    public static int numberBornAnimalsOfParticularSpecies = 0;
    public static int numberAnimalsOfParticularSpecies = 0;
    public static int numberDeadAnimalsOfParticularSpecies = 0;

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

    public synchronized int getDailyMealCounter() {
        return this.dailyMealCounter;
    }

    public synchronized void setDailyMealCounter(int dailyMealCounter) {
        this.dailyMealCounter = dailyMealCounter;
    }

    private volatile int hungryDaysCounter = 0;


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

    public synchronized int getAttemptsFindPartnerCounter() {
        return this.attemptsFindPartnerCounter;
    }


    public synchronized void setAttemptsFindPartnerCounter(int attemptsFindPartnerCounter) {
        this.attemptsFindPartnerCounter = attemptsFindPartnerCounter;
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


        if ((!this.getStop() && havingVitality() && !deathFromOldAge())) {
            if (this instanceof Predators) {
                if (!this.getStop() && (this.getProgeny() < this.getProgenyLimit()) && numberPlants.get() > 50 && this.getAge() >= 2 && (checkNumberAnimalsOfAParticularSpecies(this)) < Island.x + 10) {
                    if (!this.getStop()) {
                        if (this.getEat() || !this.getIsHunger()) {
                            this.reproduce();
                        }
                    }
                }

            } else {
                if (!this.getStop() && this.getProgeny() < this.getProgenyLimit() && numberPlants.get() > 10 && this.getAge() >= 2 && (checkNumberAnimalsOfAParticularSpecies(this)) < (Island.x + 20)) {
                    if (!this.getStop()) {

                        this.reproduce();
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


                            if (this.getFoodStuffs().contains(islandArray[x][y].getTypeString())) {
                                if (islandArray[x][y] instanceof Animal) {
                                    if (!((Animal) islandArray[x][y]).getStop()) {
                                    } else {
                                        continue;
                                    }
                                }
                                if (this instanceof Predators) {
                                    chanceToEatMap = (((Predators) this).getMapChanceToEat());
                                    if (chanceToEatMap.containsKey(islandArray[x][y].getTypeString())) {

                                        chanceToEat = chanceToEatMap.get(islandArray[x][y].getTypeString());
                                    }
                                }
                                if (ThreadLocalRandom.current().nextDouble(0, 1) < chanceToEat) {

                                    this.setEatenKg(this.getEatenKg() + islandArray[x][y].getWeight());

                                    if (this.getEatenKg() < (this.getNeededFoodKg() / 2)) {
                                        this.setIsHunger(true);

                                    } else {
                                        this.setIsHunger(false);
                                    }


                                    this.setEat(true);
                                    islandSimulationObjects.remove(islandArray[x][y]);
                                    if (islandArray[x][y] instanceof Animal) {
                                        decreaseTheNumberOfOneTypeOfAnimal(((Animal) islandArray[x][y]));

                                        numberAnimals.decrementAndGet();
                                        numberDeadAnimals.incrementAndGet();

                                        animals.remove(islandArray[x][y]);
                                        ((Animal) islandArray[x][y]).setStop(true);
                                    } else {
                                        numberPlants.decrementAndGet();
                                        numberEatenPlants.incrementAndGet();

                                        plants.remove(islandArray[x][y]);

                                    }

                                    islandArray[x][y].setXY(-1, -1);
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
        startFor.incrementAndGet();

        if (!this.getStop()) {
            synchronized (islandArray) {

                for (Coordinate coordinate1 : neighboringCells) {
                    int x = coordinate1.getX();
                    int y = coordinate1.getY();

                    if (!this.getStop()) {
                        if (!this.getStop() && islandArray[x][y] instanceof Animal && !((Animal) islandArray[x][y]).getStop()) {

                            if (islandArray[x][y] != null && this.getTypeString().equals(islandArray[x][y].getTypeString())) {

                                if (freeCells.size() > 0) {

                                    IslandSimulationObject islandSimulationObject = creationIslandSimulationObject.createObject(this, this.typeString);
                                    animals.add((Animal) islandSimulationObject);
                                    islandSimulationObject.setNumberBornAnimalsOfParticularSpecies((islandSimulationObject).getNumberBornAnimalsOfParticularSpecies() + 1);
                                    islandSimulationObject.setNumberAnimalsOfParticularSpecies((islandSimulationObject).getNumberAnimalsOfParticularSpecies() + 1);

                                    numberAnimals.incrementAndGet();
                                    numberBornAnimals.incrementAndGet();

                                    islandSimulationObjects.add(animals.get(animals.size() - 1));


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
                    } else {
                        break;
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
                if (!this.getStop()) {
                    if (freeCells.size() > 0) {
                        if (freeCells.contains(coordinate)) {

                            move(coordinate, this);
                            freeCells.remove(coordinate);
                            break;
                        }

                    } else {
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
        islandSimulationObject.setNumberAnimalsOfParticularSpecies(islandSimulationObject.getNumberAnimalsOfParticularSpecies() + 1);
        islandSimulationObject.setNumberDeadAnimalsOfParticularSpecies(islandSimulationObject.getNumberDeadAnimalsOfParticularSpecies() + 1);

        finishDecreaseTheNumberOfOneTypeOfAnimal.incrementAndGet();
    }

    public int checkNumberAnimalsOfAParticularSpecies(Animal animal) {
        IslandSimulationObject islandSimulationObject = creationIslandSimulationObject.createObject(animal, animal.getTypeString());
        return islandSimulationObject.getNumberAnimalsOfParticularSpecies();

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
        boolean coordinateHave = false;

        for (int i = 1; i < this.getStep() + 1; i++) {
            if (xD != limitDownX) {
                xD = xD + j;
                if (neighboringCells.size() == 0) {
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
                freeCells.add(new Coordinate(x, y));

            }
        }
        finishMove.incrementAndGet();
    }

    public void setPositionForNewbornAnimal(Coordinate coordinate, Animal animal) {
        startSetPositionForNewbornAnimal.incrementAndGet();

        animal.setXY(coordinate.getX(), coordinate.getY());
        islandArray[coordinate.getX()][coordinate.getY()] = animal;

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
        if (this.getCountDays() % 4 == 0 && this.getCountDays() != 0 || this.getCountDays() % 5 == 0 && this.getCountDays() != 0) {

            if (this.getDaysWithoutFood() >= 4 || this.getHungryDaysCounter() >= 5) {

                synchronized (islandArray) {

                    islandSimulationObjects.remove(this);

                    animals.remove(this);
                    islandArray[this.getX()][this.getY()] = null;
                    this.setStop(true);
                    freeCells.add(new Coordinate(this.getX(), this.getY()));
                    this.setXY(-1, -1);

                    numberDeadAnimals.incrementAndGet();
                    deathFromStarvation.incrementAndGet();
                    numberAnimals.decrementAndGet();
                    decreaseTheNumberOfOneTypeOfAnimal(this);


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

    public boolean deathFromOldAge() {
        startDeathFromOldAge.incrementAndGet();
        if (!this.getStop()) {
            if (this.getAge() >= 15) {
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
                } else {
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