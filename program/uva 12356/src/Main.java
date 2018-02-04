import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int nreports = Integer.parseInt(st.nextToken());
            if(n == 0 && nreports == 0)
                break;
            int[] soldiersL = new int[n];
            int[] soldiersR = new int[n];
            for(int i = 0; i < n - 1; i++){
                soldiersR[i] = i + 1;
                soldiersL[i + 1] = i;
            }
            soldiersL[0] = -1;
            soldiersR[n - 1] = -1;
            for(int i = 0; i < nreports; i++){
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken()) - 1;
                int right = Integer.parseInt(st.nextToken()) - 1;
                if(soldiersL[left] != -1){
                    soldiersR[soldiersL[left]] = soldiersR[right];
                    pw.print(soldiersL[left] + 1);
                }
                else pw.print("*");
                if(soldiersR[right] != -1){
                    soldiersL[soldiersR[right]] = soldiersL[left];
                    pw.println(" " + (soldiersR[right] + 1));
                }
                else pw.println(" *");
            }
            pw.println("-");
        }
        pw.close();
    }
}
