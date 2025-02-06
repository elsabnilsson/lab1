import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTransportTest {
    @Test
    void transportCar() {
        CarTransport carTransport = new CarTransport(1);
        carTransport.open();
        assertEquals(70, carTransport.getRamp().getAngle());
    }

    // Tries to pick up a car that's too far away from the carTransport
    @Test
    void pickUpCar() {
        CarTransport carTransport = new CarTransport(1);
        Car volvo240 = new Volvo240();
        volvo240.setPosition(2,3);
        carTransport.open();
        carTransport.load(volvo240);
        assertTrue(carTransport.containsCar(volvo240));
    }

    // Test to make sure loaded cars move with the carTransport
    @Test
    void carsMovingWithCarTransport() {
        CarTransport carTransport = new CarTransport(1);
        carTransport.open();
        Car volvo240 = new Volvo240();
        volvo240.setPosition(1,2);
        carTransport.load(volvo240);
        carTransport.close();
        carTransport.startEngine();
        carTransport.gas(0.5);
        carTransport.turnRight();
        carTransport.move();
        assertEquals(4.1, volvo240.getXpos());
    }


    // Test to make sure the cars position after transport is correct in
    // relation to the carTransports position.
    @Test
    void unload() {
        CarTransport carTransport = new CarTransport(1);
        carTransport.setPosition(0,0);
        carTransport.open();
        Car volvo240 = new Volvo240();
        carTransport.load(volvo240);
        carTransport.unload();
        assertEquals(5, volvo240.getXpos());
    }
}