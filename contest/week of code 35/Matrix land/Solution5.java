//Finally got AC... used DIY input reader(not necessarily)
import java.io.*;
public class Solution5{
    public static void main(String[] args) throws IOException{
        Scan in = new Scan();
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in),10000 * 8192);
        //BufferedReader br = new BufferedReader(new FileReader("input19.txt"), 10000 * 8192);
        //StringTokenizer st = new StringTokenizer(br.readLine());
        //int n = Integer.parseInt(st.nextToken());
        //int m = Integer.parseInt(st.nextToken());
        int n = in.scanInt();
        int m = in.scanInt();
        int[][] sumFromLeft = new int[n][m];
        long[][]best = new long[n][m];
        long result = 0;
        if(m == 1){
            for(int i = 0; i < n; i++){
                result += in.scanInt();
            }
        }
        else{
            for(int i  = 0; i < n; i++){
                sumFromLeft[i][0] = in.scanInt();
                result += sumFromLeft[i][0];
                for(int j = 1; j < m; j++){
                    sumFromLeft[i][j] = in.scanInt() + sumFromLeft[i][j - 1];
                }
            }
            int[][] sumFromRight = new int[n][m];
            int[][] maxSumFromLeft = new int[n][m];
            int[][] maxSumFromRight = new int[n][m];
            for(int i = 0; i < n; i++){
                maxSumFromLeft[i][m - 1] = sumFromLeft[i][m - 1];
                for(int j = m - 2; j >= 0; j--){
                    maxSumFromLeft[i][j] = Math.max(sumFromLeft[i][j], maxSumFromLeft[i][j + 1]);
                }
            }
            for(int i = 0; i < n; i++){
                sumFromRight[i][0] = sumFromLeft[i][m - 1];
                for(int j = 1; j < m; j++){
                    sumFromRight[i][j] = sumFromLeft[i][m - 1] - sumFromLeft[i][j - 1];
                }
            }
            for(int i = 0; i < n; i++){
                maxSumFromRight[i][0] = sumFromRight[i][0];
                for(int j = 1; j < m; j++)
                    maxSumFromRight[i][j] = Math.max(maxSumFromRight[i][j - 1], sumFromRight[i][j]);
            }
            long[] fromLeft = new long[m];
            fromLeft[0] = maxSumFromLeft[0][0];
            for(int j = 1; j < m; j++){
                long next = fromLeft[j - 1] + (maxSumFromLeft[0][j] - maxSumFromLeft[0][j - 1]);
                if(maxSumFromLeft[0][j] - sumFromLeft[0][j - 1] > next){
                    fromLeft[j] = maxSumFromLeft[0][j] - sumFromLeft[0][j - 1];
                }
                else{
                    fromLeft[j] = next;
                }
            }
            long[] fromRight = new long[m];
            fromRight[m - 1] = maxSumFromRight[0][m - 1];
            for(int j = m - 2; j >= 0; j--){
                long next = fromRight[j + 1] + (maxSumFromRight[0][j] - maxSumFromRight[0][j + 1]);
                if(maxSumFromRight[0][j] - sumFromRight[0][j + 1] > next){
                    fromRight[j] = maxSumFromRight[0][j] - sumFromRight[0][j + 1];
                }
                else{
                    fromRight[j] = next;
                }
            }
            for(int j = 0; j < m; j++){
                best[0][j] = Math.max(fromLeft[j], fromRight[j]);
            }
            for(int i = 1; i < n; i++){
                fromLeft = new long[m];
                long upper = best[i - 1][0];
                fromLeft[0] = best[i - 1][0] + maxSumFromLeft[i][0];
                long before = sumFromLeft[i][0];
                for(int j = 1; j < m; j++){
                    if(best[i - 1][j] > upper)
                        upper = best[i - 1][j];
                    long next = before + upper + maxSumFromLeft[i][j] - sumFromLeft[i][j - 1];
                    long alter = maxSumFromLeft[i][j] - sumFromLeft[i][j - 1] + maxSumFromRight[i][j] - sumFromRight[i][j] + best[i - 1][j];
                    if(alter > next){
                        fromLeft[j] = alter;
                        upper = best[i - 1][j];
                        if(j < m - 1)
                            before = maxSumFromRight[i][j] - sumFromRight[i][j + 1];
                    }
                    else{
                        fromLeft[j] = next;
                        if(best[i - 1][j] > upper)
                            upper = best[i - 1][j];
                        before += (sumFromLeft[i][j] - sumFromLeft[i][j - 1]);
                    }
                }
                fromRight = new long[m];
                upper = best[i - 1][m - 1];
                fromRight[m - 1] = best[i - 1][m - 1] + maxSumFromRight[i][m - 1];
                before = sumFromRight[i][m - 1];
                for(int j = m - 2; j >= 0; j--){
                    if(best[i - 1][j] > upper)
                        upper = best[i - 1][j];
                    long next = before + upper + maxSumFromRight[i][j] - sumFromRight[i][j + 1];
                    long alter = maxSumFromLeft[i][j] - sumFromLeft[i][j] + maxSumFromRight[i][j] - sumFromRight[i][j + 1] + best[i - 1][j];
                    if(alter > next){
                        fromRight[j] = alter;
                        upper = best[i - 1][j];
                        if(j > 0)
                            before = maxSumFromLeft[i][j] - sumFromLeft[i][j - 1];
                    }
                    else{
                        fromRight[j] = next;
                        if(best[i - 1][j] > upper)
                            upper = best[i - 1][j];
                        before += (sumFromRight[i][j] - sumFromRight[i][j + 1]);
                    }
                }
                for(int j = 0; j < m; j++){
                    best[i][j] = Math.max(fromLeft[j], fromRight[j]);
                }
            }
            result = best[n - 1][0];
            for(int i = 1; i < m; i++)
                result = Math.max(result, best[n - 1][i]);
        }
        System.out.println(result);
    }
}
class Scan
{
    private byte[] buf=new byte[1024];    //Buffer of Bytes
    private int index;
    private InputStream in;
    private int total;
    public Scan()
    {
        in=System.in;
    }
    public int scan()throws IOException    //Scan method used to scan buf
    {
        if(index>=total)
        {
            index=0;
            total=in.read(buf);
            if(total<=0)
                return -1;
        }
        return buf[index++];
    }
    public int scanInt()throws IOException
    {
        int integer=0;
        int n=scan();
        while(isWhiteSpace(n))    //Removing starting whitespaces
            n=scan();
        int neg=1;
        if(n=='-')                //If Negative Sign encounters
        {
            neg=-1;
            n=scan();
        }
        while(!isWhiteSpace(n))
        {
            if(n>='0'&&n<='9')
            {
                integer*=10;
                integer+=n-'0';
                n=scan();
            }
        }
        return neg*integer;
    }
    private boolean isWhiteSpace(int n)
    {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
            return true;
        return false;
    }
}