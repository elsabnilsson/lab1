import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    @Test
    void raiseBed() {
        Scania scania = new Scania(0,0);
        scania.raiseBed(10);
        assertEquals(10, scania.getBed().getAngle());
    }

    @Test
    void bedDown() {
        Scania scania = new Scania(0,0);
        scania.raiseBed(10);
        scania.lowerBed(10);
        assertTrue(scania.getBed().isBedDown());
    }

    @Test
    void startEngine() {
        Scania scania = new Scania(0,0);
        scania.raiseBed(10);
        scania.lowerBed(10);
        scania.startEngine();
        assertEquals(0.1, scania.getCurrentSpeed());

    }


}