import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CarViewFunctions {
    CarViewGraphics carViewGraphics;

    public CarViewFunctions(CarViewGraphics carViewGraphics) {
        this.carViewGraphics = carViewGraphics;
    }

    public void addListeners() {
        carViewGraphics.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.gas(carViewGraphics.gasAmount);
            }
        });

        carViewGraphics.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.brake(carViewGraphics.gasAmount);
            }
        });

        carViewGraphics.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.turboOn();
            }
        });

        carViewGraphics.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.turboOff();
            }
        });

        carViewGraphics.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.liftBed();
            }
        });

        carViewGraphics.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.lowerBed();
            }
        });

        carViewGraphics.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.startCars();
            }
        });

        carViewGraphics.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarController.stopCars();
            }
        });
    }

}

