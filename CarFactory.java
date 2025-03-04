
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

    public static Car createRandomCar() {

        enum CarType {VOLVO, SAAB, SCANIA}
        CarType carType = CarType.values()[(int) (Math.random() * CarType.values().length)];
        return switch (carType) {
            case SCANIA -> createScania();
            case SAAB -> createSaab95();
            case VOLVO -> createVolvo240();
        };

    }
}
