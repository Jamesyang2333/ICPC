/*
ID: jamesya4
LANG: JAVA
TASK: camelot
*/
import java.io.*;
import java.util.*;

class camelot {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("camelot.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("camelot.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int[] rowmove = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] colmove = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int nrows = Integer.parseInt(st.nextToken());
        int ncols = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[ncols * nrows];
        for(int i = 0; i < ncols * nrows; i++)
            adj[i] = new ArrayList<Integer>();
        st = new StringTokenizer(f.readLine());
        int kcol = st.nextToken().charAt(0) - 'A' + 1;
        int krow = Integer.parseInt(st.nextToken());
        int kpos = (krow - 1) * ncols + kcol - 1;
        //System.out.println(kpos);
        ArrayList<Integer> knights = new ArrayList<>();
        while(st.hasMoreTokens()) {
            int col = st.nextToken().charAt(0) - 'A' + 1;
            int row = Integer.parseInt(st.nextToken());
            knights.add((row - 1) * ncols + col - 1);
        }
        //int nknights = knights.size();
        String line;
        while((line = f.readLine()) != null){
            st = new StringTokenizer(line);
            while(st.hasMoreTokens()){
                int col = st.nextToken().charAt(0) - 'A' + 1;
                int row = Integer.parseInt(st.nextToken());
                knights.add((row - 1) * ncols + col - 1);
            }
        }
        for(int i = 0; i < nrows * ncols; i++){
            int col = i % ncols + 1;
            int row = i / ncols + 1;
            for(int j = 0; j < 8; j++){
                if(col + colmove[j] > 0 && col + colmove[j] <= ncols && row + rowmove[j] > 0 && row + rowmove[j] <= nrows){
                    adj[i].add((row + rowmove[j] - 1) * ncols + col + colmove[j] - 1);
                }
            }
        }
        int[][] dis = new int[nrows * ncols][nrows * ncols];
        for(int i = 0; i < nrows * ncols; i++)
            for(int j = 0; j < ncols * nrows; j++)
                dis[i][j] = 1000000;
        for(int i = 0; i < nrows * ncols; i++){
            boolean[] checked = new boolean[ncols * nrows];
            for(int j = 0; j < ncols * nrows; j++)
                checked[j] = false;
            ArrayList<Integer> states = new ArrayList<>();
            dis[i][i] = 0;
            states.add(i);
            checked[i] = true;
            while(!states.isEmpty()){
                int current = states.remove(0);
                for(int neighbor : adj[current]){
                    if(!checked[neighbor]){
                        checked[neighbor] = true;
                        dis[i][neighbor] = dis[i][current] + 1;
                        states.add(neighbor);
                    }
                }
            }
        }
        /*int largest = 0;
        for(int i = 0; i < nrows * ncols; i++)
            for (int j = 0; j < ncols * nrows; j++)
                largest = Math.max(largest, dis[i][j]);
        System.out.println(largest);*/
        int min = 10000000;
        int[] estimate = new int[ncols * nrows];
        for(int i = 0; i < ncols * nrows; i++){
            int col = i % ncols + 1;
            int row = i / ncols + 1;
            int total = 0;
            if(knights.size() == 0){
                if((col + row - kcol - krow) % 2 ==0)
                min = (Math.abs(col - kcol) + Math.abs(row - krow)) / 2 + Math.abs(Math.abs(col - kcol) - Math.abs(row - krow)) / 2;
                else
                    min = Math.min(Math.abs(col - kcol), Math.abs(row - krow)) + Math.abs(Math.abs(col - kcol) - Math.abs(row - krow));
            estimate[i] = total;}
            else{
                for(int knight : knights){
                    total += dis[knight][i];
                }}
                estimate[i] = total;
            if(estimate[i] == 42){
                System.out.println(row + " " + col);
            }
            if(total< min) min = total;
        }
        //System.out.println(min);
        int result = 1000000;
        for(int i = 0; i < ncols * nrows; i++){
            if(estimate[i] - min < 30){
            int col = i % ncols + 1;
            int row = i / ncols + 1;
            int  minadd = 1000;
            if(knights.size() == 0)
                if((col + row - kcol - krow) % 2 ==0)
                    minadd = (Math.abs(col - kcol) + Math.abs(row - krow)) / 2 + Math.abs(Math.abs(col - kcol) - Math.abs(row - krow)) / 2;
                else
                    minadd = Math.min(Math.abs(col - kcol), Math.abs(row - krow)) + Math.abs(Math.abs(col - kcol) - Math.abs(row - krow));
            else{
            for(int knight : knights){
                for(int j = 1; j <= ncols; j++)
                    for (int k = 1; k <= nrows; k++){
                    int pos = (k - 1) * ncols + j - 1;
                        int hh = 0;
                        if((kcol + krow - j - k) % 2 ==0)
                            hh = (Math.abs(kcol - j) + Math.abs(krow - k)) / 2 + Math.abs(Math.abs(kcol - j) - Math.abs(krow - k)) / 2;
                        else
                            hh = Math.min(Math.abs(kcol - j), Math.abs(krow - k)) + Math.abs(Math.abs(kcol - j) - Math.abs(krow - k));
                        int add = hh + dis[knight][pos] + dis[i][pos] - dis[knight][i];
                        //if(add + estimate[i] == 10)
                           // System.out.println(col + " " + row + " " + j + " " + k + " " + hh);
                        if(add < minadd)
                            minadd = add;
                    }
            }}
            if(estimate[i] + minadd < result){
                result = estimate[i] + minadd;
            }
            }
        }
        out.println(result);                           // output result
        out.close();                                  // close the output file

    }
}
