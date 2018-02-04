/*
ID: jamesya4
LANG: JAVA
TASK: stamps
*/
import java.io.*;
import java.util.*;

class stamps {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("stamps.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int nstamps = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        HashSet<Integer> valueSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(i % 15 == 0)
                st = new StringTokenizer(f.readLine());
            valueSet.add(Integer.parseInt(st.nextToken()));
        }
        int nvalues = valueSet.size();
        int[] values = new int[nvalues];
        int l = 0;
        for(int x : valueSet)
            values[l++] = x;
        Arrays.sort(values);
        int counter = 0;
        int max = nstamps * values[nvalues - 1];
        int[] dp = new int[max + 1];
        int result = max;
        for(int i = 1; i <= max; i++){
            int min = 400;
            if(counter < nvalues && i == values[counter]){
                dp[i] = 1;
                counter++;
                min = 1;
            }
            else{
                for(int j = 0; j < counter; j++){
                    min = Math.min(dp[i - values[j]] + 1, min);

                }
            }
            dp[i] = min;
            if(min > nstamps){
                result = i - 1;
                break;
            }
        }
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
}
