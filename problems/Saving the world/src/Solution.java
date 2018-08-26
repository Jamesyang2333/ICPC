import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            int nengines = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            HashMap<String, Integer> indices = new HashMap<>();
            for(int i = 0; i < nengines;  i++){
                indices.put(br.readLine(), i);
            }
            HashSet<String> words = new HashSet<>();
            String previous = "";
            int nqueries = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            int count = 0;
            if(nqueries != 0){
            for(int i = 0; i < nqueries; i++){
                String current = br.readLine();
                words.add(current);
                if(words.size() == nengines){
                    count++;
                    words.clear();
                    words.add(current);
                }
            }
            }
            System.out.format("Case #%d: %d\n", cc + 1, count);
        }
    }
}
