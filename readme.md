# Island4

#### A multi-threaded application 
starts the growth of plants(**PlantGrowth**)
, displays a map of the island(**IslandSimulationDisplay**),
displays statistics(**PrintingIslandSimulationStatistics**),
checks the simulation termination condition and terminates
it when the condition is met (**CheckingStopConditionOfIslandSimulation**) and starts
the life cycle of all animals(**AnimalLifeCycle**).
#### to remove an animal or plant from the simulation, it is enough to comment 2 lines related to this animal or plant in CreationIslandSimulationObject
#### 3 minutes is enough to add a new animal or plant to the simulation (create a new class, etc.)
#### 5 Scheduled threads run at StartingIslandSimulation and 1 FixedThreadPool at AnimalLifeCycle
#### in AnimalLifeCycle 1 animal is a threads and run in FixedThreadPool at random using ThreadLocalRandom .
#### Every animal has such methods: 

#### eat() - 
Herbivore can eat plants, fruits, 
Predators of other animals and sometimes plants,
Omnivores can also eat plants, fruits and small insects.
Animals look for food in neighboring cells, 
to search for neighboring cells use method ***getListNeighboringCells***
***predators eat their prey with a certain probability using ThreadLocalRandom***
#### reproduce() -
An animal can reproduce  with an animal of its own species,
each species of animal has its own  ***ProgenyLimit*** and some herbivores
override this method to maintain a balance in the simulation so that 
herbivores that are hunted by predators can maintain a population longer
(they have more offspring).

In order for the map not to be captured by one type of animal,
there is also a limit on the number of animals of the same type on the map,
predators have this limit more, this is necessary to maintain a balance.
***The number of animals that are already on the map is checked using the checkNumberAnimalsOfAParticularSpecie(Animal animal)***(***additional functionality***) 
method.

***The born animal is placed on the map using the method setPositionForNewbornAnimal(Coordinate coordinate, Animal animal)***
Also predators  can not reproduce if the number of plants on the map is less than 50, 
this is necessary so that the predators do not fill the entire map and so that the plants continue to grow
and herbivores have something to eat, 

animals also looking for a pair on neighboring cells using the method
***getListNeighboringCells***. 

**A new animal is created using the method CreationIslandSimulationObject**


***predators can only breed when they have eaten or if they are not hungry***
#### choiceDirectionForMoveAndCallMove()-
The animal chooses the direction of movement and moves using the ***move()*** method to adjacent free cells.

#### move(Coordinate coordinate, Animal animal)-
Moves the passed animal to the given coordinates.
#### decreaseTheNumberOfOneTypeOfAnimal(Animal animal) -
Decrease the number of animals of a certain species

#### getListNeighboringCells()-
Get a list of neighboring  cells

#### swapPlacesWithNeighbor()-(***additional functionality***)
Swaps  animals (in case the whole map fills up and animals cannot find a mate or food next to them so that the simulation continues).

####  havingVitality()-
Verifies whether the animal has vitality, if the animal has not eaten anything for a certain number of days or has been hungry for several days, then it has no vitality and dies of hunger.
***additional functionality***
#### deathFromOldAge()-(***additional functionality***)
Сhecks if the animal is young enough if it is too old (more age than the set limit) then it dies.



### BoxCharacteristicsObject - contains characteristics of all animals.
### IslandMap - A map of the island and a list of initial animals and plants are created. Animal and plant objects are created using the class ***CreationIslandSimulationObject***

### Cell-
Cell class, 1 cage can contain many animals and plants, contains methods:
getIslandSimulationObjectInCellSize(), addIslandSimulationObject(IslandSimulationObject islandSimulationObject,
getIslandSimulationObject(String typeString),removeIslandSimulationObject(IslandSimulationObject islandSimulationObject),
etIslandSimulationObjectIfContains(CopyOnWriteArrayList<String> foodStaffs),
getRandomIslandSimulationObject() - needed for beautiful display, 1 random animal from the cell list is displayed on the screen.
 ### PrintingIslandSimulationStatistics- 
displays statistics:
numberAnimals
numberBornAnimals
numberDeadAnimals 
numberAnimalMoves
numbersPlantsGrew
numberEatenPlants
deathFromStarvation
deathFromOldAge
the number of births,
deaths 
and the number of animals of each specific species on the map
at the moment
startRun(StartThreads)
finishRun(FinishThreads)

### Coordinate -
Coordinates IslandSimulationObjects
### IslandSimulationLoader:
processingInput(),
loadingProgram()

### Yes, a duck can eat both plants and a caterpillar, like all omnivores
