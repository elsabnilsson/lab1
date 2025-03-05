import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerListener implements ActionListener {

    CarModel carModel;
    private final DrawPanel drawPanel;
    Workshop<Volvo240> volvoWorkshop = new Workshop<>(3, 300, 300);


    public TimerListener(CarModel carModel, DrawPanel drawPanel) {
        this.carModel = carModel;
        this.drawPanel = drawPanel;
    }

    public void actionPerformed(ActionEvent e) {
        for (Car car : carModel.getCars()) {

            car.move();

            if (car.getYpos() > 500 || car.getYpos() < 0) {
                car.turnLeft();
                car.turnLeft();
            }
            if (car.getXpos() > 700 || car.getXpos() < 0) {
                car.turnLeft();
                car.turnLeft();
            }


            if(Math.abs(car.getXpos() - volvoWorkshop.getXpos()) < 5 && Math.abs(car.getYpos() - volvoWorkshop.getYpos()) < 5) {
                if(car instanceof Volvo240) {
                    volvoWorkshop.load((Volvo240) car);
                    car.setPosition(volvoWorkshop.getXpos(), volvoWorkshop.getYpos());
                    car.stopEngine();
                }
            }


            drawPanel.repaint();
        }
    }
}
