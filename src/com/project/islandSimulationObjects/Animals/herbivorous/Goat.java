package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javafx.scene.control.Label;
public class Goat extends Herbivores {
    public String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_GOAT;
    public String typeString = BoxCharacteristicsObject.TYPE_STRING_GOAT;
    public int progenyLimit = 10;
    private int step = BoxCharacteristicsObject.SPEED_GOAT;

   // public Label label = new Label(typePicture);
    private int weight = BoxCharacteristicsObject.WEIGHT_GOAT;
    private int age;
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
    public boolean isHunger;





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



    public boolean getIsHunger() {
        return false;
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


    @Override
    public void reproduct()  {
       for (int i = 0; i<=2; i++){
           super.reproduct();
       }



    }

  /*  public void reproduct(Goat animal) throws InstantiationException, IllegalAccessException {
        if (progeny < 10) {


            Goat goatCopy = new Goat(2, 2, 1);
            Goat goatCopy2 = new Goat(2, 2, 1);

            this.progeny++;



            numberAnimals = printingIslandSimulationStatistics.getNumberAnimals();
            numberAnimals++;
            numberAnimals++;
            animals.add(goatCopy);
            animals.add(goatCopy2);
            printingIslandSimulationStatistics.setNumberAnimals(numberAnimals);

            Animal.numberBornAnimals = printingIslandSimulationStatistics.getNumberBornAnimals();
            numberBornAnimals++;

            printingIslandSimulationStatistics.setNumberBornAnimals(numberBornAnimals);

            islandSimulationObjects.add(goatCopy);
            islandSimulationObjects.add(goatCopy2);
            for (Coordinate freeCell : IslandSimulation.getListFreeCells()) {
                move(freeCell, goatCopy);
                move(freeCell, goatCopy2);
                break;
            }


        }

    }
*/
}
