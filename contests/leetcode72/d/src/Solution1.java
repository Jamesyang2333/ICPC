import java.io.IOException;
import java.util.PriorityQueue;

//Oh man, you've seen this trick of maintain a sorted list of priority queue before
public class Solution1 {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<fraction> smallestset = new PriorityQueue<>();
        int n = A.length;
        for(int i = 0; i < n - 1; i++){
            smallestset.add(new fraction(A[i], A[n - 1], n - 1));
        }
        fraction result = null;
        for(int i = 0; i < K; i++){
            result = smallestset.poll();
            if(i == K - 1)
                break;
            if(A[result.denoindex - 1] > result.nume){
                smallestset.add(new fraction(result.nume, A[result.denoindex - 1], result.denoindex - 1));
            }
        }
        int[] answer = new int[2];
        answer[0] = result.nume;
        answer[1] = result.deno;
        return answer;
    }
    public static void main(String[] args) throws IOException{
        Solution1 test = new Solution1();
        int[] A = {1, 2, 3, 5};
        System.out.println(test.kthSmallestPrimeFraction(A, 3)[0] + " " + test.kthSmallestPrimeFraction(A, 3)[1]);
    }
}
class fraction implements Comparable<fraction>{
    int nume;
    int deno;
    int denoindex;
    public fraction(int nume, int deno, int denoindex){
        this.nume = nume;
        this.deno = deno;
        this.denoindex = denoindex;
    }

    @Override
    public int compareTo(fraction o) {
        return (nume * o.deno - deno * o.nume);
    }
}
