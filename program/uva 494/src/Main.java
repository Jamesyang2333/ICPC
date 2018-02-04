import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String x = sc.nextLine();
            int n=0;
            char[] sequence = x.toCharArray();
            if(Character.isAlphabetic(sequence[0]))
                n++;
            for(int i=1;i<sequence.length;i++)
                if(Character.isAlphabetic(sequence[i]) && !Character.isAlphabetic(sequence[i-1]))
                    n++;
            System.out.println(n);
        }
    }
}
