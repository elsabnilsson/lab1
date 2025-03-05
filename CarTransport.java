import java.util.Stack;

public class CarTransport extends Scania implements Loading<Car> {
    private final int maxCars;
    private final double maxCarLength = 5.5;
    private final Stack<Car> loadedCars;
    private final double loadingDistance = 5.0;
    private final TruckBed ramp;

    public CarTransport(int maxCars, int x, int y){
        super(x,y);
        this.maxCars = maxCars;
        this.loadedCars = new Stack<>();
        this.ramp = new TruckBed(); }

    public boolean containsCar(Car car) {
        return loadedCars.contains(car); }

    public TruckBed getRamp() {
        return ramp; }

    // Raises the bed of the carTransport
    // open when angle = 70
    public void open() {
        ramp.raiseBed(70);
    }
    // Lowers the bed of the carTransport
    // close when angle = 0
    public void close() {
        ramp.lowerBed(70); }

    // Returns if the ramp is down or not
    public boolean isRampDown() {
        return ramp.isBedDown(); }

    // Checks how far away the car is from the ramp
    public double distToObject(Car car) {
        return Math.sqrt(Math.pow(getXpos() - car.getXpos(), 2) + Math.pow(getYpos() - car.getYpos(), 2));
    }

    // If ramp down, car not too big, car transport not full and distance between the vehicles not too far - Then the car will be loaded.
    public void load(Car car) {
        if (isRampDown()) {
            throw new IllegalArgumentException("Can't load car while ramp is up"); }
        if (car.getCarLength() > maxCarLength) {
            throw new IllegalArgumentException("Car is too long to fit on the truck"); }
        if (loadedCars.size() >= maxCars) {
            throw new IllegalArgumentException("Truck is full"); }
        if (distToObject(car) <= loadingDistance) {
            loadedCars.push(car);
            car.setPosition(getXpos(),getYpos()); }
    }

    // Unloads the most recently loaded car (LIFO)
    public void unload() {
        if (isRampDown()) {
            throw new IllegalArgumentException("Can't unload car while ramp is up"); }
        if (loadedCars.isEmpty()) {
            throw new IllegalArgumentException("Truck is empty"); }
        Car car = loadedCars.pop();
        car.setPosition(getXpos() + loadingDistance, getYpos());
    }

    // Moves the car and all the loaded cars
    @Override
    public void move() {
        super.move();
        for (Car car : loadedCars) {
            car.setPosition(getXpos(), getYpos()); }
    }

    @Override
    protected boolean canStart() {
        if (!isRampDown()) {
            throw new IllegalArgumentException("Can't start engine while ramp is down"); }
        return super.canStart();
    }
}
