import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static ArrayList<Integer>[] adj;
    //private static int[] nimsum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int i = 0; i < ncases; i++){
            int N = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            /*nimsum = new int[N];
            for(int j = 0; j < N; j++)
                nimsum[i] = -1;*/
            adj = (ArrayList<Integer>[]) new ArrayList[N];
            for(int j = 0; j < N; j++)
                adj[j] = new ArrayList<Integer>();
            for(int j = 0; j < N - 1; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a - 1].add(b - 1);
                adj[b - 1].add(a - 1);
            }
            int nim = getnim(0, 0);
            //System.out.println(nim);
            if(nim == 0)
                System.out.println("Bob");
            else System.out.println("Alice");
        }
    }
    private static int getnim(int n, int prev){
        //The base case is not necessary
        //if(adj[n].size() == 1 && n != 0)
          //  return 0;
        int nim = 0;
        if(n == 0){
            for(Integer child: adj[n]){
                nim = nim ^ (getnim(child, n) + 1);
            }
        }
        else{
            for(Integer child: adj[n]){
                if(child != prev)
                    nim = nim ^ (getnim(child, n) + 1);
            }
        }
        return nim;
    }
}
