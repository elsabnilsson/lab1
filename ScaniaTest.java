import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    @Test
    void raiseBed() {
        Scania scania = new Scania();
        scania.raiseBed(10);
        assertEquals(10, scania.getAngle());
    }


}