package com.project.islandSimulationObjects.Animals.predators;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.IslandSimulation;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Animals.herbivorous.Goat;
import com.project.islandSimulationObjects.Coordinate;

import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Boa extends Predators {

    public   String   typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BOA;

    public  String typeString =  BoxCharacteristicsObject.TYPE_STRING_BOA;


   private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_MOUSE,
            BoxCharacteristicsObject.TYPE_STRING_SHEEP, BoxCharacteristicsObject.TYPE_STRING_RABBIT);
   public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);

    public ConcurrentHashMap<String, Integer> chanceToEat = new ConcurrentHashMap<>();
    private void initializationMapChanceToEat(){
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_FOX, 15);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_RABBIT, 20);
        chanceToEat.put(BoxCharacteristicsObject.TYPE_STRING_MOUSE, 40);


    }
    public ConcurrentHashMap<String, Integer> getMapChanceToEat(){
        return chanceToEat;
    }



    public int progenyLimit = 30;
    private final int step = BoxCharacteristicsObject.SPEED_BOA;

//    public Label label = new Label(typePicture);
    private int weight = BoxCharacteristicsObject.WEIGHT_BOA;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_BOA;
    private volatile int x;
    private volatile int y;

    public Boa(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Boa(int age) {
        super();
        this.age = age;
    }


    //@Override
   // public Label getLabel() {
    //    return label;
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

    @Override
    public void reproduct(Animal animal) throws InstantiationException, IllegalAccessException {
        for (int i = 0; i <= 4; i++) {
            super.reproduct(animal);
        }
    }



    }

