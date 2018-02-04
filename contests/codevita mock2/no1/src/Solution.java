import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i = 1; i <= n; i++){
            for(int j = i; j < n; j++)
                System.out.print(" ");
            for(int j = 1; j <= i; j++){
                int next = 8 * count * count + 14 * count + 6;
                count++;
                System.out.format("%05d", next);
                if(j == i)
                {if(i != n)
                    System.out.println();}
                else System.out.print(" ");
            }
        }
    }
}
