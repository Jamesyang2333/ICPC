/*
ID: jamesya4
LANG: JAVA
TASK: preface
*/
import java.io.*;
import java.util.*;

class preface {
    private static int[] find1;
    private static int[] find5;
    private static int[] base1 = {0, 1, 2, 3, 1, 0, 1, 2, 3, 1};
    private static int[] base5 = {0, 0, 0, 0, 1, 1, 1, 1, 1, 0};
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("preface.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        char[] allLetter= {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] result = new int[7];
        for (int i = 0; i < 7; i++)
            result[i] = 0;
        find1 = new int[11];
        for (int i = 0; i < 11; i++)
            find1[i] = -1;
        find5 = new int[10];
        for (int i = 0; i < 10; i++)
            find5[i] = -1;
        result[0] = findI(n);
        result[1] = findV(n);
        result[2] = findX(n);
        result[3] = findL(n);
        result[4] = findC(n);
        result[5] = findD(n);
        result[6] = findM(n);

        for (int i = 0; i < 7 && result[i] != 0; i++)
            out.println(allLetter[i] + " " + result[i]);
        out.close();                                  // close the output file
        System.out.println(findM(1000));
    }
    private static int findI(int n){
        if(n <= 9){
            if(find1[n] != -1)
                return find1[n];
            else{
            int result = 0;
            for(int i = 0; i <= n; i++)
                result += base1[i];
            find1[n] = result;
            return result;
        }
        }
        if (n == 10){
            if(find1[n] == -1){
                find1[10] = findI(9);
                return find1[9];
            }
            else return find1[10];
        }
        else return ((n / 10) * findI(10) + findI(n % 10));
    }
    private static int findX(int n){
        if(n < 9) return 0;
        else if (n == 9) return 1;
        else if (n < 100){
            return findI(n / 10 - 1) * 10 + n / 10 + base1[n / 10] * (n % 10 + 1) + findX(n % 10);
        }
        else return findX(99) * (n / 100) + findX(n % 100);
    }

    private static int findC(int n) {
        if (n < 90) return 0;
        else if (n < 100) return (n - 90 + 1);
        else if (n < 1000)
            return findI(n / 100 - 1) * 100 + (n / 100) * 10 + base1[n / 100] * (n % 100 + 1) + findC(n % 100);
        else return findC(999) * (n / 1000) + findC(n % 1000);
    }
    private static int findM(int n){
        if(n < 900) return 0;
        else if (n < 1000) return (n - 900 + 1);
        else return findI(n / 1000 - 1) * 1000 + (n / 1000) * 100 + base1[n / 1000] * (n % 1000 + 1) + findM(n % 1000);
    }
    private static int findV(int n){
        if (n < 0)
            return 0;
        else if(n <= 9){
            if(find5[n] != -1)
                return find5[n];
            else{
                int result = 0;
                for(int i = 0; i <= n; i++)
                    result += base5[i];
                find5[n] = result;
                return result;
            }
        }
        else return ((n / 10) * findV(9) + findV(n % 10));
    }
    private static int findL(int n){
        if (n < 40) return 0;
        else if (n < 100) return findV(n / 10 - 1) * 10 + base5[n / 10] * (n % 10 + 1);
        else return findL(99) * (n / 100) + findL(n % 100);
    }
    private static int findD(int n){
        if (n < 400) return 0;
        else if (n < 1000) return findV(n / 100 - 1) * 100 + base5[n / 100] * (n % 100 + 1);
        else return findD(999) * (n / 1000) + findD(n % 1000);
    }
}
