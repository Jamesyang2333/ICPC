import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int count = 0;
        int counter = 0;
        int[] sortedarr = arr.clone();
        Arrays.sort(sortedarr);
        while(counter < len){
            if(arr[counter] == sortedarr[counter]){
                count++;
                counter++;
            }
            else {
                int max = -1;
                boolean found = false;
                for(int i = counter; i < len; i++){
                    if(arr[i] > max){
                        int pos = Arrays.binarySearch(sortedarr, arr[i]);
                        for(int j = pos - 1; j >= 0; j--){
                            if(sortedarr[j] != arr[i]){
                                pos = j + 1;
                                break;
                            }}
                        while(true){
                            if(sortedarr[pos] != arr[i])
                                break;
                        if(check(counter, pos, arr, sortedarr)){
                            count++;
                            counter = pos + 1;
                            found = true;
                            break;
                        }
                        else{
                            pos++;
                            max = arr[i];
                        }
                        }
                    }
                    if(found)
                        break;
                }
            }
        }
        return count;
    }
    private boolean check (int start, int end, int[] arr, int[] sortedarr){
        ArrayList<Integer> sequence = new ArrayList<>();
        for(int i = start; i <= end; i++){
            sequence.add(arr[i]);
        }
        Collections.sort(sequence);
        for(int i = start; i <= end; i++)
            if(sequence.get(i - start) != sortedarr[i])
                return false;
        return true;
    }
    public static void main(String[] args){
        int[] sample = {1, 0, 1, 3, 2};
        Solution test = new Solution();
        System.out.println(test.maxChunksToSorted(sample));
    }
}