/*
ID: jamesya4
LANG: JAVA
TASK: comehome
*/
import java.io.*;
import java.sql.Connection;
import java.util.*;

class comehome {
    private static int pastures = 0;
    private static ArrayList<connect>[] Connection;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int pathNum = Integer.parseInt(st.nextToken());
        Connection = new ArrayList[52];
        for (int i = 0; i < 52; i++)
            Connection[i] = new ArrayList<connect>();
        for (int i = 0; i < pathNum; i++) {
            st = new StringTokenizer(f.readLine());
            char start = st.nextToken().charAt(0);
            int index;
            if (Character.isUpperCase(start))
                index = start - 'A';
            else index = 26 + (start - 'a');
            char end = st.nextToken().charAt(0);
            int point;
            if (Character.isUpperCase(end))
                point = end - 'A';
            else point = 26 + (end - 'a');
            int distance = Integer.parseInt(st.nextToken());
            Connection[index].add(new connect(point, distance));
            Connection[point].add(new connect(index, distance));
        }
        for (int i = 0; i < 52; i++)
            if (Connection[i].size() != 0)
                pastures++;

        int[] result = search();


        out.print((char) ('A' + result[0]));
        out.println(" " + result[1]);                           // output result
        out.close();                                  // close the output file
    }

    private static int[] search() {
        int[] path = new int[52];
        boolean[] checked = new boolean[52];
        for (int i = 0; i < 52; i++)
            checked[i] = false;
        for (int i = 0; i < 52; i++)
            path[i] = 1000000;
        path[25] = 0;
        for (int i = 0; i < pastures; i++) {
            int min = 999999;
            int current = 0;
            for (int j = 0; j < 52; j++) {
                if (!checked[j])
                    if (path[j] < min) {
                        current = j;
                        min = path[j];
                    }
            }
            checked[current] = true;
            for (int j = 0; j < Connection[current].size(); j++) {
                int point = Connection[current].get(j).point;
                int distance = Connection[current].get(j).distace;
                if (path[point] > path[current] + distance)
                    path[point] = path[current] + distance;
            }
        }
        int[] result = new int[2];
        result[0] = 0;
        result[1] = 1000000;
        for (int i = 0; i < 25; i++) {
            if(path[i] < result[1]){
                result[0] = i;
                result[1] = path[i];
            }
        }
        return result;
    }
}
class connect{
    public int point;
    public int distace;
    public connect(int point, int distance){
        this.point = point;
        this.distace = distance;
    }
        }