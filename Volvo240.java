import java.awt.*;

public class Volvo240 extends Car{
    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4,Color.black,100,"Volvo240", 0, 0, 0, 4.9);
    }

    // Returns speed factor of Volvo240
    protected double speedFactor() { return getEnginePower() * 0.01 * trimFactor; }

    protected boolean canStart() {
        return true;
    }

}

