import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] content = new char[1000000];
        int count = 0;
        try{
            String line = br.readLine();
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == '<')
                    count--;
                else content[count++] = line.charAt(i);
            }
                System.out.print(new String(content, 0, count));
        }
        catch(IOException E){}
    }
}
