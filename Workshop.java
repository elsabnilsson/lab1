import java.awt.*;
import java.util.ArrayList;

public class Workshop<T extends Car> implements Loading<T>{
    private ArrayList<T> carsInShop;
    private int maxCars;
    private boolean doorOpen;
    private double Xpos;
    private double Ypos;
    private final double loadingDistance = 5.0;


    public Workshop(int maxCars, double Xpos, double Ypos) {
        this.carsInShop = new ArrayList<>();
        this.maxCars = maxCars;
        this.doorOpen = false;
        this.Xpos = Xpos;
        this.Ypos = Ypos;
    }

    public double getXpos() { return Xpos; }
    public double getYpos() { return Ypos; }

    // returns the number of cars in the workshop
    public int getNrOfCars() {
        return carsInShop.size();
    }

    // Opens the door to the workshop
    public void open() { doorOpen = true; }

    // Closes the door to the workshop
    public void close() { doorOpen = false; }

    public boolean isDoorOpen() { return doorOpen; }

    // checks how far the car is from the workshops door
    public double distToObject(T car) {
        return Math.sqrt(Math.pow(getXpos() - car.getXpos(), 2) + Math.pow(getYpos() - car.getYpos(), 2));
    }

    // returns a list of all the cars in the workshop
    public ArrayList<T> listCars() {
        return new ArrayList<>(carsInShop);
    }


    // loads a car into the workshop
    public void load(T car) {
        if (carsInShop.size() < maxCars) {
            if (distToObject(car) <= loadingDistance) {
                if (doorOpen) {
                    carsInShop.add(car); } }}
        else {
            throw new IllegalArgumentException("Workshop is full"); }
    }
    // removes a car from the workshop
    public void unload(T car) {
        if (carsInShop.contains(car)) {
            if (doorOpen) {
            carsInShop.remove(car);
            car.setPosition(Xpos + loadingDistance, Ypos);
        }}
        else {
            throw new IllegalArgumentException("Car not in workshop"); }
    }
}
