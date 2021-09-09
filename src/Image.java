import java.util.Arrays;


public class Image {
    public static double interval = 2000;


    public Image(){
    }


    public double[][] information() {
        double[][] pointInTime = new double[(int) interval][3];
        double xScale = 1;
        double yScale = 1;
        for (int i = 0; i < interval; i++) {
            if (i<interval/2){
                pointInTime[i][0] = 0.25;
                pointInTime[i][1] = 0.5;
            }
            else{
                pointInTime[i][0] = 0.75;
                pointInTime[i][1] = 0.5;
            }










            /*
 else if (i<*interval/parts){
                pointInTime[i][1] = -*(i-*interval/parts)/(interval/parts);
                pointInTime[i][2] = -*(i-*interval/parts)/(interval/parts);
            } */
        }
        for (int j = 0; j < interval; j++) {
            pointInTime[j][0] = pointInTime[j][0]*xScale;
            pointInTime[j][1] = pointInTime[j][1]*yScale;
        }

        return pointInTime;
    }
    public double[][] integrals(double[][] information, double xAxis, double yAxis, int circles){
        Rotation rotator = new Rotation();
        int n = circles;
        double[][] integrals = new double[n][2];
        double[][] pointInTime = information;
        double xTotal;
        double yTotal;
        int roundx;
        int roundy;
        for (int a = 0; a< n; a++) {
            xTotal = 0;
            yTotal = 0;
            double nRotate;
            if (a%2==1){
                nRotate=(a)/2;
            }
            else {
                nRotate=-a/2;
            }
            for (int i = 0; i <interval; i++) {

                xTotal = xTotal+rotator.rotation(pointInTime[i][0],pointInTime[i][1],nRotate*(i)/interval*2*Math.PI,xAxis,yAxis)[0]/interval;
                yTotal = yTotal+rotator.rotation(pointInTime[i][0],pointInTime[i][1],nRotate*(i)/interval*2*Math.PI,xAxis,yAxis)[1]/interval;
             //   System.out.println(a+" +"+rotator.rotation(pointInTime[i][1],pointInTime[i][2],nRotate*i/interval*2*Math.PI,xAxis,yAxis)[1]/interval);
             //   System.out.println(a+" "+i+"  "+yTotal);
             //   System.out.println(a+" "+i+"   "+xTotal);


            }

            integrals[a][0] = xTotal;
            integrals[a][1] = yTotal;
           // System.out.println(a+":  "+yTotal);
        }
        return integrals;
    }


}
