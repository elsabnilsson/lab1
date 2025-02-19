import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, 300, 300);

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());

        cc.cars.get(0).setPosition(300,0);
        cc.cars.get(1).setPosition(300,100);
        cc.cars.get(2).setPosition(0,200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < cars.size(); i++) {
                Car car = cars.get(i);
                car.move();

                if (car.getYpos() > 500 || car.getYpos() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }
                if (car.getXpos() > 700 || car.getXpos() < 0) {
                    car.turnLeft();
                    car.turnLeft();
                }

                int workshopX = DrawPanel.getCoords(3)[0];
                int workshopY = DrawPanel.getCoords(3)[1];

                if(Math.abs(car.getXpos() - workshopX) < 5 && Math.abs(car.getYpos() - workshopY) < 5) {
                    if(car instanceof Volvo240) {
                        volvoWorkshop.load((Volvo240) car);
                        car.setPosition(workshopX, workshopY);
                        car.stopEngine();
                    }
                }

                int x = (int) Math.round(car.getXpos());
                int y = (int) Math.round(car.getYpos());
                frame.drawPanel.moveit(i, x, y);
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }

    void startCars() {
        for (Car car : cars) {
            car.startEngine();
        }
    }

    void stopCars() {
        for (Car car : cars) {
            car.stopEngine();
        }
    }

    void turboOn() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Car car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).raiseBed(70);
            }
        }
    }

    void lowerBed() {
        for (Car car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).lowerBed(0);
            }
        }
    }


}
