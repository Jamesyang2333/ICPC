/*
ID: jamesya4
LANG: JAVA
TASK: hamming
*/
import java.io.*;
import java.util.*;

class hamming {
    private static int b;
    private static int d;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        int[] solution = new int[n];
        solution[0] = 0;
        for(int i = 1; i < n; i++){
            int start =  solution[i - 1];
            while(true){
                start++;
                boolean suitable = true;
                for(int j = 0; j < i; j++){
                    if(!check(solution[j], start)){
                        suitable= false;
                        break;
                    }
                }
                if(!suitable)
                    continue;
                else{
                    solution[i] = start;
                    break;
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(i % 10 == 0 || i == n){
                out.println(solution[i - 1]);
            }
            else out.print(solution[i - 1] + " ");
        }
        out.close();                                  // close the output file
    }
    private static boolean check(int a1, int a2){
        int xor = a1 ^ a2;
        int count = 0;
        for(int i = 0; i < b; i++){
            if((xor & (int)Math.pow(2, i)) > 0)
                count++;
        }
        if(count >= d)
        return true;
        else return false;
    }
}
