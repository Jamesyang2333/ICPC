import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(System.in);
        DataOutputStream output = new DataOutputStream(System.out) ;
        int C;
        while ((C =in.read()) !=-1) {
            if(!Character.isWhitespace((char)C))
                output.write((char)(C-7));
            else output.write((char)C);
        }
    }
}