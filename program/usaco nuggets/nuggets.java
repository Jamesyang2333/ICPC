/*
ID: jamesya4
LANG: JAVA
TASK: nuggets
*/
import java.io.*;
import java.util.*;

class nuggets {
    private static boolean[] can = new boolean[200000];
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("nuggets.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nuggets.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int npacks = Integer.parseInt(st.nextToken());
        int[] numbers = new int[npacks];
        for(int i = 0; i < npacks; i++){
            st = new StringTokenizer(f.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int gcd = numbers[0];
        for(int i = 1; i < npacks; i++){
            gcd = gcd(gcd, numbers[i]);
        }
        int result = 0;
        if(gcd == 1){
        int min = numbers[0];
        int count = 0;
        can[0] = true;
        for(int i = 0; i < 200000; i++){
            if(can[i]){
                count++;
                if(count == min){
                    if(i - min >= 0)
                        result = i - min;
                    break;
                }
                for(int j = 0; j < npacks; j++){
                    if(!can[i + numbers[j]])
                        can[i + numbers[j]] = true;
                }
            }
            else{
                count = 0;
            }
        }
        }
        out.println(result);
        out.close();                                  // close the output file
    }
    private static int gcd(int a, int b){
        if(b == 0)
            return a;
        else return gcd(b, a % b);
    }
}
