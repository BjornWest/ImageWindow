/**
 *   PixelArrayExercise: Playing around with pixels
 *   @author Gabriel Skoglund
 *   @version 2020-10-08
 */

public class PixelArrayExercise{

    public static void main(String[] args){
        ImageWindow image = new ImageWindow();
        // You can get a 2d array of pixels from the image with this method
        Pixel[][] pixels = image.getPixels();

        // An example: we loop over all the pixels in the image
        // and set the top half to one color and the bottom half
        // to another.
        double k = 800;
        int stretch = 1;
        double xAmount = 2;
        double yAmount = 2;
        double space = 1;

        for (int x = 0; x < image.WIDTH; x++){
            for (int y = 0; y < image.HEIGHT; y++){
                for (int i = 1; i <k+1; i++) {

                    double koefficient1 = 1/(1-((2/k)*(i))+(1/(k*k))*(i)*(i));
                    for (int j = 1; j <yAmount+1; j++) {
                        for (int l = 1; l <xAmount+1; l++) {
                            if ((int)(koefficient1*(Math.pow(Math.abs(image.HEIGHT/(2*yAmount/(j*2-1))-y),2)+stretch*Math.pow(Math.abs(image.WIDTH/(2*xAmount/(l*2-1))-x),2))/1000)  == (int)(image.HEIGHT*image.WIDTH/Math.pow(2*space,2))/1000){ //&& koefficient1*(stretch*Math.pow(Math.abs(image.HEIGHT/(2*yAmount/(2*yAmount-1))-y),2)+Math.pow(Math.abs(image.WIDTH/(2*xAmount/(2*xAmount-1))-x),2))  > image.HEIGHT*image.WIDTH/Math.pow(2*space,2)){
                                int red = pixels[x][y].getR();
                                int green = pixels[x][y].getG();
                                int blue = pixels[x][y].getB();
                                pixels[x][y].setRGB(red+125*Math.abs(Math.sin(i*0.1))*i/(2*k-i),0, 0);
                        }

                        }
                    }

                }


                }



        }

        // Remember to set the pixels of the image and update it
        image.setPixels(pixels);
        image.update();
    }

}