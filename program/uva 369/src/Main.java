/*This method is flawed*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true){
            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(n == 0 && k == 0)
                break;
            System.out.format("%d things taken %d at a time is ", n, k);
            System.out.print(combination(n, k));
            System.out.println(" exactly.");
        }}
        catch (IOException err){}
    }
    private static long combination(int n, int k){
        if(k > n - k)
            k = n - k;
        int[] product = new int[k];
        for(int i = 0; i < k; i++){
            product[i] = n - i;
        }
        for(int j = k; j > 1; j--) {
            int copy = j;
            for(int i = 0; i < k; i++){
                if(product[i] % copy == 0) {
                    product[i] /= copy;
                    break;
                }
                if (product[i] != 1 && copy % product[i] == 0){
                    copy /= product[i];
                    product[i] = 1;
                }
            }
        }
        long result = 1;
        for(int i = 0;  i < k; i++)
            result *= product[i];
        return result;

    }
}
