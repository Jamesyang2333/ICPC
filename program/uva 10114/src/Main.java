import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int duration = Integer.parseInt(st.nextToken());
            if(duration < 0)
                break;
            double down = Double.parseDouble(st.nextToken());
            double total = Double.parseDouble(st.nextToken());
            int nrates = Integer.parseInt(st.nextToken());
            int[] months = new int[nrates];
            double[] rates = new double[nrates];
            for(int i = 0; i < nrates; i++){
                st = new StringTokenizer(br.readLine());
                months[i] = Integer.parseInt(st.nextToken());
                rates[i] = Double.parseDouble(st.nextToken());
            }
            double monthly  = total / duration;
            int count = 0;
            if(duration > 0){
            double owe = total;
            double carVal = total + down;
            int ratecount = 0;
            count = 0;
            for(; count <= duration; count++){
                if(ratecount < nrates - 1 && months[ratecount + 1] <= count)
                    ratecount++;
                if(count >= 1)
                    owe -= monthly;
                carVal *= (1 - rates[ratecount]);
                //System.out.println(owe + " " + carVal);
                if(owe < carVal)
                    break;
            }
            }
            if(count == 1){
                System.out.format("%d month\n", count);
            }
            else{
                System.out.format("%d months\n", count);
            }
        }
    }
}
