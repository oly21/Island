package com.project.islandSimulationObjects.Animals.herbivorous;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.IslandSimulation;
import com.project.islandSimulationObjects.Animals.Animal;
import com.project.islandSimulationObjects.Coordinate;
import javafx.scene.control.Label;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Mouse extends Animal {
    public static String   typePicture  = BoxCharacteristicsObject.STRING_TYPE_PICTURE_MOUSE;

    public static String typeString =  BoxCharacteristicsObject.TYPE_STRING_MOUSE;
    public static int progenyLimit = 30;

   private final static List<String> initialList = Arrays.asList(BoxCharacteristicsObject.TYPE_STRING_FRUIT,
            BoxCharacteristicsObject.TYPE_STRING_BERRIES,BoxCharacteristicsObject.TYPE_STRING_VEGETABLES);
    public static CopyOnWriteArrayList<String> foodStuffs = new CopyOnWriteArrayList<>(initialList);

    private final int step = BoxCharacteristicsObject.SPEED_MOUSE;


    private int weight = BoxCharacteristicsObject.WEIGHT_MOUSE;
    private int age;
    private final int neededFoodKg = BoxCharacteristicsObject.MEAL_REQUIRED_KG_MOUSE;
    private volatile int x;
    private volatile int y;

    public Mouse(int weight, int age) {
        super();
        this.weight = weight;
        this.age = age;
    }

    public Mouse(int age) {
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

    @Override
    public void reproduct(Animal animal) throws InstantiationException, IllegalAccessException {
        for (int i = 0; i <= 7; i++) {
            super.reproduct(animal);
        }
    }

   // @Override
  //  public Label getLabel() {
       // return label;
   // }




//    public Label label = new Label(typePicture);
    /*public void reproduct(Mouse animal) throws InstantiationException, IllegalAccessException {
        if (progeny < 30) {


            Mouse mouseCopy = new Mouse(2, 2, 1);
            Mouse mouseCopy2 = new Mouse(2, 2, 1);
            Mouse mouseCopy3 = new Mouse(2, 2, 1);
            Mouse mouseCopy4 = new Mouse(2, 2, 1);
            Mouse mouseCopy5= new Mouse(2, 2, 1);
            Mouse mouseCopy6 = new Mouse(2, 2, 1);
            Mouse mouseCopy7 = new Mouse(2, 2, 1);
            this.progeny++;



            numberAnimals = printingIslandSimulationStatistics.getNumberAnimals();
            numberAnimals++;
            numberAnimals++;
            animals.add(mouseCopy);
            animals.add(mouseCopy2);
            animals.add(mouseCopy3);
            animals.add(mouseCopy4);
            animals.add(mouseCopy5);
            animals.add(mouseCopy6);
            animals.add(mouseCopy7);

            printingIslandSimulationStatistics.setNumberAnimals(numberAnimals);

            Animal.numberBornAnimals = printingIslandSimulationStatistics.getNumberBornAnimals();
            numberBornAnimals++;

            printingIslandSimulationStatistics.setNumberBornAnimals(numberBornAnimals);

            islandSimulationObjects.add(mouseCopy);
            islandSimulationObjects.add(mouseCopy2);
            islandSimulationObjects.add(mouseCopy3);
            islandSimulationObjects.add(mouseCopy4);
            islandSimulationObjects.add(mouseCopy5);
            islandSimulationObjects.add(mouseCopy6);
            islandSimulationObjects.add(mouseCopy7);



            for (Coordinate freeCell : IslandSimulation.getListFreeCells()) {
                move(freeCell, mouseCopy);
                move(freeCell, mouseCopy2);
                move(freeCell, mouseCopy3);
                move(freeCell, mouseCopy4);
                move(freeCell, mouseCopy5);
                move(freeCell, mouseCopy6);
                move(freeCell, mouseCopy7);

                break;
            }


        }

    }
*/
}
