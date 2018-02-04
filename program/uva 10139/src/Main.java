import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(m <= n){
                System.out.format("%d divides %d!\n", m, n);
            }
            else{
                HashMap<Integer, Integer> factors = new HashMap<>();
                int mcopy = m;
                while(mcopy % 2 == 0){
                    if(factors.containsKey(2)){
                        factors.put(2, factors.get(2) + 1);
                    }
                    else{
                        factors.put(2, 1);
                    }
                    mcopy /= 2;
                }
                for(int i = 3; i < Math.sqrt(m) + 0.5; i += 2){
                    while(mcopy % i == 0){
                        if(factors.containsKey(i)){
                            factors.put(i, factors.get(i) + 1);
                        }
                        else{
                            factors.put(i, 1);
                        }
                        mcopy /= i;
                    }
                }
                if(mcopy > 1)
                    factors.put(mcopy, 1);
                boolean divides = true;
                for(Integer factor : factors.keySet()){
                    int ncopy = n;
                    int times = factors.get(factor);
                    boolean can = false;
                    int count = 0;
                    while(ncopy >= factor){
                        count += (ncopy / factor);
                        if(count >= times){
                            can = true;
                            break;
                        }
                        ncopy /= factor;
                    }
                    if(!can){
                        divides = false;
                        break;
                    }
                }
                if (divides){
                    System.out.format("%d divides %d!\n", m, n);
                }
                else System.out.format("%d does not divide %d!\n", m, n);
            }
        }
    }
}
