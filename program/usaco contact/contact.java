/*
ID: jamesya4
LANG: JAVA
TASK: contact
*/
import java.io.*;
import java.util.*;

class contact {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("contact.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder input = new StringBuilder();
        String line;
        while((line = f.readLine()) != null){
            input.append(line);
        }
        char[] radio = input.toString().toCharArray();
        int[][] count = new int[max][];
        for(int i = 0; i < max; i++)
            count[i] = new  int[1 << (i + 1)];
        int length = radio.length;
        int[][] dp = new int[max][length];
        for(int i = 0; i < max; i++)
            for(int j = 0; j < (1 << (i + 1)); j++)
                count[i][j] = 0;
        for(int i = 0; i < length; i++){
            for(int j = 0; j < max; j++){
                if(i >= j){
                    if(j == 0){
                        if(radio[i] == '0') {
                            dp[j][i] = 0;
                            count[j][0]++;
                        }
                        else {
                            dp[j][i] = 1;
                            count[j][1]++;
                        }
                    }
                    else{
                        if(radio[i] == '0') {
                            dp[j][i] = 2 * dp[j - 1][i - 1];
                            count[j][dp[j][i]]++;
                        }
                        else {
                            dp[j][i] = 2 * dp[j - 1][i - 1] + 1;
                            count[j][dp[j][i]]++;
                        }
                    }
                }
                else break;
            }
        }
        PriorityQueue<segment> result= new PriorityQueue<>();
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        for(int i = 0; i < max; i++)
            for(int j = 0; j < count[i].length; j++){
                if(count[i][j] != 0 && i >= min - 1){
                    if(numbers.size() < n) {
                        result.add(new segment(j, i + 1, count[i][j]));
                        if(!numbers.contains(count[i][j]))
                            numbers.add(count[i][j]);
                    }
                    else {
                        if (numbers.contains(count[i][j]))
                            result.add(new segment(j, i + 1, count[i][j]));
                        else {
                            if (count[i][j] > numbers.peek()) {
                                numbers.add(count[i][j]);
                                int remove = numbers.poll();
                                while(result.peek().frequency == remove)
                                    result.poll();
                                result.add(new segment(j, i + 1, count[i][j]));
                        }
                    }
                    }
                }
            }
        segment[] resultarr = new segment[result.size()];
        for(int i = 0; i < resultarr.length; i++){
                resultarr[i] = result.poll();
        }
        Arrays.sort(resultarr);
        int count1 = 0;
        for(int i = resultarr.length - 1; i >= 0; i--){
            if(i == resultarr.length - 1 || resultarr[i].frequency != resultarr[i + 1].frequency){
                count1 = 1;
                if(i != resultarr.length - 1){
                    out.println();
                }
                out.println(resultarr[i].frequency);
                for(int j = resultarr[i].length - 1; j >= 0; j--){
                    if((resultarr[i].number & (1 << j)) > 0)
                        out.print(1);
                    else out.print(0);
                }
            }
            else{
                if(count1 == 6) {
                    out.println();
                    count1 = 1;
                }
                else{
                count1++;
                out.print(" ");
                }
                for(int j = resultarr[i].length - 1; j >= 0; j--){
                    if((resultarr[i].number & (1 << j)) > 0)
                        out.print(1);
                    else out.print(0);
                }
            }
        }
        out.println();

        out.close();                                  // close the output file
    }
}
class segment implements Comparable<segment>{
    public int number;
    public int length;
    public int frequency;
    public segment(int number, int length, int frequency){
        this.number = number;
        this.length = length;
        this.frequency = frequency;
    }
    public int compareTo(segment a){
        if(frequency != a.frequency)
        return frequency - a.frequency;
        else{
            if(length != a.length)
                return a.length - length;
            else return a.number - number;
        }
    }
}