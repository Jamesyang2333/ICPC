//AC for 4 times in five
// the running time on uva server varies
//when the average running time is 2s, it's possible it ac sometimes and tle sometimes
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


class Main1 {

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line, word, guess;
        HashSet<Character> checked;
        while ((line = br.readLine()) != null)
        {
            int caseNum = Integer.parseInt(line);
            if(caseNum == -1)
                System.exit(0);
            checked = new HashSet<>();
            word  = br.readLine();
            guess = br.readLine();
            int guessLen = guess.length();
            int wrongGuess = 0;
            int state = -1;
            for(int i = 0; i < guessLen; i++){
                char current = guess.charAt(i);
                if(!checked.contains(current)){
                    checked.add(current);
                    if(word.indexOf(current) == -1){
                    wrongGuess++;
                    if(wrongGuess == 7){
                        state = 0;
                        break;
                    }
                    }
                    else{
                        word = word.replace("" + current,  "");
                        if(word.isEmpty()){
                            state = 1;
                            break;
                        }
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