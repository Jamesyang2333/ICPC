public class probem3 {
    public static void main(String[] args){
        int max = 1;
        long x=6008514751543l;
        for(int i=1;i<=Math.sqrt(x);i++) {
            if (6008514751543l % i == 0) {
                if (isPrime(i))
                    max = Math.max(i, max);
                if (isPrime((int)(600851451543l/i)))
                    max = Math.max(max,(int)(600851451543l/i));

        }
        }
        System.out.println(max);

    }
    private static boolean isPrime(int n){
        boolean prime = true;
        for(int i = 2; i <= Math.sqrt(n) ;i++ )
            if(n%i == 0)
                prime = false;
        return prime;
    }
}
