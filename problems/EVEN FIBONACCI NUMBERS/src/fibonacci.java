public class fibonacci {
    private static int fibonacci(int x){
        if(x == 1)
            return 1;
        if(x == 2)
            return 2;
        int a = 1;
        int b = 2;
        int i=3;
        while(i<=x)
        {i++;
        int temp=b;
        b=a+b;
        a=temp;}
        return b;

    }
    public static void main(String[] args){

        long sum=0;
        int i=1;
        while(true){
            if(fibonacci(i) >= 4e6)
                break;
            if(fibonacci(i) % 2 == 0)
                sum += fibonacci(i);
          i++;
        }
        System.out.println(sum);
    }
}
