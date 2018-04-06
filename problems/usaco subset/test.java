import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("subset.in"));
        System.out.println(new StringTokenizer(br.readLine()).hasMoreElements());
        System.out.println(br.readLine());
    }
}
