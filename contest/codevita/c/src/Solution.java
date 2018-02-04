import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static int max = 0;
    private static int finallayer = 0;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            line = line.replaceAll(",", " ");
            StringTokenizer st = new StringTokenizer(line);
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[][] original = new int[M][N];
            for (int i = 0; i < M; i++) {
                line = br.readLine();
                line = line.replaceAll(",", " ");
                st = new StringTokenizer(line);
                for (int j = 0; j < N; j++) {
                    original[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            finallayer = original[0][0];
            search(original, 0, 0);
            System.out.println(max);
        } catch (IOException err) {
        }
    }

    private static void search(int[][] current, int layer, int number) {
        if (layer == finallayer) {
            if (number > max)
                max = number;
        } else {
            int nrows = current.length;
            int ncols = current[0].length;
            int min = 5000;
            ArrayList<int[]> minBlock = new ArrayList<>();
            int[] length = new int[nrows];
            for (int i = 0; i < nrows; i++) {
                for (int j = 0; j < ncols; j++) {
                    if (current[i][j] < min) {
                        minBlock.clear();
                        minBlock.add(new int[]{i, j});
                        min = current[i][j];
                    } else if (current[i][j] == min) {
                        minBlock.add(new int[]{i, j});
                    }
                }
            }
            for (int i = 0; i < nrows; i++) {
                int j;
                for (j = 0; j < ncols; j++) {
                    if (current[i][j] == min)
                        break;
                }
                if (i == 0)
                    length[i] = j;
                else length[i] = Math.min(j, length[i - 1]);

            }
            for (int i = nrows - 1; i >= 0; i--) {
                if (length[i] > 0) {
                    if ((i == nrows - 1) || length[i] > length[i + 1]) {
                        int[][] next = new int[i + 1][length[i]];
                        for (int j = 0; j <= i; j++)
                            for (int k = 0; k < length[i]; k++)
                                next[j][k] = current[j][k] - min;
                        search(next, layer + min, number + nrows * ncols * min);
                    }
                }
                else{
                    if(layer + min == finallayer)
                        search(null, layer + min, number + nrows * ncols * min);
                }
            }

        }
    }
}
