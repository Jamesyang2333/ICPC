import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int ncases = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncases; cc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nrows = Integer.parseInt(st.nextToken());
            int ncols = Integer.parseInt(st.nextToken());
            int horcut = Integer.parseInt(st.nextToken());
            int vercut = Integer.parseInt(st.nextToken());
            boolean[][] cake = new boolean[nrows][ncols];
            int totalchips = 0;
            for(int i = 0; i < nrows; i++){
                String line = br.readLine();
                for(int j = 0; j < ncols; j++){
                    if(line.charAt(j) == '@'){
                        cake[i][j] = true;
                        totalchips++;
                    }
                    else cake[i][j] = false;
                }
            }
            if(totalchips % ((horcut + 1) * (vercut + 1)) != 0)
                System.out.format("Case #%d: IMPOSSIBLE\n", cc + 1);
            else{
                int[] colsum = new int[ncols + 1];
                int[] rowsum = new int[nrows + 1];
                colsum[0] = 0;
                rowsum[0] = 0;
                for(int i = 0; i < nrows; i++){
                    int count = 0;
                    for(int j = 0; j < ncols; j++){
                        if(cake[i][j])
                            count++;
                    }
                    rowsum[i + 1] = rowsum[i] + count;
                }
                for(int i = 0; i < ncols; i++){
                    int count = 0;
                    for(int j = 0; j < nrows; j++){
                        if(cake[j][i])
                            count++;
                    }
                    colsum[i + 1] = colsum[i] + count;
                }
                int[] horcuts = new int[horcut + 1];
                int[] vercuts = new int[vercut + 1];
                int p = 1;
                boolean can = true;
                for(int i = 0; i < ncols; i++){
                    if(p > vercut + 1)
                        break;
                    if(colsum[i + 1] > totalchips / (vercut + 1) * p){
                        can = false;
                        break;
                    }
                    else if(colsum[i + 1] == totalchips / (vercut + 1) * p){
                        vercuts[p - 1] = i;
                        p++;
                    }
                }
                if(can){
                    p = 1;
                for(int i = 0; i < nrows; i++){
                    if(p > horcut + 1)
                        break;
                    if(rowsum[i + 1] > totalchips / (horcut + 1) * p){
                        can = false;
                        break;
                    }
                    else if(rowsum[i + 1] == totalchips / (horcut + 1) * p){
                        horcuts[p - 1] = i;
                        p++;
                    }
                }
                }
                if(can){
                for(int i = 1; i < vercut + 1; i++){
                    for(int j = 1; j < horcut + 1; j++){
                        int count = 0;
                        for(int a = horcuts[j - 1] + 1; a <= horcuts[j]; a++){
                            for(int b = vercuts[i - 1] + 1; b <= vercuts[i]; b++){
                                if(cake[a][b])
                                    count++;
                            }
                        }
                        if(count != totalchips / (vercut + 1)/ (horcut + 1)){
                            can = false;
                        break;
                        }
                    }
                    if(!can)
                        break;
                }
                }
                if(can)
                    System.out.format("Case #%d: POSSIBLE\n", cc + 1);
                else
                    System.out.format("Case #%d: IMPOSSIBLE\n", cc + 1);
            }
        }

    }
}
