
public class CarFactory {
    public static Car createVolvo240(int x, int y) {
        return new Volvo240(x, y);
    }

    public static Car createSaab95(int x, int y) {
        return new Saab95(x, y);
    }

    public static Car createScania(int x, int y) {
        return new Scania(x,y);
    }

    public static Car createRandomCar() {

        enum CarType {VOLVO, SAAB, SCANIA}
        CarType carType = CarType.values()[(int) (Math.random() * CarType.values().length)];
        return switch (carType) {
            case SCANIA -> createScania(0,0);
            case SAAB -> createSaab95(0,0);
            case VOLVO -> createVolvo240(0,0);
        };

    }
}
