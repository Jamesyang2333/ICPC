//This is also WA on uva, don't know why
//Update: Reason: must use a binary input reader, the input might be out of the Ascii character range!
//Use DataInputSteam and DataOutputStream can!!!
import java.util.Scanner;

public class test {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        while(reader.hasNextLine()){
            String x = reader.nextLine();
            char[] charArray = x.toCharArray();
            for(int n = 0; n < charArray.length; n++){
                charArray[n] = (char)(charArray[n] - 7);
            }
            System.out.println(new String(charArray));
        }

    }
}
