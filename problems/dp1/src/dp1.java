public class dp1 {
    int[][] dic;
    public dp1(int n,int k){
        dic = new int[n+1][k+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=k;j++)
                dic[i][j]=-1;
    }
    public int bino1(int n,int k){
        if(k == 0)
        {dic[n][k] = 1;
        return 1;}
        if(n==0 && k>0)
        { dic[n][k] = 0;
        return 0;}
        if(dic[n-1][k-1] == -1){
            dic[n-1][k-1] = bino1(n-1,k-1);
        }
        if(dic[n-1][k]== -1){
            dic[n-1][k] = bino1(n-1,k);
        }
        return dic[n-1][k-1]+dic[n-1][k];
    }
    public int bino2(int n, int k){
        for(int i = 0;i<=n;i++)
            dic[i][0] = 1;
        for(int i = 1; i<=k;i++)
            dic[0][i] = 0;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= k; j++)
                dic[i][j] = dic[i-1][j-1] + dic[i-1][j];
        return dic[n][k];
    }
    public int bino3(int n, int k){
        if(n>=k){
            for(int i=0;i<=n-k; i++)
                dic[i][0] = 1;
            for(int i = 1; i <= k;i++)
                dic[0][i] = 0;
            for(int i=1; i<=n-k; i++)
                for(int j = 1; j <= k; j++)
                    dic[i][j] = dic[i-1][j-1] + dic[i-1][j];
            for(int i = n-k+1; i<=n;i++)
                for(int j = i-(n-k); j<=k; j++)
                    dic[i][j] = dic[i-1][j-1] + dic[i-1][j];
            return dic[n][k];

        }
        else return 0;

            }
}
