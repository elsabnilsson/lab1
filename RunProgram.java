import java.util.ArrayList;

public class RunProgram {
    static ArrayList<Car> cars = new ArrayList<>();

    static CarController frame;

    public void initialize() {
        CarViewGraphics cvg = new CarViewGraphics();
        frame = new CarController("CarSim 1.0", cvg, CarViewGraphics.X, CarViewGraphics.Y -240);

    }

    public static void main(String[] args) {
        RunProgram rp = new RunProgram();
        rp.initialize();

        cars.add(CarFactory.createVolvo240());
        cars.add(CarFactory.createSaab95());
        cars.add(CarFactory.createScania());

        cars.get(0).setPosition(300,0);
        cars.get(1).setPosition(300,100);
        cars.get(2).setPosition(0,200);



        //position??


       /* // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        cc.cars.get(0).setPosition(300,0);
        cc.cars.get(1).setPosition(300,100);
        cc.cars.get(2).setPosition(0,200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();*/
    }
}
