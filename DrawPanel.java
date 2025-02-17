import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    //ArrayList<BufferedImage> carImages = new ArrayList<>();
   // ArrayList<Point> carPoints = new ArrayList<>();

    static Point[] points = new Point[] {new Point(0, 100), new Point(300,0), new Point(0, 200), new Point(300, 300)};
    BufferedImage[] images = new BufferedImage[4];
    // Just a single image, TODO: Generalize

/*    BufferedImage saabImage;
    BufferedImage volvoImage;
    BufferedImage scaniaImage;

    // To keep track of a single car's position

    Point saabPoint = new Point(0, 100);
    Point volvoPoint = new Point(300,0);
    Point scaniaPoint = new Point(0, 200);*/

    //BufferedImage volvoWorkshopImage;
    //Point volvoWorkshopPoint = new Point(300,300);

   /* public void addCarImage(BufferedImage...carImages){
        for (BufferedImage carImage : carImages) {
            this.carImages.add(carImage);
        }
    }

    public void addCarPoint(Point...carPoints){
        for (Point carPoint : carPoints) {
            this.carPoints.add(carPoint);
        }
    }*/



    // TODO: Make this general for all cars
    void moveit(int i, int x, int y){

        points[i].x = x;
        points[i].y = y;
    }

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
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
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
        for (int i = 0; i < images.length; i++) {
            g.drawImage(images[i], points[i].x, points[i].y, null);
        }
        for (int i = 0; i < images.length; i++) {
            System.out.println("Drawing car " + i + " at: " + points[i]);
            g.drawImage(images[i], points[i].x, points[i].y, null);
        }
        /*
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);*/
        //g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
    }

    public static int[] getCoords(int i) {
        return new int[]{points[i].x, points[i].y};
    }
}
