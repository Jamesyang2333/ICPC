import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        HashMap<Integer, Integer> result = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        result.put(0, 0);
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if(result.containsKey(end - start)){
                System.out.println(result.get(end - start));
            }
            else{
                int answer = search(0, true, end - start);
                result.put(end - start, answer);
                System.out.println(answer);
            }
        }
    }
    public static int search(int prev, boolean increase, int left){
        if((prev == 1 || prev == 0 || prev == 2) && left == 1)
            return 1;
        if(increase){
            if(left - prev - 1 >= (prev + 1) * prev / 2){
                return 1 + search(prev + 1, true, left - prev - 1);
            }
            else{
                if(left - prev >= (prev - 1) * prev / 2){
                    return 1 + search(prev, false, left - prev);
                }
                else return 1 + search(prev - 1, false, left - prev + 1);
            }
        }
        else{
            if(left - prev >= (prev - 1) * prev / 2){
                return 1 + search(prev, false, left - prev);
            }
            else return 1 + search(prev - 1, false, left - prev + 1);
        }
    }
}
