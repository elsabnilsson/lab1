
import java.util.ArrayList;
import java.util.List;

public class CarModel {
    private ArrayList<Car> cars;

    public CarModel(){

        cars = new ArrayList<>();

    }
    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        if (cars.size() < 10) {
            cars.add(car);
        }
    }

    public void removeCar() {
        if (!cars.isEmpty()) {
            cars.removeLast();
        }
    }
}

