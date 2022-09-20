import java.util.*;


/**
 *   PixelArrayExercise: Playing around with pixels
 *   @author Gabriel Skoglund
 *   @version 2020-10-08
 */

public class CoordsSave{
    public static  boolean invert = false;
    public static boolean mirror = false;
    public static void main(String[] args) throws InterruptedException {
        ImageWindow image = new ImageWindow();
        Pixel[][] pixels = image.getPixels();
        Rotation rotation = new Rotation();
        Generate generate = new Generate();
        Image.interval = 2000;

        double circles = 1000;
        boolean fade = true;
        int[] circleGrowth ={5,10,50,150,300,1000};

        for (int z = 0; z <circleGrowth.length; z++) {
                //circles = circleGrowth[z];

            double k = 3000;
            circles+=0;
            System.out.println("circles: " + circles);
            double[][] both;
            both = generate.radAng((int) circles);
            int finalRadius = 2;
            int vectorThicc = 10;
            double vectorRadius = 1.5;
            double[][][] allCoords = new double[(int) k][(int)circles][2];
            double[][] coords = new double[(int) k][2];
            double[][][][] vectorCoords = new double[(int)k][(int)circles][vectorThicc][2];
            for (int i = 0; i < k; i++) {
                double[] rads = both[0];
                double[] roteet = new double[(int) circles];
                double[] axis = {image.WIDTH / 2, image.HEIGHT / 2};
                for (int m = 0; m < circles; m++) {
                    double nRotate;
                    if (m % 2 == 1) {
                        nRotate = (m+1) / 2;
                    } else {
                        nRotate = -(m) / 2;
                    }
                    roteet[m] = both[1][m] + i * nRotate * Math.PI * 2 / k;
                }
                allCoords[i] = rotation.multiAxis(rads, axis, (int) circles, roteet);
                coords[i] = allCoords[i][(int)circles];
                for (int j = 0; j < circles; j++) {
                    double xPointDiff = allCoords[i][j+1][0]-allCoords[i][j][0];
                    double yPointDiff = allCoords[i][j+1][1]-allCoords[i][j][1];
                    for (int l = 0; l < vectorThicc; l++) {
                        vectorCoords[i][j][l][0] = allCoords[i][j][0]+xPointDiff*l/vectorThicc;
                        vectorCoords[i][j][l][1] =  allCoords[i][j][1]+yPointDiff*l/vectorThicc;

                    }

                }
            }
            ArrayList<Integer> pixelEdit = new ArrayList<>();
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < k; j++) {
                    for (int x = (int)(coords[j][0]-finalRadius); x <  (int)(coords[j][0]+finalRadius); x++) {
                        for (int y =(int)(coords[j][1]-finalRadius); y < (int)(coords[j][1]+finalRadius); y++) {
                            if ((Math.pow(coords[j][0] - x, 2) + Math.pow(coords[j][1] - y, 2) < Math.pow(finalRadius, 2)  && ImageWindow.WIDTH > x && x > 0 && y > 0 && y < ImageWindow.HEIGHT)) {
                                  pixels[x][y].setRGB(0, 0, 255);
                                  if (i<1){
                                      boolean duplicate = false;
                                      for (int l = 0; l < pixelEdit.size(); l+=2) {
                                          if (x == pixelEdit.get(l) && y == pixelEdit.get(l+1)){
                                              duplicate = true;
                                          }
                                      }
                                      if (!duplicate){
                                          pixelEdit.add(x);
                                          pixelEdit.add(y);
                                      }
                                  }


                            }
                        }
                    }
                    ArrayList<Integer> pixelDelete = new ArrayList<>();

                    for (int m = 0; m < circles; m++) {
                        for (int x = (int) (vectorCoords[j][m][0][0]-both[0][m])-1; x < (int) (vectorCoords[j][m][0][0]+both[0][m]+1); x++) {
                            for (int y = (int) (vectorCoords[j][m][0][1]-both[0][m])-1; y < (int) (vectorCoords[j][m][0][1]+both[0][m]+1); y++) {
                                if (Math.sqrt(Math.pow(vectorCoords[j][m][0][0]-x,2)+Math.pow(vectorCoords[j][m][0][1]-y,2))>both[0][m]-1 && Math.sqrt(Math.pow(vectorCoords[j][m][0][0]-x,2)+Math.pow(vectorCoords[j][m][0][1]-y,2)) <both[0][m] &&ImageWindow.WIDTH > x && x > 0 && y > 0 && y < ImageWindow.HEIGHT ){
                                    pixels[x][y].setRGB(0, 50, pixels[x][y].getB());
                                    pixelDelete.add(x);
                                    pixelDelete.add(y);
                                }

                            }
                        }
                        for (int l = 0; l < vectorThicc; l++) {
                            for (int x = (int)(vectorCoords[j][m][l][0] - 1); x < (int)(vectorCoords[j][m][l][0] +1); x++) {
                                for (int y = (int)(vectorCoords[j][m][l][1] - 1); y <(int)(vectorCoords[j][m][l][1] + 1) ; y++) {
                                    if (Math.pow(vectorCoords[j][m][l][0] - x, 2) + Math.pow(vectorCoords[j][m][l][1] - y, 2) < Math.pow(vectorRadius, 2)  && ImageWindow.WIDTH > x && x > 0 && y > 0 && y < ImageWindow.HEIGHT){
                                          pixels[x][y].setRGB(155, 0, pixels[x][y].getB());
                                        pixelDelete.add(x);
                                        pixelDelete.add(y);

                                    }
                                }
                            }
                        }
                    }
                    image.setPixels(pixels);
                    image.update();
                    for (int l = 0; l < pixelDelete.size(); l+=2) {
                        pixels[pixelDelete.get(l)][pixelDelete.get(l+1)].setRGB(0, 0, pixels[pixelDelete.get(l)][pixelDelete.get(l+1)].getB());

                    }
                    if (fade && j%((int)(k/200))==0){
                        for (int l = 0; l < pixelEdit.size(); l+=2) {
                                pixels[pixelEdit.get(l)][pixelEdit.get(l+1)].setRGB(0, 0, pixels[pixelEdit.get(l)][pixelEdit.get(l+1)].getB()-1);

                        }
                    }

                }
                for (int x = 0; x < image.WIDTH; x++) {
                    for (int y = 0; y < image.HEIGHT; y++) {
                        pixels[x][y].setRGB(0, 0, 0);
                    }
                }

            }
        }

    }
}