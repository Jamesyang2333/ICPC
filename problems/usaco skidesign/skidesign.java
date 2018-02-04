/*
ID: jamesya4
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
import java.util.*;

class skidesign {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] elevation = new int[n];
        int min;
        if(n == 1)
            min = 0;
        else {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(f.readLine());
                elevation[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(elevation);
            if(elevation[n - 1] - elevation[0] <= 17)
                min = 0;
            else{
                int cost = 0;
                min = 10000000;
                for(int i = elevation[0]; i <= elevation[n-1] - 17; i++){
                    for(int j = 0; j < n; j++){
                        if(elevation[j] < i){
                            cost += (i - elevation[j]) * (i - elevation[j]);
                        }
                        else break;
                    }
                    for(int j = n-1; j >= 0; j--){
                        if(elevation[j] > i + 17){
                            cost += (i + 17 - elevation[j]) * (i + 17 - elevation[j]);
                        }
                        else break;
                    }
                    if(cost < min)
                        min = cost;
                    cost = 0;
                }
            }

        }
        out.println(min);                           // output result
        out.close();                                  // close the output file
    }
}
