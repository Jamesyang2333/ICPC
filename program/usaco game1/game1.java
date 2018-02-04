/*
ID: jamesya4
LANG: JAVA
TASK: game1
*/
import java.io.*;
import java.util.*;

class game1 {
    private static int[] numbers;
    private static int n;
    private static byte[][] chooseLefts;
    private static int[][] best;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("game1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        n = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        st = new StringTokenizer(f.readLine());
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(!st.hasMoreTokens())
                st = new StringTokenizer(f.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            sum += numbers[i];
        }
        chooseLefts = new byte[n][n];
        best = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
            chooseLefts[i][j] = -1;
            best[i][j] = -1;
            }
        int best = bestOutcome(0, n - 1);
        out.print(best);                           // output result
        out.println(" " + (sum - best));
        out.close();                                  // close the output file
    }
    private static int bestOutcome(int start, int end){
        if(best[start][end] != -1)
            return best[start][end];
        int length = end - start + 1;
        if(length == 1)
            return numbers[end];
        if(length == 2)
            return Math.max(numbers[start], numbers[end]);
        else{
            int startCopy = start;
            int endCopy = end;
            int first = 0;
            if(chooseLeft(start, end)){
                first = numbers[start];
                startCopy++;
            }
            else{
                first = numbers[end];
                endCopy--;
            }
            if(chooseLeft(startCopy, endCopy)){
                startCopy++;
            }
            else{
                endCopy--;
            }
            best[start][end] = first + bestOutcome(startCopy, endCopy);
            return best[start][end];
        }
    }
    private static boolean chooseLeft(int start, int end){
        if(chooseLefts[start][end] != -1)
            return (chooseLefts[start][end] == 0);
        int length = end - start + 1;
        if (length == 1){
            chooseLefts[start][end] = 0;
            return true;}
        else if(length == 2){
            if(numbers[start] > numbers[end])
                chooseLefts[start][end] = 0;
            else chooseLefts[start][end] = 1;
            return (chooseLefts[start][end] == 0);
        }
        int startco1 = start;
        int endco1 = end;
        int leftResult = 0;
        int left = numbers[start];
        startco1++;
        int[] next = new int[length - 2];
        if(chooseLeft(startco1, end)){
            startco1++;
        }
        else{
            endco1--;
        }
        leftResult = left + bestOutcome(startco1, endco1);
        int startco2 = start;
        int endco2 = end;
        int rightResult = 0;
        int right = numbers[end];
        endco2--;
        if(chooseLeft(startco2, endco2)){
            startco2++;
        }
        else{
            endco2--;
        }
        rightResult = right + bestOutcome(startco2, endco2);
        if(leftResult > rightResult)
            chooseLefts[start][end] = 0;
        else chooseLefts[start][end] = 1;
        return leftResult > rightResult;
    }
}
