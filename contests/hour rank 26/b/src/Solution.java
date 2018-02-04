//This solution got TLE for some large cases
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int n;
    private static int m;
    static long maximumPeople(long[] p, long[] x, long[] y, long[] r) {
        // Return the maximum number of people that will be in a sunny town after removing exactly one cloud.
        city[] allCity = new city[n];
        for(int i = 0; i < n; i++)
            allCity[i] = new city(p[i], x[i]);
        Arrays.sort(allCity);
        for(int i = 0; i < m; i++){
            long start = y[i] - r[i];
            long end = y[i] + r[i];
            int startindex = Arrays.binarySearch(allCity, new city(0, start));
            if(startindex < 0)
                startindex = - startindex - 1;
            else{
                long value = allCity[startindex].loc;
                while(true){
                    startindex--;
                    if(startindex < 0)
                        break;
                    if(allCity[startindex].loc != value)
                        break;
                }
                startindex++;
            }
            int endindex = Arrays.binarySearch(allCity, new city(0, end));
            if(endindex < 0)
                endindex = -endindex - 2;
            else{
                long value = allCity[endindex].loc;
                while(true){
                    endindex++;
                    if(endindex >= n)
                        break;
                    if(allCity[endindex].loc != value)
                        break;
                }
                endindex--;
            }
            for(int j = startindex; j <= endindex; j++){
                if(j >= n)
                    break;
                allCity[j].clouds.add(i);
            }
        }
        int prev = -1;
        long sunny = 0;
        long max = 0;
        long accu = 0;
        for(int i = 0; i < n; i++){
            if(allCity[i].clouds.size() == 0)
                sunny += allCity[i].population;
            if(allCity[i].clouds.size() == 1){
                if(allCity[i].clouds.get(0) == prev){
                    accu += allCity[i].population;
                    if(accu > max)
                        max = accu;
                }
                else {
                    accu = allCity[i].population;
                    prev = allCity[i].clouds.get(0);
                    if(accu > max)
                        max = accu;
                }
            }
        }
        return max + sunny;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        long[] p = new long[n];
        for(int p_i = 0; p_i < n; p_i++){
            p[p_i] = in.nextLong();
        }
        long[] x = new long[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextLong();
        }
        m = in.nextInt();
        long[] y = new long[m];
        for(int y_i = 0; y_i < m; y_i++){
            y[y_i] = in.nextLong();
        }
        long[] r = new long[m];
        for(int r_i = 0; r_i < m; r_i++){
            r[r_i] = in.nextLong();
        }
        long result = maximumPeople(p, x, y, r);
        System.out.println(result);
        in.close();
    }
}
class city implements Comparable<city>{
    long population;
    long loc;
    ArrayList<Integer> clouds;
    public city(long population, long loc){
        this.population = population;
        this.loc = loc;
        clouds = new ArrayList<>();
    }
    public int compareTo(city a){
        if(loc > a.loc)
            return 1;
        else if(loc == a.loc)
            return 0;
        else return -1;
    }
}