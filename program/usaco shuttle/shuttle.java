/*
ID: jamesya4
LANG: JAVA
TASK: shuttle
*/
import java.io.*;
import java.util.StringTokenizer;

public class shuttle {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("shuttle.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuttle.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        int p = n + 1;
        boolean add = false;
        for(int i = 2; i < n + 2; i++){
            if(add)
                p++;
            else
                p--;
            add = !add;
            if(add){
                for(int j = 0; j < i; j++){
                    count++;
                    if(count % 20 == 0)
                        out.println(p);
                    else if(count != n * (n + 2))
                        out.print(p + " ");
                    else out.println(p);
                if(j != i - 1)
                    p += 2;
                }
            }
            else{
                for(int j = 0; j < i; j++){
                    count++;
                    if(count % 20 == 0)
                        out.println(p);
                    else if(count != n * (n + 2))
                        out.print(p + " ");
                    else out.println(p);
                    if(j != i - 1)
                        p -= 2;
                }
            }
        }
        add = !add;
        for(int i = n; i >= 1; i--){
            if(add)
                p++;
            else
                p--;
            if(add){
                for(int j = 0; j < i; j++){
                    count++;
                    if(count % 20 == 0)
                        out.println(p);
                    else if(count != n * (n + 2))
                        out.print(p + " ");
                    else out.println(p);
                    if(j != i - 1)
                        p += 2;
                }
            }
            else{
                for(int j = 0; j < i; j++){
                    count++;
                    if(count % 20 == 0)
                        out.println(p);
                    else if(count != n * (n + 2))
                        out.print(p + " ");
                    else out.println(p);
                    if(j != i - 1)
                        p -= 2;
                }
            }
            add = !add;
        }
        out.close();
    }
}
