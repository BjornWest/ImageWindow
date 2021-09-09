import java.util.Arrays;
/*
public class ArcToCords {
    private static String Path;
    private static int number = 0;
    private static int arcAmount;
    public ArcToCords(){
        Path = arcPath;
    }
    public static Double[] extract(){
        String[] words = new String[Path.length()];
        Double[] stats = new Double[Path.length()];
        int times = Path.length();
        for (int i = 0; i <times; i++) {
            if (Path.contains(" ")){
                if (Path.indexOf(" ")<Path.indexOf(",") || !Path.contains(",")){
                    words[i] = Path.substring(0,Path.indexOf(" "));
                    Path = Path.substring(Path.indexOf(" ")+1);
                    number++;
                }
                else{
                    words[i] = Path.substring(0,Path.indexOf(","));
                    Path = Path.substring(Path.indexOf(",")+1);
                    number++;
                }
            }
        }
        for (int i = 0; i <number; i++) {
            if (words[i].contains("A")){
                words[i] = words[i].substring(words[i].indexOf("A")+1);
            }
            else if ( words[i].contains("M")){
                words[i] = words[i].substring(words[i].indexOf("M")+1);
            }
            stats[i] = Double.parseDouble(words[i]);
        }
        return stats;
    }
    public double[][] sort(Double[] stats){
        arcAmount = (number-2)/7;
        double[][] sorted = new double[7][arcAmount+1];
        sorted[5][0] = stats[0];
        sorted[6][0] = stats[1];

        for (int i = 0; i <arcAmount; i++) {
            sorted[0][i+1] = stats[7*i+2];
            sorted[1][i+1] = stats[7*i+3];
            sorted[2][i+1] = stats[7*i+4];
            sorted[3][i+1] = stats[7*i+5];
            sorted[4][i+1] = stats[7*i+6];
            sorted[5][i+1] = stats[7*i+7];
            sorted[6][i+1] = stats[7*i+8];

        }
        System.out.println(Arrays.toString(sorted[3]));

        return sorted;
    }
    public double[][] calcInfo(double rx, double ry, double rotation, boolean largeArc, boolean sweep, double x, double y, double currentX, double currentY){
        double interval = 1000;
        double[][] pointInTime = new double[(int)interval][2];
        for (int i = 0; i <interval; i++) {
                double xDiff = x-currentX;
                double yDiff = y-currentY;
                double arcRot = rotation/180*Math.PI;
                double diffAngle;
                Double m = null;
                if (xDiff>0){
                    diffAngle = Math.tan(yDiff/xDiff);
                }
                else if (xDiff<0){
                    diffAngle = Math.tan(yDiff/xDiff)+ Math.PI;
                }
                else{
                    if (yDiff>0){
                        diffAngle = Math.PI/2;
                    }
                    else if (yDiff<0){
                        diffAngle = Math.PI/2;
                    }
                    else{
                        diffAngle = 0;
                    }
                }
                double k = Math.tan(diffAngle+arcRot);
                double a = Math.abs(rx);
                double b = Math.abs(ry);
                double S = Math.sqrt(Math.pow(xDiff,2)+Math.pow(yDiff,2));
                double m1 = Math.sqrt(-(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2))*(Math.pow(a,2)*Math.pow(b,2)*(4*Math.pow(k,2)+4)-Math.pow(S,2)*(Math.pow(b,2)+Math.pow(a,2)*Math.pow(k,2)))/(Math.pow(k,2)*Math.pow(a,4)-Math.pow(a,2)*(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2))*(4*Math.pow(k,2)+4)));
                double m2 = -Math.sqrt(-(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2))*(Math.pow(a,2)*Math.pow(b,2)*(4*Math.pow(k,2)+4)-Math.pow(S,2)*(Math.pow(b,2)+Math.pow(a,2)*Math.pow(k,2)))/(Math.pow(k,2)*Math.pow(a,4)-Math.pow(a,2)*(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2))*(4*Math.pow(k,2)+4)));;

                if (){
                    m = m1;
                }
                else{
                    m = m2;
                }
                //means there is no real solution for the given rx and ry values, the elipse will be upscaled
                if (m.isNaN()){

                }
                double xIntersect1 = -m*k*Math.pow(a,2)/(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2))+Math.sqrt(Math.pow((m*k*Math.pow(a,2))/(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2)),2)-(Math.pow(m,2)*Math.pow(a,2)-Math.pow(a,2)*Math.pow(b,2))/(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2)));
                double xIntersect2 =-m*k*Math.pow(a,2)/(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2))-Math.sqrt(Math.pow((m*k*Math.pow(a,2))/(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2)),2)-(Math.pow(m,2)*Math.pow(a,2)-Math.pow(a,2)*Math.pow(b,2))/(Math.pow(b,2)+Math.pow(k,2)*Math.pow(a,2)));
                double yIntersect1 = xIntersect1 * k + m;
                double yIntersect2 = xIntersect2 * k + m;

                if ((!largeArc && xIntersect2 > 0 && yIntersect1<yIntersect2) || (largeArc && xIntersect1<0 && yIntersect1<yIntersect2)){
                    xStart = xIntersect1;
                    xFinish = xIntersect2;
                    yStart = yIntersect1;
                    yFinish = yIntersect2;
                }
                else {
                    xStart = xIntersect2;
                    xFinish = xIntersect1;
                    yStart = yIntersect2;
                    yFinish = yIntersect1;
                }
                pointInTime[j][0] = a*Math.cos((j-i*interval/arcAmount)*2*Math.PI/interval+ ) * Math.cos(arcRot) - b*Math.sin() * Math.sin(arcRot);
                pointInTime[j][1] = b*Math.sin() * Math.cos(arcRot) + a*Math.cos((j-i*interval/arcAmount)*2*Math.PI/interval INTE FÄRDIG ) * Math.sin(arcRot);
            }

        /*



        return pointInTime;
    }

    public static void main(String[] args) {
        ArcToCords arc = new ArcToCords("M55 40 A7,10 0 0,0 45,100 A22,22 0 0,0 65,42 A1000,1000 0 0,1 40,25 A10,8 0 0,1 50,16 A30,30 0 0,1 65,23 A1,1 0 0,0 70,15 A50,50 0 0,0 40,12 A10,10 0 0,0 38,30 A70,100 0 0,1 70,58 A25,23 0 0,1 50,95 A35,33 0 0,1 55,40 ");
        arc.sort(extract());
        String hehe = "5";
        System.out.println(Integer.valueOf(hehe));
    }
}
/*
M55 40 A7,10 0 0,0 45,100 A22,22 0 1,0 65,42 A1000,1000 0 0,1 40,25 A10,8 0 0,1 50,16 A30,30 0 0,1 65,23 A1,1 0 0,0 70,15 A50,50 0 0,0 40,12 A10,10 0, 0,0 38,30 A70,100 0 0,1 70,58 A25,23 0 0,1 50,95 A35,33 0 0,1 55,40
 */