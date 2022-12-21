package com.project.islandSimulationObjects.Animals.predators;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;

import javafx.scene.control.Label;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Boar  extends Predators {
    public  String   typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_BOAR;

    public  String typeString =  BoxCharacteristicsObject.TYPE_STRING_BOAR;
    //public Label label = new Label(typePicture);

  private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES,
            BoxCharacteristicsObject.TYPE_STRING_FRUIT,BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);
   public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);

   // @Override
   // public Label getLabel() {
   //     return label;
  //  }



    public int progenyLimit = 10;
    private final int step = BoxCharacteristicsObject.SPEED_BOAR;


    private int weight = BoxCharacteristicsObject.WEIGHT_BOAR;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_BOAR;
    private volatile int x;
    private volatile int y;

    public Boar(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Boar(int age) {
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

