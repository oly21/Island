package com.project.islandSimulationObjects.Plants;

import com.project.island.BoxCharacteristicsObject;
import com.project.islandSimulationObjects.Coordinate;
import com.project.islandSimulationObjects.IslandSimulationObject;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public abstract class Plant implements IslandSimulationObject {

    String typePlant;

    private int weight = BoxCharacteristicsObject.WEIGHT_PLANT;
    private int age;
    private volatile int x;
    private volatile int y;

    public int getX() {
        return x;
    }


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
    public void setWeight(int  weight) {
       this.weight = weight;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public synchronized Coordinate getXY() {

        return new Coordinate(x, y);
    }

    public abstract String getTypePicture();


    @Override
    public abstract String getTypeString();






    public Plant() {

    }



    public  String getTypePlant() {

        return typePlant;
    }


    public void start() {

        // Метод, который запускает анимацию перемещения животного

        // Создаем таймлайн (анимацию) с частотой 60 кадров в секунду
        ImageView imageView = new ImageView(this.getTypePicture());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000.0 / 60.0), event -> {
            int x;
            int y;
            x = this.getX();
            y = this.getY();
            imageView.setX(x);
            imageView.setY(y);
        }));


        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

}
