import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    char[] sequence = line.toCharArray();
    int length = sequence.length;
    boolean findone = false;
    int nzeros = 0;
    for(int i = 0; i < length; i++){
        if(!findone){
            if(sequence[i] == '1')
                findone = true;
        }
        else{
            if(sequence[i] == '0')
                nzeros++;
        }
    }
    if(nzeros >= 6) {System.out.println("yes");}
    else System.out.println("no");
    }
}
