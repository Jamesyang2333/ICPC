class Solution1 {
    public int bestRotation(int[] A) {
        int len = A.length;
        int[] prefixes = new int[len];
        for(int i = 0; i < len; i++){
            if(A[i] == 0){
                prefixes[0]++;
                continue;
            }
            if(A[i] <= i){
                int maxrotate = i - A[i];
                prefixes[0]++;
                if(maxrotate + 1 < len)
                    prefixes[maxrotate + 1]--;
                if(i + 1 < len)
                    prefixes[i + 1]++;
            }
            else{
                int tolast = i + 1 + len - 1 - A[i];
                prefixes[i + 1]++;
                if(tolast + 1 < len)
                    prefixes[tolast + 1]--;
            }
        }
        int accu = 0;
        int max = -1;
        int result = 0;
        for(int i = 0; i < len; i++){
            accu += prefixes[i];
            if(accu > max){
                max = accu;
                result = i;
            }
        }
        return result;
    }
}