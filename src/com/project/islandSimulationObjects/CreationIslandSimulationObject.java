package com.project.islandSimulationObjects;

import com.project.island.BoxCharacteristicsObject;
import com.project.island.IslandMap;
import com.project.islandSimulationObjects.animals.omnivores.*;
import com.project.islandSimulationObjects.animals.herbivorous.*;
import com.project.islandSimulationObjects.animals.predators.*;
import com.project.islandSimulationObjects.plants.*;
import java.util.Objects;
import static com.project.island.IslandMap.getIslandMap;

public class CreationIslandSimulationObject {
    public static IslandMap islandMap = getIslandMap();
    public static CreationIslandSimulationObject instance = null;
    private CreationIslandSimulationObject() {

    }
    public static CreationIslandSimulationObject getCreationIslandSimulationObject() {
        if (instance == null) {
            instance = new CreationIslandSimulationObject();
        }
        return instance;
    }

    public IslandSimulationObject createObject(IslandSimulationObject islandSimulationObject, String stringType) {

        if (islandSimulationObject instanceof Fox || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_FOX)) {
            return new Fox(1, 1);

        } else if (islandSimulationObject instanceof Boa || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_BOA)) {
            return new Boa(1, 1);

        } else if (islandSimulationObject instanceof Buffalo || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_BUFFALO)) {
            return new Buffalo(1, 1);

        } else if (islandSimulationObject instanceof Caterpillar || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_CATERPILLAR)) {
            return new Caterpillar(1, 1);

        } else if (islandSimulationObject instanceof Deer || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_DEER)) {
            return new Deer(1, 1);

        } else if (islandSimulationObject instanceof Horse || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_HORSE)) {
            return new Horse(1, 1);

        } else if (islandSimulationObject instanceof Bear || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_BEAR)) {
            return new Bear(1, 1);

        } else if (islandSimulationObject instanceof Eagle || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_EAGLE)) {
            return new Eagle(1, 1);

        } else if (islandSimulationObject instanceof Wolf || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_WOLF)) {
            return new Wolf(1, 1);

        } else if (islandSimulationObject instanceof Boar || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_BOAR)) {
            return new Boar(1, 1);

        } else if (islandSimulationObject instanceof Rabbit || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_RABBIT)) {
            return new Rabbit(1, 1);

        } else if (islandSimulationObject instanceof Duck || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_DUCK)) {
            return new Duck(1, 1);

        } else if (islandSimulationObject instanceof Goat || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_GOAT)) {
            return new Goat(1, 1);

        } else if (islandSimulationObject instanceof Mouse || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_MOUSE)) {
            return new Mouse(1, 1);

        } else if (islandSimulationObject instanceof Sheep || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_SHEEP)) {
            return new Sheep(1, 1);

        } else if (islandSimulationObject instanceof Berries || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_BERRIES)) {
            return new Berries(1, 1);

        } else if (islandSimulationObject instanceof Fruit || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_FRUIT)) {
            return new Fruit(1, 1);

        } else if (islandSimulationObject instanceof Grass || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_GRASS)) {
            return new Grass(1, 1);

        } else if (islandSimulationObject instanceof PlantLeaves || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_PLANT_LEAVES)) {
            return new PlantLeaves(1, 1);

        } else if (islandSimulationObject instanceof Vegetables || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_VEGETABLES)) {
            return new Vegetables(1, 1);

        } else if (islandSimulationObject instanceof Giraffe || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_GIRAFFE)) {
            return new Giraffe(1, 1);

        } else if (islandSimulationObject instanceof Elephant || Objects.equals(stringType, BoxCharacteristicsObject.TYPE_STRING_ELEPHANT)) {
            return new Elephant(1, 1);

        } else {
            return new Rabbit(5, 0);
        }
    }
}