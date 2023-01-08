package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Deer extends Herbivores {

    private int step = BoxCharacteristicsObject.SPEED_DEER;


    private int weight = BoxCharacteristicsObject.WEIGHT_DEER;
    private int age;
    private final int progenyLimit = 10;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_DEER;
    private volatile int x;
    private volatile int y;
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

    private  volatile boolean stop = false;

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


    public String typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_DEER;
    public String typeString  =  BoxCharacteristicsObject.TYPE_STRING_DEER;
    private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
            BoxCharacteristicsObject.TYPE_STRING_GRASS,BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);

  //  public Label label = new Label(typePicture);

    public Deer(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Deer(int age) {
        super();
        this.age = age;
    }

   // @Override
   // public Label getLabel() {
   //     return label;
   // }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public  void setXY(int x, int y) {
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
