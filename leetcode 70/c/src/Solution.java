import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.util.ArrayList;

public class Solution {
    public boolean canTransform(String start, String end) {
        ArrayList<Integer> inir = new ArrayList<>();
        ArrayList<Integer> inil = new ArrayList<>();
        ArrayList<Integer> finr = new ArrayList<>();
        ArrayList<Integer> finl = new ArrayList<>();
        int len1 = start.length();
        int len2 = end.length();
        if(len1 != len2)
            return false;
        for(int i = 0; i < len1; i++){
            if(start.charAt(i) == 'R')
                inir.add(i);
            if(start.charAt(i) == 'L')
                inil.add(i);
            if(end.charAt(i) == 'R')
                finr.add(i);
            if(end.charAt(i) == 'L')
                finl.add(i);
        }
        if(inir.size() != finr.size() || inil.size() != finl.size())
            return false;
        else{
            int len = inir.size();
            for(int i = 0; i < len; i++){
                if(inir.get(i) > finr.get(i))
                    return false;
            }
            len = inil.size();
            for(int i = 0; i < len; i++){
                if(inil.get(i) < finl.get(i))
                    return false;
            }
            return true;
        }
    }
}
