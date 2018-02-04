/*
ID: jamesya4
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

class transform {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        char[][] before = new char[n][n];
        char[][] after = new char[n][n];
        char[][] operation = null;
        int min = 0;
        boolean trya = true;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            String line = st.nextToken();
            for (int j = 0; j < n; j++) {
                before[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            String line = st.nextToken();
            for (int j = 0; j < n; j++) {
                after[i][j] = line.charAt(j);
            }
        }
        if(trya){
        operation = rotate(before, n);
        if(check(operation, after, n)) {
            min = 1;
            trya = false;
        }
        }
        if(trya){
            operation = rotate(operation, n);
            if(check(operation, after, n)) {
                min = 2;
                trya = false;
            }
        }
        if(trya){
            operation = rotate(operation, n);
            if(check(operation, after, n)) {
                min = 3;
                trya = false;
            }
        }
        if(trya){
            operation = reflect(before, n);
            if(check(operation, after, n)) {
                min = 4;
                trya = false;
            }
        }
        int count = 1;
        while(trya & count <= 3){
            operation = rotate(operation, n);
            if(check(operation, after, n)) {
                min = 5;
                trya = false;
            }
            count++;
        }
        if(trya){
            if (check(before,after,n)){
                min = 6;
                trya = false;
            }
        }
        if(trya)
            min = 7;
        out.println(min);                           // output result
        out.close();                                  // close the output file
    }

    private static char[][] rotate(char[][] before, int n){
        char[][] result = new char[n][n];
        for(int i = n-1; i >= 0; i--)
            for(int j = 0; j < n; j++)
                result[j][i] = before[n-1-i][j];
        return result;
    }

    private static char[][] reflect(char[][] before, int n){
        char[][] result = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n/2 + 1; j++){
                result[i][j] = before[i][n-1-j];
                result[i][n-1-j] = before[i][j];
        }
        return result;
    }

    private static boolean check(char[][] a, char[][] b, int n){
        boolean result = true;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(a[i][j] != b[i][j])
                    result = false;
        return result;
    }

}

