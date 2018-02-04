/*
ID: jamesya4
LANG: JAVA
TASK: heritage
*/
import java.io.*;
import java.util.*;

class heritage {
    private static char[] inOrderSequence;
    private static char[] preOrderSequence;
    private static int[] place;
    private static PrintWriter out;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("heritage.in"));
        // input file name goes above
        out = new PrintWriter(new BufferedWriter(new FileWriter("heritage.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        String inorder = st.nextToken();
        inOrderSequence = inorder.toCharArray();
        st = new StringTokenizer(f.readLine());
        String preorder = st.nextToken();
        preOrderSequence = preorder.toCharArray();
        int length = preorder.length();
        place = new int[length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                if(inOrderSequence[j] == preOrderSequence[i])
                    place[i] = j;
            }
        }
        postOrder(0, 0, length - 1);
        out.println();
        out.close();                                  // close the output file
    }
    private static void postOrder(int pos, int start, int end){
        if(start < place[pos]){
            postOrder(pos + 1, start, place[pos] - 1);
        }
        if(end > place[pos]){
            postOrder(pos + place[pos] - start + 1, place[pos] + 1, end);
        }
        out.print(preOrderSequence[pos]);
    }
}
