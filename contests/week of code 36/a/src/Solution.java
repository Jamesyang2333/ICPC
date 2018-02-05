import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String acidNaming(String acid_name) {
        // Complete this function
        if(isacid(acid_name)){
            if(isnonmetal(acid_name))
                return "non-metal acid";
            else return "polyatomic acid";
        }
        else return "not an acid";

    }
    static boolean isnonmetal(String a){
        String prex = "hydro";
        if(a.length() < 5)
            return false;
        else{
            if (a.substring(0, 5).equals(prex))
                return true;
            else return false;
        }
    }
    static boolean isacid(String a){
        String sux = "ic";
        if(a.length() < 2)
            return false;
        else {
            if(sux.equals(a.substring(a.length() - 2)))
                return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String acid_name = in.next();
            String result = acidNaming(acid_name);
            System.out.println(result);
        }
        in.close();
    }
}
