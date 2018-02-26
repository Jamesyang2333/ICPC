class Solution {
    private final int divisor = 1000000007;
    private long[] A;
    private long[] B;
    private long[] C;
    public int numTilings(int N) {
        A = new long[N + 1];
        B = new long[N];
        C = new long[N];
        for(int i = 0; i < N; i++){
            A[i] = -1;
            B[i] = -1;
            C[i] = -1;
        }
        A[N] = -1;
        A[0] = 1;
        A[1] = 1;
        B[0] = 0;
        C[0] = 0;
        return (int)searchA(N);
    }
    private long searchA(int n){
        if(A[n] != -1)
            return A[n];
        else {
            A[n] = (((searchA(n - 1) + searchA(n - 2)) % divisor + (searchB(n - 2) + searchC(n - 2)) % divisor) % divisor);
            return A[n];
        }
    }
    private long searchB(int n){
        if(B[n] != -1)
            return B[n];
        else{
            B[n] = (searchA(n - 1) + searchC(n - 1)) % divisor;
            return B[n];
        }
    }
    private long searchC(int n){
        if(C[n] != -1)
            return C[n];
        else {
            C[n] = (searchA(n - 1) + searchB(n - 1)) % divisor;
            return C[n];
        }
    }

}