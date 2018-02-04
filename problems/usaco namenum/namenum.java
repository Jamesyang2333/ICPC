/*
ID: jamesya4
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;
import java.util.HashSet;
class namenum {
    public static String[] letters = {"ABC","DEF","GHI","JKL","MNO","PRS","TUV","WXY"};
    public static HashSet<String> dict = new HashSet<>(5000);
    public static String num;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        num = st.nextToken();
        f = new BufferedReader(new FileReader("dict.txt"));
        String a;
        while((a = f.readLine()) != null) {
            st = new StringTokenizer(a);
            dict.add(st.nextToken());
        }
        ArrayList<String> result = new ArrayList<>();
        int len = num.length();
        String word = "";
        find(result, word, len-1);
        int h = result.size();
        if(h == 0)
            out.println("NONE");
        else
        for(int i = 0; i < h; i++){
            out.println(result.get(i));
        }

        out.close();                                  // close the output file
    }
    private static void find(ArrayList<String> result, String word,int n){
        for(int i = 0; i < 3; i++){
            word += letters[Character.getNumericValue(num.charAt(num.length()-1-n)) - 2].charAt(i);
            if(n == 0){
                if(dict.contains(word))
                    result.add(word);
            }else{
                find(result, word, n-1);
            }
            word = word.substring(0, word.length() - 1);
        }
    }
}
