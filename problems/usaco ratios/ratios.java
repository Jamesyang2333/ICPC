/*
ID: jamesya4
LANG: JAVA
TASK: ratios
*/
import java.io.*;
import java.util.*;

class ratios {
    private static int[] realgoal;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ratios.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int[] goal = new int[3];
        for(int i = 0; i < 3; i++){
            goal[i] = Integer.parseInt(st.nextToken());
        }
        realgoal = new int[3];
        int goalGcd = trigcd(goal[0], goal[1], goal[2]);
        for(int i = 0; i < 3; i++)
            realgoal[i] = goal[i] / goalGcd;
        int[][] mixtures = new int[3][3];
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(f.readLine());
            for(int j = 0; j < 3; j++)
                mixtures[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] combination = new int[3];
        int min = 300;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++)
                for(int k = 0; k < 100; k++){
                    if(i == 0 && j == 0 && k == 0)
                        continue;
                    int[] mix = new int[3];
                    for(int l = 0; l <= 2; l++)
                        mix[l] = i * mixtures[0][l] + j * mixtures[1][l] + k * mixtures[2][l];
                        if(check(mix) && mix[0] >= goal[0]){
                            if(i + j + k < min){
                                min = i + j + k;
                                combination[0] = i;
                                combination[1] = j;
                                combination[2] = k;
                            }
                        }


                }
        }
        //System.out.println(trigcd(21, 28, 35));
        if(min == 300)
        out.println("NONE");                           // output result
        else{
            int muliple = (combination[0] * mixtures[0][0] + combination[1] * mixtures[1][0] + combination[2] * mixtures[2][0]) / goal[0];
            out.print(combination[0] + " ");
            out.print(combination[1] + " ");
            out.print(combination[2] + " ");
            out.println(muliple);
        }
        out.close();                                  // close the output file
    }
    private static int gcd(int a, int b){
        if(a < b){
            int swap = a;
            a = b;
            b = swap;
        }
        while(b > 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    private static int trigcd(int a, int b, int c){
        return gcd(a, gcd(b, c));
    }
    private static boolean check(int[] a){
        int gcd = trigcd(a[0], a[1], a[2]);
        boolean pass = true;
        for(int i = 0; i < 3; i++){
            if(a[i] / gcd != realgoal[i]){
                pass = false;
                break;
            }
        }
        return pass;
    }
}

