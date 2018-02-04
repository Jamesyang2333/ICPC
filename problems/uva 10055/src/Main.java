import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        ArrayList<Long> result = new ArrayList<Long>();
        Scanner sc = new Scanner(System.in);
        //try{
            while(sc.hasNext()) {
            long a = Long.parseLong(sc.next());
            long b = Long.parseLong(sc.next());
            result.add(Math.abs(b - a));
        }
        //}
        //catch(Exception e){}
        for (Long x:result)
            System.out.println(x);

    }
}
