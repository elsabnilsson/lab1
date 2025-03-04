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
    Timer timer;


    //Workshop<Volvo240> volvoWorkshop = new Workshop<>(3, 300, 300);


    public CarController(String framename, CarView cvg, int X, int Y) {
        drawPanel = new DrawPanel(X, Y);
        cvg.initComponents(framename, drawPanel);
        timer = new Timer(delay, new TimerListener(this));
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
                ((Scania) car).lowerBed(70); }}}

    static void addCar() {
        int size = Application.cars.size();
        if (size < 10) {

            Application.cars.add(CarFactory.createRandomCar());


        }}

    static void removeCar() {
        if (!Application.cars.isEmpty()) {
            Application.cars.removeLast();} }

}
