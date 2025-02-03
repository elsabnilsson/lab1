import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class CarTransport extends Scania{
    private int maxCars;
    private double maxCarLength = 5.5;
    private Stack<Car> loadedCars;
    private boolean rampDown;
    private double loadingDistance = 5.0;

    public CarTransport(int maxCars){
        super();
        this.maxCars = maxCars;
        this.loadedCars = new Stack<Car>();
        this.rampDown = false;
    }

    public Stack<Car> getLoadedCars() {
        return loadedCars;
    }

    public void raiseBed() {
        setAngle(70);
        super.raiseBed(getAngle());
        rampDown = true;
    }

    public void lowerBed() {
        setAngle(0);
        super.lowerBed(getAngle());
        rampDown = false;
    }

    public boolean isRampDown() {
        return rampDown;
    }

    private double getDistanceToCar(Car car) {
        return Math.sqrt(Math.pow(getXpos() - car.getXpos(), 2) + Math.pow(getYpos() - car.getYpos(), 2));
    }

    // If ramp down, car not too big, car transport not full and distance between the vehicles not too far - Then the car will be loaded.
    public void loadCar(Car car) {
        if (!rampDown) {
            throw new IllegalArgumentException("Can't load car while ramp is up"); }
        if (car.getCarLength() > maxCarLength) {
            throw new IllegalArgumentException("Car is too long to fit on the truck"); }
        if (loadedCars.size() >= maxCars) {
            throw new IllegalArgumentException("Truck is full"); }
        if ( getDistanceToCar(car) <= loadingDistance) {
            loadedCars.push(car);
            car.setPosition(getXpos(),getYpos()); }
    }

    public void unloadCar() {
        if (!rampDown) {
            throw new IllegalArgumentException("Can't unload car while ramp is up"); }
        if (loadedCars.isEmpty()) {
            throw new IllegalArgumentException("Truck is empty"); }
        Car car = loadedCars.pop();
        car.setPosition(getXpos() + loadingDistance, getYpos());
    }

    @Override
    public void move() {
        if (rampDown) {
            throw new IllegalArgumentException("Can't move while ramp is down"); }
        super.move();
        for (Car car : loadedCars) {
            car.setPosition(getXpos(), getYpos()); }
    }
}
