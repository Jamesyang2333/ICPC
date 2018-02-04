/*
ID: jamesya4
LANG: JAVA
TASK: spin
*/
import java.io.*;
import java.util.*;

class spin {
    private static int[] speed = new int[5];
    private static wedge[][] wedges;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("spin.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("spin.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st;
        // Get line, break into tokens
        wedges = new wedge[5][];

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(f.readLine());
            speed[i] = Integer.parseInt(st.nextToken());
            wedges[i] = new wedge[Integer.parseInt(st.nextToken())];
            for(int j = 0; j < wedges[i].length; j++){
                int start = Integer.parseInt(st.nextToken());
                int extend = Integer.parseInt(st.nextToken());
                wedges[i][j] = new wedge(start, extend);
            }
        }
        boolean can = false;
        int result = 0;
        if(check()){
            can = true;
        }
        else{
            for(int i = 1; i <= 359; i++){
                update();
                if(check()){
                    result = i;
                can = true;
                break;}
            }
        }


        if(can)
            out.println(result);                           // output result
        else out.println("none");
        out.close();                                  // close the output file
    }
    private static void update(){
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < wedges[i].length; j++){
                wedges[i][j].start = (wedges[i][j].start + speed[i]) % 360;
            }
        }
    }
    private static boolean check(){
        boolean result = false;
        for(int i = 0; i < 360; i++){
            boolean pass = true;
            for(int j = 0; j < 5; j++){
                if(!contain(j, i)){
                    pass = false;
                    break;
                }
            }
            if(pass){
                result = true;
                break;
            }
        }
        return result;
    }
    private static boolean contain(int i,  int n){
        for(int j = 0; j < wedges[i].length; j++){
            if(wedges[i][j].start + wedges[i][j].extend < 360){
                if((n >= wedges[i][j].start) && (n <= wedges[i][j].start + wedges[i][j].extend))
                    return true;
            }
            else{
                if((n >= wedges[i][j].start) || (n <= ((wedges[i][j].start + wedges[i][j].extend) % 360)))
                    return true;
            }
        }
        return false;
    }
}
class wedge{
    int start;
    int extend;
    public wedge(int start, int extend){
        this.start = start;
        this.extend = extend;
    }
}