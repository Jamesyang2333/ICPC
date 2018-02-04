/*The weirdest judging result I've ever seen,
* it seems that analysis of algorithm just don't work here
* reason (maybe): too many test cases, too many time wasted for creation and initialization(overhead)
* Don't like this kind of test with infinite cases
* why don't simply increase the input size man!!!*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        int[] allLetter = new int[26];
        String word;
        String guess;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line;
            if((line = br.readLine()) == null)
                System.exit(0);
            int caseNum = Integer.parseInt(line);
            if(caseNum == -1)
                System.exit(0);
            word  = br.readLine();
            for(int i = 0; i < 26; i++)
                allLetter[i] = 0;
            int len = word.length();
            int letterNum = 0;
            for(int i = 0; i <  len; i++) {
                int current = word.charAt(i) - 'a';
                if (allLetter[current] == 0){
                    allLetter[current] = 1;
                    letterNum++;
                }
            }
            guess = br.readLine();
            int guessLen = guess.length();
            int wrongGuess = 0;
            int state = -1;
            for(int i = 0; i <  guessLen; i++){
                int current = guess.charAt(i) - 'a';
                if(allLetter[current] == 0){
                    allLetter[current] = -2;
                    wrongGuess++;
                    if(wrongGuess == 7){
                        state = 0;
                        break;
                    }
                }
                else if(allLetter[current] == 1){
                    allLetter[current] = -1;
                    letterNum--;
                    if(letterNum == 0){
                        state = 1;
                        break;
                    }
                }
            }
            System.out.format("Round %d\n",  caseNum);
            if(state == 0)
                System.out.println("You lose.");
            else if(state == 1)
                System.out.println("You win.");
            else System.out.println("You chickened out.");
        }
    }
}
