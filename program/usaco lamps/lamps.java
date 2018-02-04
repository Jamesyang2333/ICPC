/*
ID: jamesya4
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.*;

class lamps {
    private static int count;
    private static ArrayList<boolean[]> result = new ArrayList<>();
    private static ArrayList<Integer> on;
    private static ArrayList<Integer> off;
    private static int n;
    private static boolean[] ini;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        count = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        on = new ArrayList<>();
        off = new ArrayList<>();
        ini = new boolean[n];
        for(int i = 0; i < n; i++)
            ini[i] = true;
        int x;
        while((x = Integer.parseInt(st.nextToken())) != -1)
            on.add(x);
        st = new StringTokenizer(f.readLine());
        while((x = Integer.parseInt(st.nextToken())) != -1)
            off.add(x);
        if(count <= 1)
            find(count);
        else if(count == 2){
            find(0);
            find(2);
        }
        else if(count % 2 == 0){
            find(2);
            find(0);
            find(4);
        }
        else{
            find(1);
            find(3);
        }
        int numResult = result.size();
        if(numResult == 0){
            out.println("IMPOSSIBLE");
        }else{
        boolean[][] result1 = new boolean[numResult][n];
        for(int i = 0; i < numResult; i++)
            result1[i] = result.get(i);
        bybin com = new bybin();
        Arrays.sort(result1, com);
        for(int i = 0; i < numResult; i++){
            for(int j = 0; j < n; j++){
                if(result1[i][j])
                    out.print(1);
                else out.print(0);
            }
            out.println();
        }
        }
        out.close();                                  // close the output file
    }
    private static boolean[] change(int a, boolean[] old){
        boolean[] result = old.clone();
        if(a == 1){
            for(int i = 0; i < n; i++)
                result[i] = !result[i];
            return result;
        }
        if(a == 2){
            for(int i = 0; i < n; i += 2){
                result[i] = !result[i];
            }
            return result;
        }
        if(a == 3){
            for(int i = 1; i < n; i += 2){
                result[i] = !result[i];
            }
            return result;
        }
        if(a == 4){
            for(int i = 0; i < n; i += 3){
                result[i] = !result[i];
            }
            return result;
        }
        return null;
    }
    private static boolean check(boolean[] state){
        if(on.size() > 0)
            for(int i = 0; i < on.size(); i++){
            if(state[on.get(i) - 1] == false)
                return false;
        }
        if(off.size() > 0)
        for(int i = 0; i < off.size(); i++){
            if(state[off.get(i) - 1] == true)
                return false;
        }
        return true;
    }
    private static void find(int x){
        if(x == 0){
            boolean[] a = ini.clone();
            if(check(a))
                if(!result.contains(a))
                    result.add(a);
        }
        if(x == 1){
            for(int i = 1; i <= 4; i++){
                boolean[] a = change(i, ini);
                if(check(a))
                    if(!result.contains(a))
                        result.add(a);
            }
        }
        if(x == 2){
            for(int i = 1; i <=4; i++){
                for(int j = i + 1; j <= 4; j++){
                    boolean[] a = change(j, change(i, ini));
                    if(check(a))
                        if(!result.contains(a))
                            result.add(a);
                }
            }
        }
        if(x == 3){
            for(int i = 1; i <= 4; i++)
                for(int j = i + 1; j <= 4; j++)
                    for(int k = j + 1; k <= 4; k++){
                        boolean[] a = change(k, change(j, change(i, ini)));
                        if(check(a))
                            if(!result.contains(a))
                                result.add(a);
                    }
        }
        if(x == 4){
            boolean[] a = change(4, ini);
        if(check(a))
            if(!result.contains(a))
                result.add(a);
        }
    }
}
class bybin implements Comparator<boolean[]>{
    public int compare(boolean[] a, boolean[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] ^ b[i])
                if(a[i])
                    return 1;
            else return -1;
        }
        return 0;
    }
}
