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
        int leftx = Integer.parseInt(st.nextToken());
        int count = 0;
        point origin = new point(0, 0);
        point inner = new point(1,0.000001);
        point top = new point(topx, topy);
        point left = new point(leftx, 0);
        lineSeg innerToOrigin = new lineSeg(inner,origin);
        lineSeg innerToTop = new lineSeg(inner, top);
        lineSeg innerToLeft = new lineSeg(inner, left);
        int innerLeft = innerToTop.isPosCross(innerToLeft);
        int innerRight = innerToTop.isPosCross(innerToOrigin);
        for(int i = 0; i < Math.max(topx, leftx); i++){
            for(int j = 1; j < topy; j++){
                point current = new point(i, j);
                lineSeg currentToOrigin = new lineSeg(current,origin);
                lineSeg currentToTop = new lineSeg(current, top);
                lineSeg currentToLeft = new lineSeg(current, left);
                if(innerLeft * currentToTop.isPosCross(currentToLeft) > 0 && innerRight  * currentToTop.isPosCross(currentToOrigin) > 0)
                    count++;
                //System.out.println(i + " " + j + " " + count);
            }
        }
        out.println(count);                           // output result
        out.close();                                  // close the output file
    }
}
