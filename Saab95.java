import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    public Saab95() {
        super(2, Color.red, 125, "Saab95", 0, 0, 0, 4.8);
        turboOn = false;
    }

    // Turns turbo on
    public void setTurboOn() { turboOn = true; }

    // Turns turbo off
    public void setTurboOff() { turboOn = false; }

    // Returns speed factor of Saab95
    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}

