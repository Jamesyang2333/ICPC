import java.util.Scanner;

public class Solution {
    public static int[] entries;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        entries = new int[25];
        boolean[] finishedSurfaces = new boolean[6];
        for(int i = 0; i < 6; i++)
            finishedSurfaces[i] = false;
        for(int i = 1; i <= 24; i++){
            entries[i] = sc.nextInt();
        }
        for(int i = 1; i <= 21; i += 4){
            if(equal(i, i + 1, i + 2,  i + 3)) finishedSurfaces[(i - 1) / 4] = true;
        }
        boolean result = false;
        if((finishedSurfaces[0] && finishedSurfaces[2]) || (finishedSurfaces[1] && finishedSurfaces[5]) || (finishedSurfaces[3] && finishedSurfaces[4])){
            if(finishedSurfaces[0] && finishedSurfaces[2]){
                if (equal(5, 6, 19, 20) && equal(13, 14, 7, 8) && equal(17, 18, 23, 24)) {
                    result = true;
                }
                else if(equal(5, 6, 15, 16) && equal(17, 18, 7, 8) && equal(19, 20, 21, 22))
                    result = true;
            }
            if(finishedSurfaces[1] && finishedSurfaces[5]){
                if (equal(3, 4, 18, 20) && equal(17, 19, 11, 12) && equal(9, 10, 13, 15)) {
                    result = true;
                }
                else if(equal(3, 4, 13, 15) && equal(14, 16, 11, 12) && equal(9, 10, 18, 20))
                    result = true;
            }
            if(finishedSurfaces[3] && finishedSurfaces[4]){
                if (equal(1, 3, 6, 8) && equal(5, 7, 10, 12) && equal(9, 11, 23, 21)) {
                    result = true;
                }
                else if(equal(5, 7, 2, 4) && equal(9, 11, 6, 8) && equal(1, 3, 21, 23))
                    result = true;
            }
        }
        if(result)
            System.out.println("YES");
        else System.out.println("NO");
    }
    private static boolean equal(int a, int b, int c, int d){
        return ((entries[a] == entries[b]) && (entries[a] == entries[c]) && (entries[a] == entries[d]));


    }
}

