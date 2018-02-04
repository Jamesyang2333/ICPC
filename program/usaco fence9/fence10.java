/*
ID: jamesya4
LANG: JAVA
TASK: fence9
*/
import java.io.*;
import java.util.*;

class fence9 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("fence9.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fence9.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int topx = Integer.parseInt(st.nextToken());
        int topy = Integer.parseInt(st.nextToken());
        int rightx = Integer.parseInt(st.nextToken());
        int count = 0;
        point origin = new point(0, 0);
        point top = new point(topx, topy);
        point right = new point(rightx, 0);
        lineSeg leftEdge = new lineSeg(origin, top);
        lineSeg rightEdge = new lineSeg(top, right);
        for(int i = 1; i < topy; i++){
            int leftPoint = leftEdge.afterHorizon(i);
            int rightPoint = rightEdge.beforeHorizon(i);
            //System.out.println(i + " " + leftPoint + " " + rightPoint);
            if(leftPoint <= rightPoint){
                count += (rightPoint - leftPoint + 1);
            }
        }
        out.println(count);                           // output result
        out.close();                                  // close the output file
    }
}
class point{
    public double x;
    public double y;
    public point(double x, double y){
        this.x = x;
        this.y = y;
    }
}
class lineSeg{
    public double x1;
    public double x2;
    public double y1;
    public double y2;
    public lineSeg(point a, point b){
        x1 = a.x;
        x2 = b.x;
        y1 = a.y;
        y2 = b.y;
    }
    private double crossProduct(lineSeg a){
        return (x2 - x1) * (a.y2 - a.y1) - (y2 - y1) * (a.x2 - a.x1);
    }
    public int isPosCross(lineSeg a){
        double product = crossProduct(a);
        if(Math.abs(product) < 1e-7){
            return 0;
        }
        else if(product > 0)
            return 1;
        else return -1;
    }
    private double xHorizontalIntersect(int y){
        return (x1 + (y - y1) * (x2 - x1) / (y2 - y1));
    }
    public int afterHorizon(int y){
        double intersect = xHorizontalIntersect(y);
        int after = (int) intersect;
        if(Math.abs(after + 1 - intersect) < 1e-7)
            return after + 2;
        else return after + 1;
    }
    public int beforeHorizon(int y){
        double intersect = xHorizontalIntersect(y);
        int after = (int) intersect;
        if(Math.abs(after - intersect) < 1e-7)
            return after - 1;
        else return after;
    }
}