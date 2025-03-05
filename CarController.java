import javax.swing.*;

public class CarController {
    private final CarModel carModel;
    private final CarView carView;
    private final Timer timer;

    public CarController(CarModel carModel, CarView carView) {
        this.carModel = carModel;
        this.carView = carView;
        this.timer = new Timer(50, new TimerListener(carModel, carView.drawPanel));
        this.timer.start();
        addListeners();
    }

    private void addListeners() {
        carView.gasButton.addActionListener(e -> gas(carView.gasAmount));
        carView.brakeButton.addActionListener(e -> brake(carView.gasAmount));
        carView.turboOnButton.addActionListener(e -> turboOn());
        carView.turboOffButton.addActionListener(e -> turboOff());
        carView.liftBedButton.addActionListener(e -> liftBed());
        carView.lowerBedButton.addActionListener(e -> lowerBed());
        carView.addCarButton.addActionListener(e -> addCar());
        carView.removeCarButton.addActionListener(e -> removeCar());
        carView.startButton.addActionListener(e -> startCars());
        carView.stopButton.addActionListener(e -> stopCars());
    }

    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : carModel.getCars()) {
            car.gas(gas);
        }
    }

    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : carModel.getCars()) {
            car.brake(brake);
        }
    }

    private void startCars() {
        for (Car car : carModel.getCars()) {
            car.startEngine();
        }
    }

    private void stopCars() {
        for (Car car : carModel.getCars()) {
            car.stopEngine();
        }
    }

    private void turboOn() {
        for (Car car : carModel.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    private void turboOff() {
        for (Car car : carModel.getCars()) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    private void liftBed() {
        for (Car car : carModel.getCars()) {
            if (car instanceof Scania) {
                ((Scania) car).raiseBed(70);
            }
        }
    }

    private void lowerBed() {
        for (Car car : carModel.getCars()) {
            if (car instanceof Scania) {
                ((Scania) car).lowerBed(70);
            }
        }
    }

    private void addCar() {
        carModel.addCar(CarFactory.createRandomCar());
    }

    private void removeCar() {
        carModel.removeCar();
    }
}



