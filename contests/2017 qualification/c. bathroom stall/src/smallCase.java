import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class smallCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for (int i = 0; i < ncases; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long total = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            PriorityQueue<Long> states = new PriorityQueue<>(new reverseorder());
            states.add(total);
            for(int j = 0; j < k - 1; j++){
                long current = states.poll();
                if(current % 2 == 0){
                    states.add(current / 2);
                    states.add(current / 2 - 1);
                }
                else {
                    states.add(current / 2);
                    states.add(current / 2);
                }
            }
            long result = states.poll();
            if(result % 2 == 0)
                System.out.format("Case #%d: %d %d\n", i + 1, result / 2, result / 2 - 1);
            else
                System.out.format("Case #%d: %d %d\n", i + 1, result / 2, result / 2);
        }
    }
}
class reverseorder implements Comparator<Long>{
    public int compare(Long a, Long b){
        if(a < b)
            return 1;
        else if(a > b)
            return -1;
        else return 0;
    }
}