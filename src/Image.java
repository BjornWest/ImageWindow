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
            }
            else{
                pointInTime[i][0] = 0.75;
            }
            pointInTime[i][1] = 0.5;
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
        for (int a = 0; a< n; a++) {
            xTotal = 0;
            yTotal = 0;
            double nRotate;
            if (a%2==1){
                nRotate=(a+1)/2;
            }
            else {
                nRotate=-a/2;
            }
            for (int i = 0; i <interval; i++) {

                xTotal = xTotal+rotator.rotation(pointInTime[i][0],pointInTime[i][1],nRotate*(i)/interval*2*Math.PI,xAxis,yAxis)[0]/interval;
                yTotal = yTotal+rotator.rotation(pointInTime[i][0],pointInTime[i][1],nRotate*(i)/interval*2*Math.PI,xAxis,yAxis)[1]/interval;
            }

            integrals[a][0] = xTotal;
            integrals[a][1] = yTotal;
        }
        return integrals;
    }


}

