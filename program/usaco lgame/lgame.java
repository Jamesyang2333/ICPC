/*
ID: jamesya4
LANG: JAVA
TASK: lgame
*/
import java.io.*;
import java.util.*;

class lgame {
    private static int[] letters;
    private static int[] scores;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("lgame.in"));
        BufferedReader dic = new BufferedReader(new FileReader("lgame.dict"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lgame.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        ArrayList<String> dictionary = new ArrayList<>();
        String line;
        String allword = st.nextToken();
        letters = new int[26];
        for(int i = 0; i < 26; i++)
            letters[i] = 0;
        for(int i = 0; i < allword.length(); i++)
            letters[allword.charAt(i) - 'a']++;
        scores = new int[]{2, 5, 4, 4, 1, 6, 5, 5, 1, 7, 6, 3, 5, 2, 3, 5, 7, 2, 1, 2, 4, 6, 6, 7, 5, 7};
        //System.out.println(checkWord("prom"));
        //System.out.println(checkWord("rag"));
        int max = 0;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        while((line = dic.readLine()) != null){
            String word = new StringTokenizer(line).nextToken();
            if(word.equals("."))
                break;
            dictionary.add(word);
        }
        int dicSize = dictionary.size();
        for(int i = 0; i < dicSize; i++){
            int sum = 0;
            if(dictionary.get(i).equals("hub")){
                System.out.println();
            }
            int state = checkWord(dictionary.get(i));
            if(state > 0){
                sum += state;
                if(allword.length() - dictionary.get(i).length() < 3){
                    if(sum > max){
                        max = sum;
                        result.clear();
                        ArrayList<String> a = new ArrayList<>();
                        a.add(dictionary.get(i));
                        result.add(a);
                    }
                    else if(sum == max){
                        ArrayList<String> a = new ArrayList<>();
                        a.add(dictionary.get(i));
                        result.add(a);
                    }
                }
                else{
                for(int j = i; j < dicSize; j++){
                    int state2 = checkWord(dictionary.get(j));
                    if(state2 > 0){
                        sum += state2;
                        if(sum > max){
                            max = sum;
                            result.clear();
                            ArrayList<String> a = new ArrayList<>();
                            a.add(dictionary.get(i));
                            a.add(dictionary.get(j));
                            result.add(a);
                        }
                        else if(sum == max){
                            ArrayList<String> a = new ArrayList<>();
                            a.add(dictionary.get(i));
                            a.add(dictionary.get(j));
                            result.add(a);
                        }
                        sum -= state2;
                        for(int k = 0; k < dictionary.get(j).length(); k++){
                            letters[dictionary.get(j).charAt(k) - 'a']++;
                        }
                    }
                }
                    if(sum > max){
                        max = sum;
                        result.clear();
                        ArrayList<String> a = new ArrayList<>();
                        a.add(dictionary.get(i));
                        result.add(a);
                    }
                    else if(sum == max){
                        ArrayList<String> a = new ArrayList<>();
                        a.add(dictionary.get(i));
                        result.add(a);
                    }
                }
                for(int k = 0; k < dictionary.get(i).length(); k++){
                    letters[dictionary.get(i).charAt(k) - 'a']++;
                }
            }
        }
        out.println(max);
        for(ArrayList words : result){
            Collections.sort(words);
            for(int i = 0; i < words.size(); i++){
                if(i == words.size() - 1)
                    out.println(words.get(i));
                else out.print(words.get(i) + " ");
            }
        }
        out.close();                                  // close the output file
    }
    private static int checkWord(String word){
        int sum = 0;
        int len = word.length();
        boolean can = true;
        int i = 0;
        for(; i < len; i++){
            if(letters[word.charAt(i) - 'a'] > 0){
                letters[word.charAt(i) - 'a']--;
                sum += scores[word.charAt(i) - 'a'];
            }
            else {
                can = false;
                break;
            }
        }
        if(!can){
            for(int j = i - 1; j >= 0; j--){
                letters[word.charAt(j) - 'a']++;
            }
        }
        if(can) return sum;
        else return -1;
    }
}
