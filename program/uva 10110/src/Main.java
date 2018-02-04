import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            long a = Long.parseLong(br.readLine());
            if(a == 0)
                break;
            long square = (long)(Math.sqrt(a));
            if(square * square == a || (square + 1) * (square + 1) == a)
                System.out.println("yes");
            else System.out.println("no");
        }
    }
}
