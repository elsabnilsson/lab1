import java.awt.*;

public class Saab95 extends Car {
    private boolean turboOn;

    private Saab95() {
        super(2, Color.red, 125, "Saab95", 0, 0, "N");
        turboOn = false;
    }

    private void setTurboOn() { turboOn = true; }

    private void setTurboOff() { turboOn = false; }

    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}