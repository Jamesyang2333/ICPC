/*
ID: jamesya4
LANG: JAVA
TASK: wormhole
*/
import java.io.*;
import java.util.*;

class wormhole {
    private static int n;
    private static int[] pair;
    private static hole[] all;
    private static int result;
    private static int[] transfer;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        n = Integer.parseInt(st.nextToken());
        all = new hole[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            all[i] = new hole(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        pair = new int[n];
        for(int i = 0; i < n; i++)
            pair[i] = -1;
        transfer = new int[n];
        for(int i = 0; i < n; i++){
            transfer[i] = -1;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(transfer[i] == -1){
                    if(all[i].y == all[j].y && all[i].x < all[j].x){
                        transfer[i] = j;
                    }
                }
                else{
                    if(all[i].y == all[j].y && all[i].x < all[j].x && all[j].x < all[transfer[i]].x)
                        transfer[i] = j;
                }
            }
        }
        solve();

        
        out.println(result);                           // output result
        out.close();                                  // close the output file
    }
    private static void solve(){
        int i;
        for(i = 0; i < n; i++){
            if(pair[i] == -1)
                break;
        }
        if(i == n){
            if(loop()){
                result++;
                for(int j = 0; j < n; j++)
                    System.out.print(pair[j]);
                System.out.println();
            }

        }
        for(int j = i + 1; j < n; j++){
            if(pair[j] == -1){
                pair[i] = j;
                pair[j] = i;
                solve();
                pair[i] = -1;
                pair[j] = -1;
            }
        }
    }
    private static boolean loop(){
        boolean isloop = false;
        int pos;
        for(int i = 0; i < n; i++){
            pos = transfer[i];
            for(int j = 0; j < n - 1; j++){
                if(pos == -1)
                    break;
                pos = transfer[pair[pos]];
            }
            if(pos != -1){
                isloop = true;
                break;
            }
        }
        return isloop;
    }
}
class hole{
    int x;
    int y;
    public hole(int x, int y){
        this.x = x;
        this.y = y;
    }
}