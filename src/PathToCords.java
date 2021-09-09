import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathToCords {
    private static int currentPoly = 0;
    private static int frames;
    private static int currentFrame = 0;
    private static double currentXPos = 0;
    private static double currentYPos = 0;
    private double totalpace = 100;
    private double lastControlX = 0;
    private double lastControlY = 0;
    ArrayList<Double> coords = new ArrayList<>();

    public PathToCords(int framesAmount){
        frames=framesAmount;
    }
    public double[][] getCords(String path){

        ArrayList<Integer> partSizes = new ArrayList<Integer>();
        int currentNumber = 0;

        ArrayList<String> pathArray = pathExtract(path);
        int size = 0;
        int sizeSum = 0;
        for (int i = 0; i <pathArray.size(); i++) {

            if (pathArray.get(i).toLowerCase().equals("m") || pathArray.get(i).toLowerCase().equals("t") ||pathArray.get(i).toLowerCase().equals("s") || pathArray.get(i).toLowerCase().equals("l") || pathArray.get(i).toLowerCase().equals("h") || pathArray.get(i).toLowerCase().equals("v")  ||
                    pathArray.get(i).toLowerCase().equals("c") || pathArray.get(i).toLowerCase().equals("q") || pathArray.get(i).toLowerCase().equals("a")){
                if (size>0){
                    partSizes.add(size);
                }

                size = 0;
            }
            else {
                size++;
            }

        }
        partSizes.add(size);

        for (int i = 0; i < pathArray.size(); i++) {
            if (pathArray.get(i).equals("M")){
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+1+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                currentXPos = Double.parseDouble(parts.get(0));
                currentYPos = Double.parseDouble(parts.get(1));

                if (parts.size()>2){
                    ArrayList<Double> values = new ArrayList<>();
                    for (int j = 0; j < parts.size()-2; j++) {
                        values.add(Double.parseDouble(parts.get(j+2)));
                    }
                    lLine(false,values);
                }
            }
            if (pathArray.get(i).equals("m")){
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+1+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                currentXPos = currentXPos+Double.parseDouble(parts.get(0));
                currentYPos = currentYPos+Double.parseDouble(parts.get(1));
                if (parts.size()>2){
                    ArrayList<Double> values = new ArrayList<>();
                    for (int j = 0; j < parts.size()-2; j++) {
                        values.add(Double.parseDouble(parts.get(j+2)));
                    }
                    lLine(true,values);
                }
            }
            if (pathArray.get(i).equals("L")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                lLine(false,values);
            }
            if (pathArray.get(i).equals("l")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+1+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                lLine(true,values);
            }
            if (pathArray.get(i).equals("H")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j+1));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                hLine(false,values);
            }
            if (pathArray.get(i).equals("h")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j+1));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
               hLine(true,values);
            }
            if (pathArray.get(i).equals("V")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                vLine(false,values);
            }
            if (pathArray.get(i).equals("v")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                vLine(true,values);
            }
            if (pathArray.get(i).equals("C")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j+1));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                cCurve(false,values);
            }
            if (pathArray.get(i).equals("c")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j+1));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                cCurve(true,values);
            }
            if (pathArray.get(i).equals("S")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;

                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                sCurve(false,values);
            }
            if (pathArray.get(i).equals("s")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j+1));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                sCurve(true,values);
            }
            if (pathArray.get(i).equals("Q")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                qCurve(false,values);
            }
            if (pathArray.get(i).equals("q")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (int j = 0; j < parts.size(); j++) {
                    values.add(Double.parseDouble(parts.get(j)));
                }
                qCurve(true,values);
            }
            if (pathArray.get(i).equals("T")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (String part : parts) {
                    values.add(Double.parseDouble(part));
                }
                tCurve(false,values);
            }
            if (pathArray.get(i).equals("t")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (String part : parts) {
                    values.add(Double.parseDouble(part));
                }
                tCurve(true,values);
            }
            if (pathArray.get(i).equals("A")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (String part : parts) {
                    values.add(Double.parseDouble(part));
                }
                arc(false,values);
            }
            if (pathArray.get(i).equals("a")){
                ArrayList<Double> values = new ArrayList<>();
                ArrayList<String> parts = new ArrayList<>();
                for (int j = 0; j < partSizes.get(currentNumber); j++) {
                    parts.add(pathArray.get(sizeSum+j));
                }
                sizeSum = sizeSum+partSizes.get(currentNumber)+1;
                currentNumber++;
                for (String part : parts) {
                    values.add(Double.parseDouble(part));
                }
                arc(true,values);
            }

        }
        double[][] coordsFinal = new double[2][coords.size()/2];
        double[] dimensions;

        for (int j = 0; j < coords.size()/2; j++) {
            coordsFinal[0][j] = coords.get(j*2);
            coordsFinal[1][j] = coords.get(j*2+1);
        }
        dimensions = dimCalc(coordsFinal[0],coordsFinal[1]);

        for (int i = 0; i < coordsFinal[0].length; i++) {
            coordsFinal[0][i] = ((coordsFinal[0][i]-dimensions[0])/(dimensions[4]));
            coordsFinal[1][i] = (1-(coordsFinal[1][i]-dimensions[2])/(dimensions[4]));
        }
        int localInterval = (int) Image.interval;
        double[][] coordsFinalReturn = new double[localInterval][2];
        for (int i = 0; i < localInterval; i++) {
            coordsFinalReturn[i][0] = coordsFinal[0][i*coordsFinal[0].length/localInterval];
            coordsFinalReturn[i][1] = coordsFinal[1][i*coordsFinal[0].length/localInterval];
        }

        return coordsFinalReturn;
    }
    public ArrayList<String> pathExtract(String path){
        ArrayList<String> pathArray = new ArrayList<>();
        if (!path.substring(0,1).toLowerCase().equals("m")){
            path = path.substring(1);
        }
        path = ","+path;
        for (int i = 0; i < path.length(); i++) {
            if ((path.substring(i, i+1).toLowerCase().equals("e"))){
                 while (!path.substring(i, i+1).toLowerCase().equals(",") && !(path.substring(i, i+1).toLowerCase().equals(" "))){
                    i++;
                 }
            }
            if ((path.substring(i, i+1).toLowerCase().equals("z"))){
                path = path.substring(0,i)+path.substring(i+1);
            }
            if (!(i+1==path.length())){


            if ((path.substring(i, i+1).toLowerCase().equals("t") || path.substring(i, i+1).toLowerCase().equals("s") || path.substring(i, i+1).toLowerCase().equals("l") || path.substring(i, i+1).toLowerCase().equals("h") || path.substring(i, i+1).toLowerCase().equals("v")  || path.substring(i,i+1).equals("-") ||
                    path.substring(i, i+1).toLowerCase().equals("c") || path.substring(i, i+1).toLowerCase().equals("q") || path.substring(i, i+1).toLowerCase().equals("a") || path.substring(i, i+1).toLowerCase().equals("m")))  {
                if ((!(path.substring(i+1,i+2).equals(",") || path.substring(i+1,i+2).equals(" "))) && !path.substring(i,i+1).equals("-")){
                    path = path.substring(0,i+1)+","+path.substring(i+1);
                }
                if (!(path.substring(i-1,i).equals(",") || path.substring(i-1,i).equals(" "))){
                    path= path.substring(0,i)+","+path.substring(i);
                    i++;
                }
            }
            }
        }
        for (int i = 0; i <path.length();) {
            if (path.substring(i,i+1).equals(" ") || path.substring(i,i+1).equals(",")){
                int length = 0;
                i++;
                while (!(path.substring(i,i+1).equals(" ") || path.substring(i, i+1).equals(","))){
                    length++;
                    i++;
                    if (i==path.length()){
                        break;
                    }
                }
                if (length > 0){
                    pathArray.add(path.substring(i-length,i));
                }
            }
        }
        return pathArray;
    }

    public double[] dimCalc(double[] coordsX, double[] coordsY){
        double[] dims = new double[5];
        double min = 99999999;
        double max = 0;
        for (Double xPos : coordsX){
            if (min > xPos ){
                min = xPos;
            }
            if (max < xPos){
                max = xPos;
            }
            dims[0] = min;
            dims[1] = max;

        }
        min = 99999999;
        max = 0;
        for (Double yPos : coordsY){
            if (min > yPos ){
                min = yPos;
            }
            if (max < yPos){
                max = yPos;
            }
            dims[2] = min;
            dims[3] = max;
        }
        dims[4] = Math.max(dims[1] - dims[0], dims[3] - dims[2]);
        return dims;
    }

    public void lLine(boolean lowerCase, ArrayList<Double> values){
       double targetX;
       double targetY;
        if (lowerCase){
            targetX = currentXPos+values.get(currentPoly);
            targetY = currentYPos+values.get(1+currentPoly);
        }
        else {
            targetX = values.get(currentPoly);
            targetY = values.get(1+currentPoly);
        }
        int realPartFrames = (int) (frames*Math.sqrt(Math.pow(targetX-currentXPos,2)+Math.pow(targetY-currentYPos,2))/totalpace);
        double[][] partCoords = new double[(realPartFrames)][2];
        double xPosdiff = targetX - currentXPos;
        double yPosdiff = targetY - currentYPos;
        for (int i = 0; i < realPartFrames; i++) {
            partCoords[i][0] = currentXPos+xPosdiff*i/realPartFrames;
            partCoords[i][1] = currentYPos+yPosdiff*i/realPartFrames;
        }

        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        currentYPos = targetY;
        if (values.size()>currentPoly+2){
            currentPoly+=2;
            lLine(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
    }
    public void hLine(boolean lowerCase, ArrayList<Double> values){
        double targetX;
        if (lowerCase){
            targetX = currentXPos+values.get(currentPoly);
        }
        else {
            targetX = values.get(currentPoly);
        }
        int realPartFrames = (int) (frames*(Math.abs(targetX-currentXPos))/totalpace);
        double[][] partCoords = new double[(realPartFrames)][2];
        double xPosdiff = targetX - currentXPos;
        for (int i = 0; i < realPartFrames; i++) {
            partCoords[i][0] = currentXPos+xPosdiff*i/realPartFrames;
            partCoords[i][1] = currentYPos;
        }

        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        if (values.size() > currentPoly+1){
            currentPoly++;
            hLine(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
    }
    public void vLine(boolean lowerCase, ArrayList<Double> values){

        double targetY;
        if (lowerCase){
            targetY = currentYPos+values.get(currentPoly);
        }
        else {
            targetY = values.get(currentPoly);
        }
        int realPartFrames = (int) (frames*(Math.abs(targetY-currentYPos))/totalpace);
        double[][] partCoords = new double[(realPartFrames)][2];
        double yPosdiff = targetY - currentYPos;
        for (int i = 0; i < realPartFrames; i++) {
            partCoords[i][0] = currentXPos;
            partCoords[i][1] = currentYPos+yPosdiff*i/realPartFrames;
        }

        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentYPos = targetY;
        if (values.size() > currentPoly+1){
            currentPoly++;
            vLine(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
    }
    public void cCurve(boolean lowerCase, ArrayList<Double> values){
        double targetX;
        double targetY;
        double control1X;
        double control1Y;
        double control2X;
        double control2Y;
        if (lowerCase){
            targetX = currentXPos+values.get(4+currentPoly);
            targetY = currentYPos+values.get(5+currentPoly);
            control1X = currentXPos+values.get(currentPoly);
            control1Y = currentYPos+values.get(1+currentPoly);
            control2X = currentXPos+values.get(2+currentPoly);
            control2Y = currentYPos+values.get(3+currentPoly);
        }
        else {
            targetX = values.get(4+currentPoly);
            targetY = values.get(5+currentPoly);
            control1X = values.get(currentPoly);
            control1Y = values.get(1+currentPoly);
            control2X = values.get(2+currentPoly);
            control2Y = values.get(3+currentPoly);
        }
        int realPartFrames = (int) (frames*Math.sqrt(Math.pow(targetX-currentXPos,2)+Math.pow(targetY-currentYPos,2))/totalpace);
        double[][] partCoords = new double[realPartFrames][2];
        double diff1x = control1X - currentXPos;
        double diff2x = control2X - control1X;
        double diff3x = targetX - control2X;
        double diff1y = control1Y - currentYPos;
        double diff2y = control2Y - control1Y;
        double diff3y = targetY - control2Y;

        for (int i = 0; i < realPartFrames; i++) {
            double p1x = currentXPos + diff1x*i/realPartFrames;
            double p2x = control1X + diff2x*i/realPartFrames;
            double p3x = control2X + diff3x*i/realPartFrames;
            double p1y = currentYPos + diff1y*i/realPartFrames;
            double p2y = control1Y + diff2y*i/realPartFrames;
            double p3y = control2Y + diff3y*i/realPartFrames;

            double diff4x = p2x - p1x;
            double diff5x = p3x - p2x;
            double diff4y = p2y - p1y;
            double diff5y = p3y - p2y;

            double p4x = p1x + diff4x*i/realPartFrames;
            double p5x = p2x + diff5x*i/realPartFrames;
            double p4y = p1y + diff4y*i/realPartFrames;
            double p5y = p2y + diff5y*i/realPartFrames;
            double diff6x = p5x -p4x;
            double diff6y = p5y -p4y;
            double p6x = p4x + diff6x*i/realPartFrames;
            double p6y = p4y + diff6y*i/realPartFrames;
            partCoords[i][0] = p6x;
            partCoords[i][1] = p6y;
        }
        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        currentYPos = targetY;
        if (values.size()>currentPoly+6){
            currentPoly+=6;
            cCurve(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
        lastControlX = control2X;
        lastControlY = control2Y;
    }
    public void sCurve(boolean lowerCase, ArrayList<Double> values){
        double targetX;
        double targetY;
        double control1X = lastControlX+(currentXPos-lastControlX)*2;
        double control1Y = lastControlY+(currentYPos-lastControlY)*2;
        double control2X;
        double control2Y;
        if (lowerCase){
            targetX = currentXPos+values.get(2+currentPoly);
            targetY = currentYPos+values.get(3+currentPoly);
            control2X = currentXPos+values.get(currentPoly);
            control2Y = currentYPos+values.get(1+currentPoly);
        }
        else {
            targetX = values.get(2+currentPoly);
            targetY = values.get(3+currentPoly);
            control2X = values.get(currentPoly);
            control2Y = values.get(1+currentPoly);
        }
        int realPartFrames = (int) (frames*Math.sqrt(Math.pow(targetX-currentXPos,2)+Math.pow(targetY-currentYPos,2))/totalpace);
        double[][] partCoords = new double[realPartFrames][2];
        double diff1x = control1X - currentXPos;
        double diff2x = control2X - control1X;
        double diff3x = targetX - control2X;
        double diff1y = control1Y - currentYPos;
        double diff2y = control2Y - control1Y;
        double diff3y = targetY - control2Y;

        for (int i = 0; i < realPartFrames; i++) {
            double p1x = currentXPos + diff1x*i/realPartFrames;
            double p2x = control1X + diff2x*i/realPartFrames;
            double p3x = control2X + diff3x*i/realPartFrames;
            double p1y = currentYPos + diff1y*i/realPartFrames;
            double p2y = control1Y + diff2y*i/realPartFrames;
            double p3y = control2Y + diff3y*i/realPartFrames;

            double diff4x = p2x - p1x;
            double diff5x = p3x - p2x;
            double diff4y = p2y - p1y;
            double diff5y = p3y - p1y;

            double p4x = p1x + diff4x*i/realPartFrames;
            double p5x = p2x + diff5x*i/realPartFrames;
            double p4y = p1y+ diff4y*i/realPartFrames;
            double p5y = p2y + diff5y*i/realPartFrames;
            double diff6x = p5x -p4x;
            double diff6y = p5y -p5y;
            double p6x = p4x + diff6x*i/realPartFrames;
            double p6y = p4y + diff6y*i/realPartFrames;
            partCoords[i][0] = p6x;
            partCoords[i][1] = p6y;
        }
        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        currentYPos = targetY;
        lastControlX = control2X;
        lastControlY = control2Y;
        if (values.size()>currentPoly+4){
            currentPoly+=4;
            sCurve(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
    }
    public void qCurve(boolean lowerCase,ArrayList<Double> values){

        double targetX;
        double targetY;
        double controlX;
        double controlY;
        if (lowerCase){
            targetX = currentXPos+values.get(2+currentPoly);
            targetY = currentYPos+values.get(3+currentPoly);
            controlX = currentXPos+values.get(currentPoly);
            controlY = currentYPos+values.get(1+currentPoly);
        }
        else {
            targetX = values.get(2+currentPoly);
            targetY = values.get(3+currentPoly);
            controlX = values.get(currentPoly);
            controlY = values.get(1+currentPoly);
        }
        int realPartFrames = (int) (frames*Math.sqrt(Math.pow(targetX-currentXPos,2)+Math.pow(targetY-currentYPos,2))/totalpace);
        double[][] partCoords = new double[realPartFrames][2];
        double diff1x = controlX - currentXPos;
        double diff2x = targetX - controlX;
        double diff1y = controlY - currentYPos;
        double diff2y = targetY - controlY;
        for (int i = 0; i < realPartFrames; i++) {
            double p1x = currentXPos+diff1x*i/realPartFrames;
            double p2x = controlX + diff2x*i/realPartFrames;
            double p1y = currentYPos+diff1y*i/realPartFrames;
            double p2y = currentYPos+diff2y*i/realPartFrames;
            double diff3x = p2x-p1x;
            double diff3y = p2y-p1y;
            double p3x = p1x + diff3x*i/realPartFrames;
            double p3y = p1y + diff3y*i/realPartFrames;
            partCoords[i][0] = p3x;
            partCoords[i][1] = p3y;
        }

        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        currentYPos = targetY;
        if (values.size()>currentPoly+4){
            currentPoly+=4;
            qCurve(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
        lastControlX = controlX;
        lastControlY = controlY;
    }
    public void tCurve(boolean lowerCase,ArrayList<Double> values){

        double targetX;
        double targetY;
        double controlX = lastControlX - (currentXPos - lastControlX)*2;
        double controlY = lastControlY - (currentYPos - lastControlY)*2;
        if (lowerCase){
            targetX = currentXPos+values.get(currentPoly);
            targetY = currentYPos+values.get(1+currentPoly);
        }
        else {
            targetX = values.get(currentPoly);
            targetY = values.get(1+currentPoly);
        }
        int realPartFrames = (int) (frames*Math.sqrt(Math.pow(targetX-currentXPos,2)+Math.pow(targetY-currentYPos,2))/totalpace);
        double[][] partCoords = new double[realPartFrames][2];
        double diff1x = controlX - currentXPos;
        double diff2x = targetX - controlX;
        double diff1y = controlY - currentYPos;
        double diff2y = targetY - controlY;
        for (int i = 0; i < realPartFrames; i++) {
            double p1x = currentXPos+diff1x*i/realPartFrames;
            double p2x = controlX + diff2x*i/realPartFrames;
            double p1y = currentYPos+diff1y*i/realPartFrames;
            double p2y = currentYPos+diff2y*i/realPartFrames;
            double diff3x = p2x-p1x;
            double diff3y = p2y-p1y;
            double p3x = p1x + diff3x*i/realPartFrames;
            double p3y = p1y + diff3y*i/realPartFrames;
            partCoords[i][0] = p3x;
            partCoords[i][1] = p3y;
        }

        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        currentYPos = targetY;
        lastControlX = controlX;
        lastControlY = controlY;
        if (values.size()>currentPoly+2){
            currentPoly+=2;
            tCurve(lowerCase,values);
        }
        else {
            currentPoly = 0;
        }
    }
    public void arc(boolean lowerCase, ArrayList<Double> values){
        if (values.get(currentPoly) == 0 || values.get(currentPoly+1) == 0){
            ArrayList<Double> line = new ArrayList<>();
            line.add(values.get(currentPoly+5));
            line.add(values.get(currentPoly+6));
            lLine(lowerCase, line);
        }
        double targetX;
        double targetY;

        if (lowerCase){
            targetX = currentXPos+values.get(currentPoly+5);
            targetY = currentYPos+values.get(currentPoly+6);
        }
        else {
            targetX = values.get(currentPoly+5);
            targetY = values.get(currentPoly+6);
        }
        int realPartFrames = (int) (frames*Math.sqrt(Math.pow(targetX-currentXPos,2)+Math.pow(targetY-currentYPos,2))/totalpace);
        double[][] partCoords = new double[realPartFrames][2];

        //   ArcToCords yoink = new ArcToCords()

        for (int i = 0; i < realPartFrames; i++) {

        }
        for (int i = 0; i < (realPartFrames); i++) {
            coords.add(partCoords[i][0]);
            coords.add(partCoords[i][1]);
        }
        currentFrame+=realPartFrames;
        currentXPos = targetX;
        currentYPos = targetY;
    }

    public static void main(String[] args) {
        PathToCords haha = new PathToCords(1000);

  /*       for (int i = 0; i < yo.length; i++) {

        } */
    }

}
