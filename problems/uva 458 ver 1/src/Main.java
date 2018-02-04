//This is also WA on uva, don't know why
//Update: Reason: must use a binary input reader, the input might be out of the Ascii character range!
//Use DataInputSteam and DataOutputStream can!!!
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class Main{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
        int C;
            while ((C =br.read()) !=-1) {
                if(((char)C) != '\n')
                    System.out.print((char)(C-7));
                else System.out.print((char)C);
            }
        }
        catch(IOException E){}
    }
}

