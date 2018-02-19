import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        int len = A.length;
        int nfrac = len * (len - 1) / 2;
        ArrayList<frac> allfrac = new ArrayList<>();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                allfrac.add(new frac(A[i], A[j]));
            }
        }
        Collections.sort(allfrac);
        frac result = allfrac.get(K - 1);
        int[] answer = new int[2];
        answer[0] = result.nume;
        answer[1] = result.deno;
        return answer;
    }
}
class frac implements Comparable<frac>{
    int nume;
    int deno;
    public frac(int nume, int deno){
        this.nume = nume;
        this.deno = deno;
    }
    public int compareTo(frac b){
        return nume * b.deno - deno * b.nume;
    }
}