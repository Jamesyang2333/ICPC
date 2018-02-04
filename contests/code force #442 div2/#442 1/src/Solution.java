import java.util.Scanner;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] names = {"Danil", "Olya", "Slava", "Ann", "Nikita"};
        int count = 0;
        for(int i = 0; i < 5; i++){
            if (input.indexOf(names[i]) != -1) {
                count++;
                if(input.indexOf(names[i]) != input.lastIndexOf(names[i])){
                    count = 2;
                    break;
                }
            }
        }
        if(count == 1)
            System.out.println("YES");
        else System.out.println("NO");
    }
}