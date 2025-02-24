import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TimerListener implements ActionListener {
    CarController carController;
   // List<Car> cars = carController.cars;
   // Workshop<Volvo240> volvoWorkshop = carController.volvoWorkshop;
   // CarView frame = carController.frame;

    public TimerListener(CarController carController) {
        this.carController = carController;
    }



    public void actionPerformed(ActionEvent e) {
        for (Car car : RunProgram.cars) {

            car.move();

            if (car.getYpos() > 500 || car.getYpos() < 0) {
                car.turnLeft();
                car.turnLeft();
            }
            if (car.getXpos() > 700 || car.getXpos() < 0) {
                car.turnLeft();
                car.turnLeft();
            }

            //int workshopX = DrawPanel.getCoords(3)[0];
            //int workshopY = DrawPanel.getCoords(3)[1];

            /*if(Math.abs(car.getXpos() - workshopX) < 5 && Math.abs(car.getYpos() - workshopY) < 5) {
                if(car instanceof Volvo240) {
                    volvoWorkshop.load((Volvo240) car);
                    car.setPosition(workshopX, workshopY);
                    car.stopEngine();
                }
            }*/

            //int x = (int) Math.round(car.getXpos());
            //int y = (int) Math.round(car.getYpos());
            //frame.drawPanel.moveit(i, x, y);
            RunProgram.frame.drawPanel.repaint();
        }
    }
}
