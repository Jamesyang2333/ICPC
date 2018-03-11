import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int[] max = new int[100];
        for(int i = 0; i < 100; i++){
            max[i] = (i + 1) * (i + 2) / 2;
        }
        if(poured == 0)
            return 0;
        int index = Arrays.binarySearch(max, poured);
        if(index < 0){
            index = -index - 1;
            if(query_row < index)
                return 1;
            else if(query_row > index)
                return 0;
            else {
                return ((double)(poured - max[index - 1])) / (query_row + 1);
            }
        }
        else{
            if(index == 100)
                return 1;
            else{
                if(query_row <= index)
                    return 1;
                else return 0;
            }
        }
    }
}