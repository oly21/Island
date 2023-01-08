import com.project.islandSimulationObjects.Animals.Animal;

public class CoordinateMonitorThread extends Thread {

    private Animal animal;

    public CoordinateMonitorThread(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            if (animal.getX() == -1 || animal.getY() == -1) {
            //    animal.getThread().interrupt();
                break;
            }
        }
    }
}