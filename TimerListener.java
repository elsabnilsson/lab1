import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {
    CarController carController;

    public TimerListener(CarController carController) {
        this.carController = carController;
    }

    public void actionPerformed(ActionEvent e) {
        for (Car car : Application.cars) {

            car.move();

            if (car.getYpos() > 500 || car.getYpos() < 0) {
                car.turnLeft();
                car.turnLeft();
            }
            if (car.getXpos() > 700 || car.getXpos() < 0) {
                car.turnLeft();
                car.turnLeft();
            }
            Application.frame.drawPanel.repaint();
        }
    }
}
