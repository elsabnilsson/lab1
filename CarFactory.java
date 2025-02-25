import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarFactory {
    public static Car createVolvo240() {
        return new Volvo240();
    }

    public static Car createSaab95() {
        return new Saab95();
    }

    public static Car createScania() {
        return new Scania();
    }

    static class WorkshopTest {
        @Test
        void testWorkshop() {
            Workshop<Car> workshop = new Workshop<>(2, 0, 0);
            Car volvo240 = new Volvo240();
            Car saab95 = new Saab95();
            workshop.open();
            volvo240.setPosition(2,1);
            saab95.setPosition(1,2);
            workshop.load(volvo240);
            workshop.load(saab95);
            Assertions.assertEquals(2, workshop.getNrOfCars());
        }

        @Test
        void saabShop() {
            Workshop<Saab95> workshop = new Workshop<>(5, 0, 0);
            Saab95 saab95 = new Saab95();
            saab95.setPosition(5,1);
            workshop.open();
            workshop.load(saab95);
            Assertions.assertEquals(0, workshop.getNrOfCars());
        }

        @Test
        void removeCar() {
            Workshop<Volvo240> workshop = new Workshop<>(2, 0, 0);
            Volvo240 volvo240 = new Volvo240();
            Volvo240 volvo241 = new Volvo240();
            volvo241.setPosition(1,1);
            volvo240.setPosition(3,2);
            workshop.open();
            workshop.load(volvo240);
            workshop.load(volvo241);
            workshop.close();
            workshop.open();
            workshop.unload(volvo240);
            Assertions.assertEquals(1, workshop.getNrOfCars());
        }

        @Test
        void removeCarAndPrint() {
            Workshop<Volvo240> workshop = new Workshop<>(2, 0, 0);
            Volvo240 volvo240 = new Volvo240();
            Volvo240 volvo241 = new Volvo240();
            volvo241.setPosition(1,1);
            volvo240.setPosition(3,2);
            workshop.open();
            workshop.load(volvo240);
            workshop.load(volvo241);
            workshop.close();
            workshop.open();
            workshop.unload(volvo240);
            Assertions.assertTrue(workshop.isCarInShop(volvo241)); }
    }
}
