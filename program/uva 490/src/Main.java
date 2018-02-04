import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> content = new ArrayList<>();
        int max = 0;
        while(sc.hasNextLine()) {
            String x =sc.nextLine();
            if(max<x.length())
                max=x.length();
            content.add(x);
        }
        for(int i=0;i<max;i++){
            for(int j=content.size()-1;j>=0;j--){
                if(i<content.get(j).length())
                    System.out.print(content.get(j).charAt(i));
                else System.out.print(" ");
            }
            System.out.println("");
        }


    }
}
