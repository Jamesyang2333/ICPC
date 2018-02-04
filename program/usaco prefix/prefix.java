/*
ID: jamesya4
LANG: JAVA
TASK: prefix
*/
import java.io.*;
import java.util.*;

class prefix {
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        String a;
        HashSet<String> primitives = new HashSet<>();
        int maxPriLength = 0;
        while(true){
            if((a = st.nextToken()).equals("."))
                break;
            maxPriLength = Math.max(maxPriLength, a.length());
            primitives.add(a);
            while(st.hasMoreTokens()){
                a = st.nextToken();
                maxPriLength = Math.max(maxPriLength, a.length());
                primitives.add(a);
            }
            st = new StringTokenizer(f.readLine());
        }
        StringBuilder sequence = new StringBuilder();
        String line;
        while((line = f.readLine()) != null){
            sequence.append(line);
        }
        String structure = sequence.toString();
        int length = structure.length();
        boolean[] can = new boolean[length];
        for(int i = 0; i < length; i++)
            can[i] = false;
        int count = 0;
        if(primitives.contains(structure.substring(0,1))) {
            can[0] = true;
        }
        if(!can[0]) count++;
        for(int i = 1; i < maxPriLength; i++){
            if(primitives.contains(structure.substring(0, i + 1))) {
                can[i] = true;
            }
            for(int j = 1; j <= i; j++){
                if(primitives.contains(structure.substring(j, i + 1)))
                    can[i] = true && can[j - 1];
            }
            if(can[i])
                count = 0;
            else count++;
        }
        if(count == maxPriLength)
            out.println(0);
        else{
            for(int i = maxPriLength; i < length; i++){
                for(int j = 1; j <= maxPriLength; j++){
                    if(primitives.contains(structure.substring(i + 1 - j,i + 1))) {
                        can[i] = true && can[i - j];
                        if(can[i])
                            break;
                    }
            }
            if(can[i])
                count = 0;
                else{
                    count++;
                    if(count == maxPriLength){
                        out.println(i - maxPriLength + 1);
                        break;
                    }
            }
            if((i == length - 1) && (count != maxPriLength))
                out.println(i - count + 1);
        }
        }
        out.close();                                  // close the output file
    }
}
