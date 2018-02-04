class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lar = Math.max(m,n);
        int min = m+n-lar;
        int count = 0;
        int a=1;
        int b=1;
        if(k==1) return 1;
        int num;
        for(int i = 3;i<=60000;i++){
            if(i<=min+1){
                a=i-1;
                b=1;
                num = i-1;
                count++;
            }
            else{
                a=min;
                b=i-min;
                num = min;
                count++;
            }
            for(int j=2;j<=min;j++)
            {

            }
        }
        return  a*b;
    }
}