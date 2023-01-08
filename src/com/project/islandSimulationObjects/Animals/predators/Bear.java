package com.project.islandSimulationObjects.Animals.predators;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bear extends Predators {
    public   String   typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BEAR;

    public   String typeString =  BoxCharacteristicsObject.TYPE_STRING_BEAR;

    private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
            BoxCharacteristicsObject.TYPE_STRING_GRASS,BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
            BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.TYPE_STRING_DUCK,
            BoxCharacteristicsObject.TYPE_STRING_GOAT,BoxCharacteristicsObject.TYPE_STRING_RABBIT,
            BoxCharacteristicsObject.TYPE_STRING_SHEEP,BoxCharacteristicsObject.TYPE_STRING_MOUSE,
            BoxCharacteristicsObject.TYPE_STRING_DEER,BoxCharacteristicsObject.TYPE_STRING_BOA);

    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
    public ConcurrentHashMap<String, Double> chanceToEat = new ConcurrentHashMap<>();

    private void initializationMapChanceToEat(){
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_BOA, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_BOA);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_DEER, BoxCharacteristicsObject.PROBABILITY_WOLF_EAT_DEER);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_FOX_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_MOUSE);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_GOAT, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_GOAT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.PROBABILITY_BEAR_EAT_SHEEP);

    }
    private volatile boolean stop = false;

    @Override
    public boolean getStop() {
        return stop;
    }

    @Override
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public ConcurrentHashMap<String, Double> getMapChanceToEat(){
       return chanceToEat;
    }
    public int progenyLimit = 10;
    private final int step = BoxCharacteristicsObject.SPEED_BEAR;


    private int weight = BoxCharacteristicsObject.WEIGHT_BEAR;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_BEAR;
    private volatile int x;
    private volatile int y;

    public Bear(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Bear(int age) {
        super();
        this.age = age;
    }
   // public Label label = new Label(typePicture);

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public synchronized void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }





    //@Override
   // public Label getLabel() {
   //     return label;
  //  }


    public boolean isHunger;

    @Override
    public  boolean getIsHunger(){
        return  isHunger;
    }






    @Override
    public  void  setIsHunger(boolean isHunger){
        this.isHunger = isHunger;
    }

    private boolean eat = false;
    @Override
    public  boolean getEat(){
        return  eat;
    }


    @Override
    public  void  setEat(boolean eat ){
        this.eat = eat;
    }
    private int progeny = 0;

    @Override
    public  int getProgeny(){
        return progeny;
    }
    @Override
    public  void  setProgeny(int progeny ){
        this.progeny = progeny;
    }
    private int eatenKg = 0;

    @Override
    public int getEatenKg (){
        return eatenKg;
    }



    @Override
    public  void  setEatenKg (int eatenKg ){
        this.eatenKg = eatenKg;
    }


    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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




}
