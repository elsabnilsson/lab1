import javax.swing.*;
import java.awt.*;

public class CarView extends JFrame {
    static final int X = 800;
    static final int Y = 800;

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;

    JLabel gasLabel = new JLabel("Amount of gas");
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Scania Lower Bed");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    DrawPanel drawPanel;

    public CarView(String title, DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        initComponents(title);
    }

    void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new BorderLayout());

        this.add(drawPanel, BorderLayout.CENTER);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner) e.getSource()).getValue());

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(brakeButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(lowerBedButton);
        controlPanel.add(addCarButton);
        controlPanel.add(removeCarButton);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(controlPanel, BorderLayout.CENTER);
        southPanel.add(gasPanel, BorderLayout.WEST);

        JPanel startStopPanel = new JPanel(new GridLayout(1, 2));
        startStopPanel.add(startButton);
        startStopPanel.add(stopButton);

        southPanel.add(startStopPanel, BorderLayout.SOUTH);

        this.add(southPanel, BorderLayout.SOUTH);

        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


