package com.project.islandSimulationObjects.Animals.herbivorous;
import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
import javafx.scene.control.Label;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Duck extends Animal {
    public String typePicture = BoxCharacteristicsObject.STRING_TYPE_PICTURE_DUCK;
    public String typeString = BoxCharacteristicsObject.TYPE_STRING_DUCK;
    public int progenyLimit = 10;
    private int step = BoxCharacteristicsObject.SPEED_DUCK;


    private int weight = BoxCharacteristicsObject.WEIGHT_DUCK;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_DUCK;
    private  int x;
    private  int y;


    private final List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES,
            BoxCharacteristicsObject.TYPE_STRING_GRASS, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR);

    public CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);







    public Duck(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }
//    public Label label = new Label(typePicture);
    public Duck(int age) {
        super();
        this.age = age;
    }
  //  @Override
   // public Label getLabel() {
       // return label;
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
    public  Coordinate getXY() {

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
        for (int i = 0; i <= 2; i++) {
            super.reproduct(animal);
        }
    }
}







        /*public void reproduct(Duck animal) throws InstantiationException, IllegalAccessException {
        if (progeny < 10) {


            Duck duckCopy = new Duck(2, 2, 1);
            Duck duckCopy2 = new Duck(2, 2, 1);

                this.progeny++;



            numberAnimals = printingIslandSimulationStatistics.getNumberAnimals();
            numberAnimals++;
            numberAnimals++;
            animals.add(duckCopy);
            animals.add(duckCopy2);
            printingIslandSimulationStatistics.setNumberAnimals(numberAnimals);

            Animal.numberBornAnimals = printingIslandSimulationStatistics.getNumberBornAnimals();
            numberBornAnimals++;

            printingIslandSimulationStatistics.setNumberBornAnimals(numberBornAnimals);

            islandSimulationObjects.add(duckCopy);
            islandSimulationObjects.add(duckCopy2);
            for (Coordinate freeCell : IslandSimulation.getListFreeCells()) {
                move(freeCell, duckCopy);
                move(freeCell, duckCopy2);
                break;
            }


        }


*/




