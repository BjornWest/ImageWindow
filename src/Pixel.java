/**
 *   Pixel: a simple class for holding and manipulating pixel rgb values
 *   @author Gabriel Skoglund
 *   @version 2020-10-08
 */

public class Pixel{

    private int r, g, b;

    public Pixel(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Pixel(int argb){
        r = (argb >> 16) & 255;
        g = (argb >> 8) & 255;
        b = argb & 255;
    }

    public int getR(){
        return r;
    }

    public int getG(){
        return g;
    }

    public int getB(){
        return b;
    }

    public void setR(int r){
        this.r = r;
    }

    public void setG(int g){
        this.g = g;
    }

    public void setB(int b){
        this.b = b;
    }

    public void setRGB(int r, int g, int b){
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void setRGB(double r, double g, double b){
        this.r = (int) r;
        this.g = (int) g;
        this.b = (int) b;
    }

    /**
     *   Join the r,g,b fields to create an ARGB pixel value
     *   without transparency;
     */
    public int toARGB(){
        return (255 << 24) | (r & 255) << 16 | (g & 255) << 8 | (b & 255);
    }

    /**
     *   Return a string representation of this pixel
     */
    @Override
    public String toString(){
        return "Pixel{" + r +", " + g + ", " + b +"}";
    }
}