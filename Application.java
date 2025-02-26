import java.util.ArrayList;

public class Application {
    static ArrayList<Car> cars = new ArrayList<>();

    static CarController frame;

    public void initialize() {
        CarView cvg = new CarView();
        frame = new CarController("CarSim 1.0", cvg, CarView.X, CarView.Y -240);
    }

    public static void main(String[] args) {

        Application rp = new Application();
        rp.initialize();

        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());

        cars.get(0).setPosition(300,0);
        cars.get(1).setPosition(300,100);
        cars.get(2).setPosition(0,200);

    }
}
