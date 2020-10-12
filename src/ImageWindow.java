/**
 *   ImageWindow: used to create a window and display the pixels
 *   that we are manipulating
 *   @author Gabriel Skoglund
 *   @version 2020-10-08
 */

import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageWindow{

    public static int WIDTH = 700;
    public static int HEIGHT = 700;

    private JFrame window;
    private JPanel pane;
    private BufferedImage img;

    public ImageWindow(){
        // Create a new JFrame to be the app window in which to display the image
        window = new JFrame("INDA group exercise: Pixel array");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new BufferedImage that we can manipulate
        img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);

        // Create a JPanel
        // We override the default paintComponent method to draw our image
        pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        };

        // Display the image in the window
        pane.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        window.add(pane);
        window.pack();
        window.setVisible(true);
    }

    /**
     *   Get the pixels from the image
     *   @return A 2d array of Pixels
     */
    public Pixel[][] getPixels(){
        int[] imagePix = img.getRGB(0, 0, img.getWidth(), img.getHeight(),
                null, 0, img.getWidth());

        Pixel[][] pixels = new Pixel[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x++){
            for (int y = 0; y < HEIGHT; y++){
                pixels[x][y] = new Pixel(imagePix[y*WIDTH + x]);
            }
        }

        return pixels;
    }

    /**
     *   Set the image pixels
     *   @param pixels a 2d array of Pixels
     */
    public void setPixels(Pixel[][] pixels){
        int[] newImgPix = new int[WIDTH * HEIGHT];

        for (int x = 0; x < WIDTH; x++){
            for (int y = 0; y < HEIGHT; y++){
                newImgPix[y*WIDTH + x] = pixels[x][y].toARGB();
            }
        }

        img.setRGB(0, 0, img.getWidth(), img.getHeight(),
                newImgPix, 0, img.getWidth());
    }

    /**
     *   Draw the image to the window again
     */
    public void update(){
        pane.repaint();
    }
}