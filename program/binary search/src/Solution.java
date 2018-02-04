import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] arr;
    private static int target;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int result = bsearch(0, n - 1);
        System.out.println(result);
    }
    private static int bsearch(int start, int end){
        if(start == end)
            return start;
        else{
            int mid = (start + end) / 2;
            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target)
                return bsearch(mid + 1, end);
            else return bsearch(start, mid - 1);
        }
    }
}
