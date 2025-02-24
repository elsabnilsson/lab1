import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
public class CarViewFunctions { // extends CarView {
    private CarController carC;

    */
/*JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();*//*


    public CarViewFunctions(String framename, CarController cc) {
        //super(framename, cc);
        this.carC = cc;
        initComponents(framename);
    }

    // This actionListener is for the gas button only
    // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.gas(gasAmount);
        }
    });
        brakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.brake(gasAmount);
        }
    });
        turboOnButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.turboOn();
        }
    });
        turboOffButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.turboOff();
        }
    });
        liftBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.liftBed();
        }
    });
        lowerBedButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.lowerBed();
        }
    });
        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.startCars();
        }
    });
        stopButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { this.carC.stopCars();
        }
    }


}
*/
