import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @Test
    void getNrDoors() {
        Car volvo240 = new Volvo240();
        assertEquals(4, volvo240.getNrDoors());
    }

    @Test
    void move() {
        Car Saab95 = new Saab95();
        Saab95.startEngine();
        Saab95.move();
        assertEquals(0.1, Saab95.getYpos());
    }

    @Test
    void turnLeft() {
        Car Volvo240 = new Volvo240();
        Volvo240.turnLeft();
        assertEquals(3, Volvo240.getDirection());
    }

    @Test
    void turnRight() {
        Car Saab95 = new Saab95();
        Saab95.turnRight();
        Saab95.turnRight();
        assertEquals(2, Saab95.getDirection());
    }

    // Tests that getEnginePower returns the correct value
    @Test
    void getEnginePower() {
        Car volvo240 = new Volvo240();
        assertEquals(100, volvo240.getEnginePower());
    }

    // Tests that getCurrentSpeed returns the correct value
    @Test
    void getCurrentSpeed() {
        Car volvo240 = new Volvo240();
        assertEquals(0, volvo240.getCurrentSpeed());
    }

    // Tests that getColor returns the right color
    @Test
    void getColor() {
        Car volvo240 = new Volvo240();
        assertEquals(Color.black, volvo240.getColor());
    }

    // Tests that set color works
    @Test
    void setColor() {
        Car volvo240 = new Volvo240();
        volvo240.setColor(Color.red);
        assertEquals(Color.red, volvo240.getColor());
    }

    // Tests that startEngine works
    @Test
    void startEngine() {
        Car volvo240 = new Volvo240();
        volvo240.startEngine();
        assertEquals(0.1, volvo240.getCurrentSpeed());
    }

    // Tests that stopEngine works
    @Test
    void stopEngine() {
        Car volvo240 = new Volvo240();
        volvo240.stopEngine();
        assertEquals(0, volvo240.getCurrentSpeed());
    }

    // Test speedFactor Saab95 with turboOn=false
    @Test
    void speedFactorSaabTurboOff() {
        Saab95 saab95 = new Saab95();
        assertEquals(1.25, saab95.speedFactor());
    }

    // Test speedFactor Saab95 with turboOn=true
    @Test
    void speedFactorSaabTurboOn() {
        Saab95 saab95 = new Saab95();
        saab95.setTurboOn();
        assertEquals(1.625, saab95.speedFactor());
    }

    @Test
    void incrementSpeedVolvo() {
        Car volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.incrementSpeed(1);
        assertEquals(1.35, volvo240.getCurrentSpeed());
    }

    // With turbo off since turbo on/off is already tested
    @Test
    void incrementSpeedSaab() {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.incrementSpeed(1);
        assertEquals(1.35, saab95.getCurrentSpeed());
    }

    // Tests that currentSpeed can't be above enginepower
    @Test
    void incrementSpeedSaabEngine() {
        Car saab95 = new Saab95();
        saab95.startEngine();
        saab95.incrementSpeed(100);
        assertEquals(saab95.getEnginePower(), saab95.getCurrentSpeed());
    }

    // Tests that decrementSpeed works
    @Test
    void decrementSpeed() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.decrementSpeed(0.01);
        assertEquals(0.08750000000000001, volvo240.getCurrentSpeed());
    }

    // Tests that currentSpeed can't be below zero
    @Test
    void decrementSpeedNegative() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.decrementSpeed(1);
        assertEquals(0, volvo240.getCurrentSpeed());
    }

    @Test
    void gasVolvo() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.gas(0.1);
        assertEquals(0.225, volvo240.getCurrentSpeed());
    }

    @Test
    void brakeVolvo() {
        Volvo240 volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.gas(1);
        volvo240.brake(0.1);
        assertEquals(1.225, volvo240.getCurrentSpeed());
    }

    @Test
    void gasSaab95() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        saab95.gas(1);
        assertEquals(1.35, saab95.getCurrentSpeed());
    }

    @Test
    void brakeSaab95() {
        Saab95 saab95 = new Saab95();
        saab95.startEngine();
        saab95.gas(1);
        saab95.brake(0.1);
        assertEquals(1.225, saab95.getCurrentSpeed());
    }



}
