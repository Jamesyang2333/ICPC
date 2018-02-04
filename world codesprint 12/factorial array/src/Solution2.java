import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//This solution uses segment tree
public class Solution2 {
    private static long[] dp;
    private static long[] sequence;
    private static segmentNode[] facSum;
    public static void main(String[] args) throws IOException{
        dp = new long[40];
        dp[1] = 1;
        for(int i = 2; i < 40; i++){
            dp[i] = (i * dp[i - 1]) % 1000000000;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sequence = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            sequence[i] = Long.parseLong(st.nextToken());
        facSum = new segmentNode[3 * n];
        build(1, 0, n - 1);
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if(operation == 1){
                add(1, 0, n - 1, l - 1, r - 1);
            }
            else if(operation == 2){
                System.out.println(query(1, 0, n - 1, l - 1, r - 1));
            }
            else{
                update(1, 0, n - 1, l - 1, r);
            }
        }
    }
    private static void update(int node, int start, int end, int index, int val){
        if(start == end){
            sequence[index] = val;
            facSum[node].facsum = fac(sequence[index]);
            if(val >= 40)
                facSum[node].isZero = true;
            else
                facSum[node].isZero = false;
        }
        else{
            int mid = (start + end) / 2;
            if(index <= mid){
                update(node * 2, start, mid, index, val);
            }
            else update(node * 2 + 1, mid + 1, end, index, val);
            facSum[node].facsum = (facSum[2 * node].facsum + facSum[2 * node + 1].facsum) % 1000000000;
            facSum[node].isZero = facSum[2 * node].isZero && facSum[2 * node + 1].isZero;
        }
    }
    private static long query(int node, int start, int end, int left, int right){
        if(facSum[node].isZero)
            return 0;
        if(start > right || end < left)
            return 0;
        if(start >= left && end <= right)
            return facSum[node].facsum;
        int mid = (start + end) / 2;
        long leftResult = query(node * 2, start, mid, left, right);
        long rightResult = query(node * 2 + 1, mid + 1, end, left, right);
        return (leftResult + rightResult) % 1000000000;
    }
    private static void add(int node, int start, int end, int startIndex, int endIndex){
        if(facSum[node].isZero)
            return;
        if(start == end){
            if(start >= startIndex && start <= endIndex){
                sequence[start] += 1;
                facSum[node].facsum = fac(sequence[start]);
                if(sequence[start] >= 40)
                    facSum[node].isZero = true;
                else facSum[node].isZero = false;
            }
        }
        else{
            if(start > endIndex || end < startIndex)
                return;
            int mid = (start + end) / 2;
            add(2 * node, start, mid, startIndex, endIndex);
            add(2 * node + 1, mid + 1, end, startIndex, endIndex);
            facSum[node].facsum = (facSum[2 * node].facsum + facSum[2 * node + 1].facsum) % 1000000000;
            facSum[node].isZero = (facSum[2 * node].isZero) && (facSum[2 * node + 1].isZero);
        }
    }
    private static void build(int node, int start, int end){
        if(start == end){
            if(sequence[start] >= 40)
                facSum[node] = new segmentNode(0, true);
            else
                facSum[node] = new segmentNode(fac(sequence[start]), false);
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);
        boolean isZero = facSum[node * 2].isZero && facSum[node * 2 + 1].isZero;
        if(isZero)
            facSum[node] = new segmentNode(0, true);
        else
            facSum[node] = new segmentNode((facSum[2 * node].facsum + facSum[2 * node + 1].facsum) % 1000000000, false);
    }
    private static long fac(long a){
        if(a >= 40)
            return 0;
        else return dp[(int)a];
    }
}
class segmentNode{
    long facsum;
    boolean isZero;
    public segmentNode(long facsum, boolean isZero){
        this.facsum = facsum;
        this.isZero = isZero;
    }
}
