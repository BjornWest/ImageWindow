public class Pen {
    public static void main(String[] args) {
        ImageWindow image = new ImageWindow();
        Pixel[][] pixels = image.getPixels();
        double interval = 1000;
        double[][] pointInTime = new double[(int)interval][3];
        for (int i = 0; i < interval; i++) {
            pointInTime[i][0] = i / interval;
            int parts = 9;
            double v = Math.PI/4;
            pointInTime[i][1] = 10+2*Math.cos(2*i*Math.PI/interval)*Math.cos(v)-Math.sin(2*i*Math.PI/interval)*Math.sin(v);
            pointInTime[i][2] = 10+Math.sin(2*i*Math.PI/interval)*Math.cos(v)+2*Math.cos(2*i*Math.PI/interval)*Math.sin(v);

        }
        for (int i = 0; i <interval; i++) {
            for (int x = (int)(pointInTime[i][1]*30)-1; x <(int)(pointInTime[i][1]*30)+1; x++) {
                for (int y =(int)(pointInTime[i][2]*30)-1 ; y <(int)(pointInTime[i][2]*30)+1 ; y++) {
                    pixels[x][y].setRGB(0,0,255);
                    System.out.println(i);
                }
            }
            image.setPixels(pixels);
            image.update();
        }
    }
}
