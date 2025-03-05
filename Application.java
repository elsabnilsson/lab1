

public class Application {
    public static void main(String[] args) {
        CarModel carModel = new CarModel();
        carModel.addCar(CarFactory.createVolvo240(300,0));
        carModel.addCar(CarFactory.createSaab95(300,100));
        carModel.addCar(CarFactory.createScania(300,200));


        DrawPanel drawPanel = new DrawPanel(CarView.X, CarView.Y, carModel);
        CarView carView = new CarView("Car Simulator", drawPanel);
        new CarController(carModel, carView);
    }
}
