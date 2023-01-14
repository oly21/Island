package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
//import javafx.scene.control.Label;
public class Goat extends Herbivores {
    public String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_GOAT;
    public String typeString = BoxCharacteristicsObject.TYPE_STRING_GOAT;
    public int progenyLimit = 5;
    private final int step = BoxCharacteristicsObject.SPEED_GOAT;

   // public Label label = new Label(typePicture);
    private  volatile int weight = BoxCharacteristicsObject.WEIGHT_GOAT;
    private volatile int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_GOAT;
    private volatile int x;
    private volatile int y;

   // @Override
   // public Label getLabel() {
    //    return label;
   // }

    private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
            BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);



    public Goat(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Goat(int age) {
        super();
        this.age = age;
    }
    public  volatile boolean isHunger= true;
    private  volatile boolean stop = false;

    @Override
    public  synchronized boolean getStop() {
        return stop;
    }

    @Override
    public synchronized void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public synchronized   void  setIsHunger(boolean isHunger){
        this.isHunger = isHunger;
    }

    private  volatile boolean eat = false;
    @Override
    public  synchronized boolean getEat(){
        return  eat;
    }

    @Override
    public synchronized   void  setEat(boolean eat ){
        this.eat = eat;
    }
    private int progeny = 0;

    @Override
    public  synchronized int getProgeny(){
        return progeny;
    }
    @Override
    public synchronized void  setProgeny(int progeny ){
        this.progeny = progeny;
    }
    private  volatile int eatenKg = 0;

    @Override
    public  synchronized int getEatenKg (){
        return eatenKg;
    }

    @Override
    public   synchronized void  setEatenKg (int eatenKg ){
        this.eatenKg = eatenKg;
    }

    public  synchronized boolean getIsHunger() {
        return false;
    }

    @Override
    public  synchronized int getX() {
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


  //  @Override
  //  public void reproduce()  {
   //    for (int i = 0; i<=2; i++){
     //      super.reproduce();
    //   }



   // }
    private volatile int daysWithoutFood = 0;
    private  volatile int countDays = 0;
    private  volatile int  dailyMealCounter  = 0;

    @Override
    public  synchronized int getDaysWithoutFood() {
        return daysWithoutFood;
    }

    @Override
    public synchronized void setDaysWithoutFood(  int daysWithoutFood) {
        this.daysWithoutFood = daysWithoutFood;
    }

    @Override
    public  synchronized int getCountDays() {
        return countDays;
    }

    @Override
    public synchronized void setCountDays(int countDays) {
        this.countDays = countDays;

    }

    @Override
    public  synchronized int getDailyMealCounter() {
        return dailyMealCounter;
    }

    @Override
    public synchronized void setDailyMealCounter(int dailyMealCounter) {
        this.dailyMealCounter = dailyMealCounter;
    }
    private  volatile int  hungryDaysCounter = 0;
    @Override
    public  synchronized int getHungryDaysCounter() {
        return hungryDaysCounter;
    }

    @Override
    public synchronized void setHungryDaysCounter(  int hungryDaysCounter) {
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
