public class test {
    public static void main(String[] args){
        dp1 test = new dp1(40,20);
        long startTime = System.nanoTime();
        int result = test.bino1(40,20);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.println("Time usage is: " + (endTime - startTime));


    }
}
