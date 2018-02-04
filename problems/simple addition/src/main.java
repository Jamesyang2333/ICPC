import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int length = Math.max(a.length(), b.length()) + 1;
        char[] num1;
        char[] num2;
        if(a.length() >= b.length()){
            num1 = a.toCharArray();
            num2 = b.toCharArray();
        }
        else{
            num1 = b.toCharArray();
            num2 = a.toCharArray();
        }
        int len1 = num1.length;
        int len2 = num2.length;
        int[] result = new int[length];
        int carry = 0;
        for(int i = 0; i < length - 1; i++){
            if(i < len2){
                result[length - 1 - i] = (Character.getNumericValue(num1[len1 - 1 - i]) + Character.getNumericValue(num2[len2 - 1 - i]) + carry) % 10;
                carry = (Character.getNumericValue(num1[len1 - 1 - i]) + Character.getNumericValue(num2[len2 - 1 - i]) + carry) / 10;
            }
            else{
                result[length - 1 - i] = (Character.getNumericValue(num1[len1 - 1 - i]) + carry) % 10;
                carry = (Character.getNumericValue(num1[len1 - 1 - i]) + carry) / 10;
            }
        }
        if(carry == 1){
            result[0] = 1;
            for(int i = 0; i < length; i++)
                System.out.print(result[i]);
            System.out.println();
        }
        else{
            for(int i = 1; i < length; i++)
                System.out.print(result[i]);
            System.out.println();
        }
        }


    }

