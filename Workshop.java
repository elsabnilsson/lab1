import java.util.ArrayList;

public class Workshop<T extends Car> {
    private ArrayList<T> carsInShop;
    //private ArrayList<Car> carsInShop;
    private int maxCars;


    public Workshop(int maxCars) {
        this.carsInShop = new ArrayList<>();
        this.maxCars = maxCars;
    }

    public int getNrOfCars() {
        return carsInShop.size();
    }

    public void addCar(T car) {
        if (carsInShop.size() < maxCars) {
            carsInShop.add(car); }
        else {
            throw new IllegalArgumentException("Workshop is full"); }
    }

    public void removeCar(T car) {
        if (carsInShop.contains(car)) {
            carsInShop.remove(car);
        }
        else {
            throw new IllegalArgumentException("Car not in workshop"); }
    }

}
