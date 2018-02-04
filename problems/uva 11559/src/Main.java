import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String line = br.readLine();
            if(line == null)
                break;
            StringTokenizer st = new StringTokenizer(line);
            int npeople = Integer.parseInt(st.nextToken());
            int budget = Integer.parseInt(st.nextToken());
            int nhotel = Integer.parseInt(st.nextToken());
            int nweek = Integer.parseInt(st.nextToken());
            boolean can = false;
            int minCost = 10000000;
            for(int i = 0; i < nhotel; i++){
                int cost = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
                st = new StringTokenizer(br.readLine());
                if(cost * npeople <= budget){
                for(int j = 0; j  < nweek; j++){
                    int  quota = Integer.parseInt(st.nextToken());
                    if(quota >= npeople){
                        if(!can)
                            can = true;
                        minCost = Math.min(npeople * cost, minCost);
                    }
                }
                }
            }
            if(can)
                System.out.println(minCost);
            else System.out.println("stay home");
        }
    }
}
