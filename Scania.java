import java.awt.*;

public class Scania extends Car{
    private double Angle;
    private final double maxAngle = 70;
    private final double minAngle = 0;

    public Scania() {
        super(2, Color.blue, 800, "Scania", 0, 0, 0, 12);
        Angle = 0;
    }

    public double getAngle() {
        return Angle;
    }

    public void setAngle(double angle) {
        if (angle >= minAngle && angle <= maxAngle) {
            Angle = angle; }
        else {
            throw new IllegalArgumentException("Angle must be between 0 and 70"); }
    }

    public boolean isCarNotMoving() {
        return getCurrentSpeed() == 0;
    }

    public void raiseBed(double amount) {
        if (isCarNotMoving()) {
            Angle = Math.min(Angle + amount, maxAngle); }
        else {
            throw new IllegalArgumentException("Can't raise bed while moving"); }
    }

    public void lowerBed(double amount) {
        Angle = Math.max(Angle - amount, minAngle);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01; }

    @Override
    public void startEngine() {
        if (Angle == 0) {
            super.startEngine(); }
        else {
            throw new IllegalArgumentException("Can't start engine while bed is raised");
        }
    }
}
