import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        HashSet<String>[] numbers = (HashSet<String>[]) new HashSet[1024];
        for(int i = 0; i < 1024; i++) {
            numbers[i] = new HashSet<>();
        }
        for(int i = 0; i < n; i++){
            String ticket = new StringTokenizer(br.readLine()).nextToken();
            numbers[convert(ticket)].add(ticket);
        }
        long result = 0;
        for(int i = 0; i < 1024; i++){
            for(int j = i + 1; j < 1024; j++){
                if((i | j) == 1023)
                    result += (numbers[i].size() * numbers[j].size());
            }
        }
        result += (((long)numbers[1023].size()) * (numbers[1023].size() - 1) / 2);
        System.out.println(result);
    }
    public static int convert(String a){
        int result = 0;
        int len = a.length();
        for(int i = 0; i < len; i++){
            result = result | (1 << (a.charAt(i) - '0'));
        }
        return result;
    }
}
