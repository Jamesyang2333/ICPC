public class solution {
    private static int n = 4;
    private static int[] a = {1, 2, 4, 7};
    private static int k = 13;
    private static int sum = 0;
    private static boolean result = false;
    public static void main(String[] args){
        find(0);
        System.out.println(result);

    }
    private static void find(int i){
        if(i == n - 1){
            if(sum + a[i] == k)
                result = true;
            return;
        }
        if (sum + a[i] == k) {
            result = true;
            return;
        }
        find(i + 1);
        sum += a[i];
        find(i + 1);
        sum -= a[i];

    }

}
