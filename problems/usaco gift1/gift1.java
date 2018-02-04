/*
ID: jamesya4
LANG: JAVA
PROB: gift1
*/
import java.io.*;
import java.util.*;
import java.util.HashMap;
class gift1 {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> money = new HashMap<String, Integer>();
        String[] names = new String[n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(f.readLine());
            String name = st.nextToken();
            names[i] = name;
            money.put(name,0);
        }
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(f.readLine());
            String name = st.nextToken();
            st = new StringTokenizer(f.readLine());
            int ini = Integer.parseInt(st.nextToken());
            int split_num = Integer.parseInt(st.nextToken());
            if(split_num != 0){
            int split = ini / split_num;
            int left = ini - split * split_num;
            money.put(name,money.get(name)+left - ini);
            for(int j = 0; j < split_num; j++){
                st = new StringTokenizer(f.readLine());
                String split_name = st.nextToken();
                money.put(split_name, money.get(split_name) + split);
            }
        }
    }
        for(int i = 0; i < n; i++){
        out.print(names[i] + " "); 
        out.println(money.get(names[i]));
    }
                                  // output result
        out.close();                                  // close the output file
    }
}
