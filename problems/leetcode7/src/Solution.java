class Solution {
        public int reverse(int x) {
            boolean positive = true;
            if(x < 0) {
                positive = false;
                x = -x;
            }
            int n = 0;
            byte[] sequence = new byte[12];
            while(x > 0){
                sequence[n] = (byte)(x % 10);
                n++;
                x = x / 10;
            }
            long result = 0;
            for(int i = 0;i < n; i++){

                result += sequence[i] * Math.pow(10,n-1-i);
            }
            if(result > Math.pow(2,31))
                return 0;
            if(positive)
                return (int)result;
            else
                return -(int)result;

        }
    }

