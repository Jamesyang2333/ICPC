import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 2){
            System.out.println(3);
            System.out.println("2 1 2");
        }
        else if (n % 2 == 0){
            System.out.println(3 * (n / 2));
            for(int i = 1; i < n; i += 2){
                System.out.print(i + " ");
            }
            for(int i = 2; i <= n; i += 2){
                System.out.print(i + " ");
            }
            for(int i = 1; i < n - 1; i += 2){
                System.out.print(i + " ");
            }
            System.out.println(n - 1);
        }
        else{
            System.out.println((n + 1) / 2 + n - 1);
            for(int i = 2; i < n; i += 2){
                System.out.print(i + " ");
            }
            for(int i = 1; i <= n; i += 2){
                System.out.print(i + " ");
            }
            for(int i = 2; i < n - 1; i += 2){
                System.out.print(i + " ");
            }
            System.out.println(n - 1);
        }
    }
}
