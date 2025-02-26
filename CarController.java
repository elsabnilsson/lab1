import javax.swing.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    DrawPanel drawPanel;
    Timer timer = new Timer(delay, new TimerListener(this));


    public CarController(String framename, CarView cvg, int X, int Y) {
        drawPanel = new DrawPanel(X, Y);
        cvg.initComponents(framename, drawPanel);

        timer.start();
        new CarFunctions(cvg).addListeners();

    }

    // Calls the gas method for each car once
    static void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : Application.cars) {
            car.gas(gas); }}

    static void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : Application.cars) {
            car.brake(brake); }}

    static void startCars() {
        for (Car car : Application.cars) {
            car.startEngine(); }}

    static void stopCars() {
        for (Car car : Application.cars) {
            car.stopEngine(); }}

    static void turboOn() {
        for (Car car : Application.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn(); }}}

    static void turboOff() {
        for (Car car : Application.cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff(); }}}

    static void liftBed() {
        for (Car car : Application.cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseBed(70); }}}

    static void lowerBed() {
        for (Car car : Application.cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerBed(0); }}}

    static void addCar() {
        System.out.println("Adding a car: " );
        int size = Application.cars.size();
        if (size < 10) {
            enum CarType {VOLVO, SAAB, SCANIA}
            CarType carType = CarType.values()[(int) (Math.random() * CarType.values().length)];
            switch (carType) {
                case SCANIA:
                    Application.cars.add(CarFactory.createVolvo240());
                    break;
                case SAAB:
                    Application.cars.add(CarFactory.createSaab95());
                    break;
                case VOLVO:
                    Application.cars.add(CarFactory.createScania());
                    break;
            }}}

    static void removeCar() {
        if (!Application.cars.isEmpty()) {
            Application.cars.remove(Application.cars.size() - 1); }}
}
