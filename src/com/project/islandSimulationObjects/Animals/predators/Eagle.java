package com.project.islandSimulationObjects.Animals.predators;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;

//import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Eagle  extends Predators {

    public String   typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_EAGLE;

    public String typeString =  BoxCharacteristicsObject.TYPE_STRING_EAGLE;


   private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_MOUSE,BoxCharacteristicsObject.TYPE_STRING_RABBIT);
    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
    public ConcurrentHashMap<String, Double> chanceToEat = new ConcurrentHashMap<>();
    private void initializationMapChanceToEat(){
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_FOX, BoxCharacteristicsObject.PROBABILITY_EAGLE__EAT_FOX);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, BoxCharacteristicsObject.PROBABILITY_EAGLE_EAT_RABBIT);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE,BoxCharacteristicsObject.PROBABILITY_EAGLE_EAT_MOUSE );


    }
    public ConcurrentHashMap<String, Double> getMapChanceToEat(){
        return chanceToEat;
    }

    public int progenyLimit = 10;
    private final int step = BoxCharacteristicsObject.SPEED_EAGLE;
//    public Label label = new Label(typePicture);
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


    private volatile   boolean stop = false;

    @Override
    public boolean getStop() {
        return stop;
    }

    @Override
    public void setStop(boolean stop) {
        this.stop = stop;
    }
    @Override
    public  void  setEatenKg (int eatenKg ){
        this.eatenKg = eatenKg;
    }

    private int weight = BoxCharacteristicsObject.WEIGHT_EAGLE;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_EAGLE;
    private volatile int x;
    private volatile int y;

   // @Override
   // public Label getLabel() {
  //      return label;
   // }

    public Eagle(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Eagle(int age) {
        super();
        this.age = age;
    }


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
