package com.project.islandSimulationObjects.Animals.predators;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
//import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Wolf extends Predators {
    private final String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_WOLF;
    private final String typeString = BoxCharacteristicsObject.TYPE_STRING_WOLF;
    // public Label label = new Label(typePicture);
    private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_MOUSE,
            BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.TYPE_STRING_DEER,
            BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.TYPE_STRING_GOAT,
            BoxCharacteristicsObject.TYPE_STRING_DUCK, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);

    private final CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
    private final ConcurrentHashMap<String, Double> chanceToEat = new ConcurrentHashMap<>();

    private synchronized void initializationMapChanceToEat() {

        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_GOAT, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_GOAT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_MOUSE);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DEER);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_SHEEP);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DUCK, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DUCK);
    }

    private volatile boolean eat = false;
    private volatile int count = 0;
    public volatile boolean isHunger = true;
    private final int progenyLimit = 10;
    private final int step = BoxCharacteristicsObject.SPEED_WOLF;
    private volatile int eatenKg = 0;
    private volatile int progeny = 0;

    private volatile int weight = BoxCharacteristicsObject.WEIGHT_WOLF;
    private volatile int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_WOLF;
    private volatile int x;
    private volatile int y;
    private volatile int hungryDaysCounter = 0;
    private volatile int daysWithoutFood = 0;
    private volatile int countDays = 0;
    private volatile int dailyMealCounter = 0;

    public Wolf(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Wolf(int age) {
        super();
        this.age = age;
    }


    public synchronized ConcurrentHashMap<String, Double> getMapChanceToEat() {
        if (count == 0) {
            initializationMapChanceToEat();
            count++;
        }
        return chanceToEat;
    }


    @Override
    public synchronized boolean getIsHunger() {
        return isHunger;
    }


    @Override
    public synchronized void setIsHunger(boolean isHunger) {
        this.isHunger = isHunger;
    }


    @Override
    public synchronized boolean getEat() {
        return eat;
    }


    @Override
    public synchronized void setEat(boolean eat) {
        this.eat = eat;
    }


    @Override
    public synchronized int getProgeny() {
        return progeny;
    }

    @Override
    public synchronized void setProgeny(int progeny) {
        this.progeny = progeny;
    }


    @Override
    public synchronized int getEatenKg() {
        return eatenKg;
    }


    @Override
    public synchronized void setEatenKg(int eatenKg) {
        this.eatenKg = eatenKg;
    }


    //@Override
    // public Label getLabel() {
    //     return label;
    // }


    @Override
    public synchronized int getX() {
        return x;
    }

    @Override
    public synchronized int getY() {
        return y;
    }

    @Override
    public synchronized void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public synchronized int getWeight() {
        return weight;
    }

    @Override
    public synchronized int getAge() {
        return age;
    }

    public synchronized void setAge(int age) {
        this.age = age;
    }

    @Override
    public synchronized Coordinate getXY() {

        return new Coordinate(x, y);
    }


    @Override
    public String getTypePicture() {
        return typePicture;
    }

    @Override
    public String getTypeString() {
        return typeString;
    }

    @Override
    public CopyOnWriteArrayList<String> getFoodStuffs() {
        return foodStuffs;
    }

    private volatile boolean stop = false;

    @Override
    public synchronized boolean getStop() {
        return stop;
    }

    @Override
    public synchronized void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public int getNeededFoodKg() {
        return neededFoodKg;
    }

    @Override
    public int getProgenyLimit() {
        return progenyLimit;
    }

    @Override
    public int getStep() {
        return step;
    }

    @Override
    public synchronized int getDaysWithoutFood() {
        return daysWithoutFood;
    }

    @Override
    public synchronized void setDaysWithoutFood(int daysWithoutFood) {
        this.daysWithoutFood = daysWithoutFood;
    }

    @Override
    public synchronized int getCountDays() {
        return countDays;
    }

    @Override
    public synchronized void setCountDays(int countDays) {
        this.countDays = countDays;

    }

    @Override
    public synchronized int getDailyMealCounter() {
        return dailyMealCounter;
    }

    @Override
    public synchronized void setDailyMealCounter(int dailyMealCounter) {
        this.dailyMealCounter = dailyMealCounter;
    }


    @Override
    public synchronized int getHungryDaysCounter() {
        return hungryDaysCounter;
    }

    @Override
    public synchronized void setHungryDaysCounter(int hungryDaysCounter) {
        this.hungryDaysCounter = hungryDaysCounter;
    }

    private volatile int attemptsFindPartnerCounter = 0;

    @Override
    public synchronized int getAttemptsFindPartnerCounter() {
        return attemptsFindPartnerCounter;
    }

    @Override
    public synchronized void setAttemptsFindPartnerCounter(int attemptsFindPartnerCounter) {
        this.attemptsFindPartnerCounter = attemptsFindPartnerCounter;
    }
}

