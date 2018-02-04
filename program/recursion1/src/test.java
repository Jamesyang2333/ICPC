public class test
{
    public static void main(String[] args)
    {
        int [] a = {1,2,3,4};
        String b="";
        abc(a, b, 1);
    }
    public static void abc(int[] a, String b, int n)
    {
        String b1 = b;
        for (int i = 0; i < a.length; i++)
        {
            b1= (b == "" ? "" : b + " ") + a[i];
            if (n < a.length)
                abc(a, b1, n+1);
            else
                System.out.println(b1);
        }
    }

}
