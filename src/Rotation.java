public class Rotation {
    public Rotation(){
    }
        public double[][] multiAxis(double[] radius, double[] startingA, int number, double[] rotations){
            double[] p = new double[2];
            double[] a = startingA;
            double[][] allPoints = new double[number+1][2];
            for (int i = 0; i <number; i++) {
                p[0] = a[0]+ radius[i]*Math.cos(rotations[i]);
                p[1] = a[1]+ radius[i]*Math.sin(rotations[i]);
                a = p;
                allPoints[i][0] = a[0];
                allPoints[i][1] = a[1];
            }
            allPoints[number][0] = a[0];
            allPoints[number][1] = a[1];
            return allPoints;

        }
        public double[] rotation(double xPosition, double yPosition, double rotation, double xAxis, double yAxis){
            double[] newcoords = new double[2];
            double xDistance = xPosition-xAxis;
            double yDistance = yPosition-yAxis;
            double distance = Math.sqrt(xDistance*xDistance+yDistance*yDistance);
            if (xDistance>0){
                double v = Math.atan(yDistance/xDistance);
                double r = v+rotation;
            newcoords[0] = xAxis + Math.cos(r)*distance;
            newcoords[1] = yAxis + Math.sin(r)*distance;
            }
            else if(xDistance<0) {
            double v = Math.atan(yDistance/xDistance)+Math.PI;
            double r = v+rotation;
            newcoords[0] = xAxis + Math.cos(r)*distance;
            newcoords[1] = yAxis + Math.sin(r)*distance;
            }
            else{
                if (yDistance>0){
                    double v = Math.PI/2;
                    double r = v+rotation;
                    newcoords[0] = xAxis - Math.cos(r)*distance;
                    newcoords[1] = yAxis - Math.sin(r)*distance;
                }
                else if (yDistance<0){
                    double v = Math.PI*3/2;
                    double r = v+rotation;
                    newcoords[0] = xAxis - Math.cos(r)*distance;
                    newcoords[1] = yAxis - Math.sin(r)*distance;
                }
                else{
                    newcoords[0] = xAxis;
                    newcoords[1] = yAxis;
                }

            }
        return newcoords;

    }
}

