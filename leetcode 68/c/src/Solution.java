class Solution {
    public int maxChunksToSorted(int[] arr) {
        int len = arr.length;
        int count = 0;
        int counter = 0;
        while(counter < len){
            if(arr[counter] == counter){
                count++;
                counter++;
            }
            else {
                int max = 0;
                for(int i = counter; i < len; i++){
                    if(arr[i] > max){
                        if(check(counter, arr[i], arr)){
                            count++;
                            counter = arr[i] + 1;
                            break;
                        }
                        else{
                            max = arr[i];
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean check (int start, int end, int[] arr){
        for(int i = start; i <= end; i++){
            if(arr[i] < start || arr[i] > end)
                return false;
        }
        return true;
    }
    public static void main(String[] args){
        int[] sample = {1, 0, 2, 3, 4};
        Solution test = new Solution();
        System.out.println(test.maxChunksToSorted(sample));
    }
}