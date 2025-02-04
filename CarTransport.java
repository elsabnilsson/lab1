import java.util.Stack;

public class CarTransport extends Scania implements Loading<Car> {
    private final int maxCars;
    private final double maxCarLength = 5.5;
    private Stack<Car> loadedCars;
    private boolean rampDown;
    private final double loadingDistance = 5.0;

    public CarTransport(int maxCars){
        super();
        this.maxCars = maxCars;
        this.loadedCars = new Stack<Car>();
        this.rampDown = false;
    }

    public Stack<Car> getLoadedCars() {
        return loadedCars;
    }

    // raises the bed of the cartransport
    public void open() {
        rampDown = true;
    }
    // lowers the bed of the cartransport
    public void close() {
        rampDown = false;
    }

    // returns if the ramp is down or not
    public boolean isRampDown() {
        return rampDown;
    }

    // checks how far away the car is from the ramp
    public double distToObject(Car car) {
        return Math.sqrt(Math.pow(getXpos() - car.getXpos(), 2) + Math.pow(getYpos() - car.getYpos(), 2));
    }

    // If ramp down, car not too big, car transport not full and distance between the vehicles not too far - Then the car will be loaded.
    public void load(Car car) {
        if (!rampDown) {
            throw new IllegalArgumentException("Can't load car while ramp is up"); }
        if (car.getCarLength() > maxCarLength) {
            throw new IllegalArgumentException("Car is too long to fit on the truck"); }
        if (loadedCars.size() >= maxCars) {
            throw new IllegalArgumentException("Truck is full"); }
        if (distToObject(car) <= loadingDistance) {
            loadedCars.push(car);
            car.setPosition(getXpos(),getYpos()); }
    }
    // unloads the most recently loaded car (LIFO)
    public void unload() {
        if (!rampDown) {
            throw new IllegalArgumentException("Can't unload car while ramp is up"); }
        if (loadedCars.isEmpty()) {
            throw new IllegalArgumentException("Truck is empty"); }
        Car car = loadedCars.pop();
        car.setPosition(getXpos() + loadingDistance, getYpos());
    }

    // moves the car and all the loaded cars
    @Override
    public void move() {
        //if (rampDown) {
           // throw new IllegalArgumentException("Can't move while ramp is down"); }
        super.move();
        for (Car car : loadedCars) {
            car.setPosition(getXpos(), getYpos()); }
    }

    @Override
    protected boolean canStart() {
        if (rampDown) {
            throw new IllegalArgumentException("Can't start engine while ramp is down"); }
        return super.canStart();
    }
}
