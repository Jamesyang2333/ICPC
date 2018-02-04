import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution1 {
    private static long[] segmentTree;
    private static long[] lazy;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("/Users/yangyang/Desktop/ICPC/101 hack 52/c/src/input05.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[1000001];
        for(int i = 0; i < 1000001; i++)
            visited[i] = false;
        int[] maxTo = new int[n];
        int pointer = 1;
        visited[numbers[0]] = true;
        for(int i = 0; i < n; i++){
            while(true){
                if(pointer == n || visited[numbers[pointer]]){
                    break;
                }
                else{
                    visited[numbers[pointer]] = true;
                    pointer++;
                }
            }
            maxTo[i] = pointer - 1;
            visited[numbers[i]] = false;
        }
        query[] allQueies = new query[q];
        for(int i = 0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            allQueies[i] = new query(i, left, right);
        }
        Arrays.sort(allQueies, new byLeft());
        int height = ((int)(Math.log(n) / Math.log(2) + 0.5)) + 1;
        int treeSize = (int)(Math.pow(2, height + 1) + 0.5);
        segmentTree = new long[treeSize];
        lazy = new long[treeSize];
        for(int i = 0; i < treeSize; i++)
            lazy[i] = 0;
        construct(1, 0, n - 1);
        int counter = q - 1;
        for(int i = n - 1; i >= 0; i--){
            rangeUpdate(1, 0, n - 1, i, maxTo[i]);
            while(allQueies[counter].left == i){
                allQueies[counter].setResult(rangequery(1, 0, n - 1, allQueies[counter].left, allQueies[counter].right));
                counter--;
                if(counter == -1)
                    break;
            }
            if(counter == -1)
                break;
        }
        Arrays.sort(allQueies);
        for(int i = 0; i < q; i++){
            System.out.println(allQueies[i].result);
        }
    }
    public static void construct(int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = 0;
            return;
        } else {
            int mid = (start + end) / 2;
            construct(node * 2, start, mid);
            construct(node * 2 + 1, mid + 1, end);
        }
    }
    private static long rangequery(int node, int start, int end, int left, int right){
        if(lazy[node] != 0){
            segmentTree[node] += lazy[node] * (end - start + 1);
            if(start != end){
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(start > right || end < left)
            return 0;
        if(start >= left && end <= right)
            return segmentTree[node];
        int mid = (start + end) / 2;
        return rangequery(node * 2, start, mid, left, right) + rangequery(node * 2 + 1, mid + 1, end, left, right);
    }
    private static void rangeUpdate(int node, int start, int end, int left, int right){
        if(lazy[node] != 0){
            segmentTree[node] += lazy[node] * (end - start + 1);
            if(start != end){
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
        if(start > right || end < left)
            return;
        if(start >= left && end <= right){
            segmentTree[node] += (end - start + 1);
            if(start != end){
                lazy[node * 2] += 1;
                lazy[node * 2 + 1] += 1;
            }
            return;
        }
        int mid = (start + end) / 2;
        rangeUpdate(node * 2, start, mid, left, right);
        rangeUpdate(node * 2 + 1, mid + 1, end, left, right) ;
        segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
    }
}
class query implements Comparable<query>{
    int index;
    int left;
    int right;
    long result;
    public query(int index, int left, int right){
        this.index = index;
        this.left = left;
        this.right = right;
    }
    public void setResult(long result){
        this.result = result;
    }
    public int compareTo(query a){
        return index - a.index;
    }
}
class byLeft implements Comparator<query>{
    public int compare(query a, query b){
        return a.left - b.left;
    }
}