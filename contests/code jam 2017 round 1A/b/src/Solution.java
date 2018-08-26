import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ningre = Integer.parseInt(st.nextToken());
            int npacks = Integer.parseInt(st.nextToken());
            int[] weight = new int[ningre];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < ningre; i++){
                weight[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<range>[] packs = (ArrayList<range>[]) new ArrayList[ningre];
            for(int i = 0; i < ningre; i++)
                packs[i] = new ArrayList<>();
            int answer = 0;
            for(int i = 0; i < ningre; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < npacks; j++){
                    double size = (double) Integer.parseInt(st.nextToken());
                    int lower = (int)Math.ceil(size / 1.1 / weight[i]);
                    int upper = (int)Math.floor(size / 0.9 / weight[i]);
                    if(lower <= upper){
                        packs[i].add(new range(lower, upper));
                    }
                }
                if(packs[i].size() == 0){
                    answer = -1;
                }
                Collections.sort(packs[i]);
            }
            if(answer == -1){
                System.out.format("Case #%d: 0\n", cc + 1);
                continue;
            }
            int[] pointer = new int[ningre];
            for(int i = 0; i < ningre; i++)
                pointer[i] = 0;
            boolean stop = false;
            while(true){
                int min = 10000000;
                int minindex = 0;
                range ran = new range(-1, 10000000);
                for(int i = 0; i < ningre; i++){
                    if(ran != null){
                        ran = ran.intersect(packs[i].get(pointer[i]));
                        if(packs[i].get(pointer[i]).end < min){
                            min = packs[i].get(pointer[i]).end;
                            minindex = i;
                        }
                    }
                }
                if(ran != null){
                    answer++;
                    for(int i = 0; i < ningre; i++){
                        pointer[i]++;
                        if(pointer[i] == packs[i].size()){
                            stop = true;
                            break;
                        }
                    }
                }
                else{
                    pointer[minindex]++;
                    if(pointer[minindex] == packs[minindex].size()){
                        stop = true;
                        break;
                    }
                }
                if(stop)
                    break;
            }
            System.out.format("Case #%d: %d\n", cc + 1, answer);
        }
    }
}
class range implements Comparable<range>{
    int start;
    int end;
    public range(int start, int end){
        this.start = start;
        this.end = end;
    }
    public int compareTo(range a){
        if(start != a.start){
            return start - a.start;
        }
        else return end - a.end;
    }
    public range intersect(range a){
        if(Math.max(start, a.start) > Math.min(end, a.end))
            return null;
        else return new range(Math.max(start, a.start), Math.min(end, a.end));
    }
}
