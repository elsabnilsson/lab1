import java.util.ArrayList;

public class Model {
    private final ArrayList<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        if (cars.size() < 10) {
            cars.add(car);
        }
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            cars.remove(cars.size() - 1);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}