import java.awt.*;

public class Scania extends Car{
    private final TruckBed bed;

    public Scania(int x, int y) {
        super(2, Color.blue, 800, "Scania", x, y, 0, 12);
        this.bed = new TruckBed();
    }

    public TruckBed getBed() {
        return bed; }


    // Returns if the car is not moving
    public boolean isCarNotMoving() {
        return getCurrentSpeed() == 0;
    }

    // Raises the bed of the Scania
    public void raiseBed(double amount) {
        if (isCarNotMoving()) {
            bed.raiseBed(amount); }
        else {
            throw new IllegalArgumentException("Can't raise bed while moving"); }
    }

    // Lowers the bed of the Scania
    public void lowerBed(double amount) {
        bed.lowerBed(amount);
    }

    // Returns speed factor of Scania
    protected double speedFactor() {
        return getEnginePower() * 0.01; }

    protected boolean canStart() {
        if (!bed.isBedDown()) {
            throw new IllegalArgumentException("Can't start engine while bed is raised"); }
        else {
            return true; }
    }
}