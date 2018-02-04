/*
ID: jamesya4
LANG: JAVA
TASK: frac1
*/
import java.io.*;
import java.util.*;

class frac1 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        frac[] allFrac = new frac[n * (n - 1) + 2];
        int count = 1;
        allFrac[0] = new frac(0, 1);
        allFrac[1] = new frac(1, 1);
        for(int deno = 2; deno <= n; deno++)
            for(int nume = 1; nume < deno; nume++){
                if(gcd(deno, nume) == 1){
                    allFrac[++count] = new frac(nume, deno);
                }
            }
        fracCompare a = new fracCompare();
        Arrays.sort(allFrac, 0, count + 1, a);
        for(int i = 0; i <= count; i++){
            out.println(allFrac[i].nume + "/" + allFrac[i].deno);
        }
        out.close();                                  // close the output file
    }
    private static int gcd(int a, int b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}
class frac{
    int nume;
    int deno;
    public frac(int nume, int deno){
        this.nume = nume;
        this.deno = deno;
    }
}
class fracCompare implements Comparator<frac>{
    public int compare(frac a, frac b){
        return a.nume * b.deno - a.deno * b.nume;
    }
}