import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    BufferedImage workshopImage;

    Map<String, BufferedImage> images = new HashMap<>();

    private final CarModel carModel;

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarModel carModel) {
        this.carModel = carModel;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            workshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

            images.put("Volvo240", volvoImage);
            images.put("Saab95", saabImage);
            images.put("Scania", scaniaImage);
            images.put("Workshop", workshopImage);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    //@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Car car : carModel.getCars()) {
            g. drawImage(images.get(car.getModelName()), (int) Math.ceil(car.getXpos()), (int) Math.ceil(car.getYpos()), null); }

        g.drawImage(images.get("Workshop"), 300, 300, null);
    }
}


