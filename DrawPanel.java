import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    //static Point[] points = new Point[] {new Point(0, 100), new Point(300,0), new Point(0, 200), new Point(300, 300)};
    //BufferedImage[] images = new BufferedImage[4];
    // Just a single image, TODO: Generalize

    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    Map<String, BufferedImage> images = new HashMap<>();


  /*  // TODO: Make this general for all cars
    void moveit(int i, int x, int y){
        points[i].x = x;
        points[i].y = y;
    }*/

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
          /*  images[0] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            images[1] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            images[2] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            images[3] = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
*/
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

            images.put("Volvo240", volvoImage);
            images.put("Saab95", saabImage);
            images.put("Scania", scaniaImage);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*for (int i = 0; i < images.length; i++) {
            g.drawImage(images[i], points[i].x, points[i].y, null);
        }*/
        for (Car car : RunProgram.cars) {


            g. drawImage(images.get(car.getModelName()), (int) Math.ceil(car.getXpos()), (int) Math.ceil(car.getYpos()), null);


        }

    }

/*    public static int[] getCoords(int i) {
        return new int[]{points[i].x, points[i].y};
    }*/
}
