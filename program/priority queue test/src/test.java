import java.util.PriorityQueue;
public class test {
    public static void main(String[] args){
        PriorityQueue<Integer> test = new PriorityQueue<>(3);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        System.out.println(test.size());
        System.out.println(test.poll());
    }
}
