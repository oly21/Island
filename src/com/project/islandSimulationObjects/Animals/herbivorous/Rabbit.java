package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
//import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Rabbit extends Herbivores {
    public String   typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_RABBIT;
    public String typeString = BoxCharacteristicsObject.TYPE_STRING_RABBIT;
    public int progenyLimit = 30;

//    public Label label = new Label(typePicture);
    private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
            BoxCharacteristicsObject.TYPE_STRING_GRASS,BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);
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


    private volatile boolean stop = false;

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

    private final int step = BoxCharacteristicsObject.SPEED_RABBIT;


    private int weight = BoxCharacteristicsObject.WEIGHT_RABBIT;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_RABBIT;
    private volatile int x;
    private volatile int y;

    public Rabbit(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Rabbit(int age) {
        super();
        this.age = age;
    }


    //@Override
    //public Label getLabel() {
     //   return label;
    //}

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
        for (int i = 0; i <= 7; i++) {
            super.reproduct();
        }
    }
    /* public void reproduct(Rabbit animal) throws InstantiationException, IllegalAccessException {
        if (progeny < 30) {


            Rabbit rabbitCopy = new Rabbit(2, 2, 1);
            Rabbit  rabbitCopy2 = new Rabbit(2, 2, 1);
            Rabbit  rabbitCopy3 = new Rabbit(2, 2, 1);
            Rabbit  rabbitCopy4 = new Rabbit(2, 2, 1);
            Rabbit  rabbitCopy5= new Rabbit(2, 2, 1);
            Rabbit  rabbitCopy6 = new Rabbit(2, 2, 1);
            Rabbit  rabbitCopy7 = new Rabbit(2, 2, 1);
            this.progeny++;



            numberAnimals = printingIslandSimulationStatistics.getNumberAnimals();
            numberAnimals++;
            numberAnimals++;
            animals.add(rabbitCopy);
            animals.add(rabbitCopy2);
            animals.add(rabbitCopy3);
            animals.add(rabbitCopy4);
            animals.add(rabbitCopy5);
            animals.add(rabbitCopy6);
            animals.add(rabbitCopy7);

            printingIslandSimulationStatistics.setNumberAnimals(numberAnimals);

            Animal.numberBornAnimals = printingIslandSimulationStatistics.getNumberBornAnimals();
            numberBornAnimals++;

            printingIslandSimulationStatistics.setNumberBornAnimals(numberBornAnimals);

            islandSimulationObjects.add(rabbitCopy);
            islandSimulationObjects.add(rabbitCopy2);
            islandSimulationObjects.add(rabbitCopy3);
            islandSimulationObjects.add(rabbitCopy4);
            islandSimulationObjects.add(rabbitCopy5);
            islandSimulationObjects.add(rabbitCopy6);
            islandSimulationObjects.add(rabbitCopy7);

            for (Coordinate freeCell : IslandSimulation.getListFreeCells()) {
                move(freeCell, rabbitCopy);
                move(freeCell, rabbitCopy2);
                move(freeCell, rabbitCopy3);
                move(freeCell, rabbitCopy4 );
                move(freeCell, rabbitCopy5);
                move(freeCell, rabbitCopy6);
                move(freeCell, rabbitCopy7);

                break;
            }


        }

    }
*/
}
