import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long total = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            long larger;
            long smaller;
            long largerTimes;
            long smallerTimes;
            if(total % 2 == 0){
                larger = total / 2;
                smaller = total / 2 - 1;
            }
            else{
                larger = total / 2;
                smaller = total / 2;
            }
            if(k == 1){
                System.out.format("Case #%d: %d %d\n", i + 1, larger, smaller);
                continue;
            }
            largerTimes = 1;
            smallerTimes = 1;
            long totalmoves = 1;
            long accu = 1;
            while(totalmoves + accu * 2 < k){
                //System.out.println(larger + " " + smaller + " " + largerTimes + " " + smallerTimes);
                totalmoves += (accu * 2);
                accu *= 2;
                if(larger % 2 == 0){
                    long newlargerTimes = largerTimes;
                    long newsmallerTimes = largerTimes;
                    if(smaller % 2 == 0){
                        newlargerTimes += smallerTimes;
                        newsmallerTimes += smallerTimes;
                    }
                    else{
                        newsmallerTimes += (2 * smallerTimes);
                    }
                    smaller = larger / 2 - 1;
                    larger = larger / 2;
                    largerTimes = newlargerTimes;
                    smallerTimes = newsmallerTimes;
                }
                else{
                    long newlargerTimes = largerTimes * 2;
                    long newsmallerTimes = 0;
                    if(smaller % 2 == 1){
                        larger = larger / 2;
                        smaller = smaller / 2;
                        newsmallerTimes = smallerTimes * 2;
                    }
                    else{
                    larger = larger / 2;
                    smaller = smaller / 2 - 1;
                    newlargerTimes += smallerTimes;
                    newsmallerTimes = smallerTimes;
                    }
                    largerTimes = newlargerTimes;
                    smallerTimes = newsmallerTimes;
                }
            }
            //System.out.println(larger + " " + smaller + " " + largerTimes + " " + smallerTimes);
                if(k - totalmoves <= largerTimes){
                    if(larger % 2 == 0)
                        System.out.format("Case #%d: %d %d\n", i + 1, larger / 2, larger / 2 - 1);
                    else
                        System.out.format("Case #%d: %d %d\n", i + 1, larger / 2, smaller / 2);
                }
                else{
                    if(smaller % 2 == 0)
                        System.out.format("Case #%d: %d %d\n", i + 1, smaller / 2, smaller / 2 - 1);
                    else
                        System.out.format("Case #%d: %d %d\n", i + 1, smaller / 2, smaller / 2);
                }
        }
    }
}
