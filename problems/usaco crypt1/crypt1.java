/*
ID: jamesya4
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

class crypt1 {
    private static HashSet<Integer> set1;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int[] set = new int[n];
        set1 = new HashSet<>(n);
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            set[i] = num;
            set1.add(num);
        }
        int count = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++){
                if (set[i] != 0){
                    int a = 100 * set[i] + 10 * set[j] + set[k];
                    for(int l = 0; l < n; l++)
                        for(int m = 0; m < n; m++){
                        if(set[l] != 0){
                            int par1 = set[m] * a;
                            if(par1 >= 1000)
                                continue;
                            if (!check(par1, 3))
                                continue;
                            int par2 = set[l] * a;
                            if(par2 >= 1000)
                                continue;
                            if(!check(par2, 3))
                                continue;
                            int tot = par1 + par2 * 10;
                            if(tot >= 10000)
                                continue;
                            if(check(tot,4)) {
                                count++;
                            }
                        }
                        }
                }
                }
        out.println(count);                           // output result
        out.close();                                  // close the output file
    }
    private static boolean check(int a, int len){
        boolean crypt = true;
        for(int i = 0; i < len; i++){
            int digit = a % 10;
            if(!set1.contains(digit)){
                crypt = false;
                break;
            }
            a /= 10;
        }
        return crypt;
    }
}
