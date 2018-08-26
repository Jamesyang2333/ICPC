import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String res = findNumber(arr, k);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
}
    static String findNumber(List<Integer> arr, int k) {
        int len = arr.size();
        boolean found = false;
        for (int i = 0; i < len; i++){
            if(arr.get(i) == k){
                found = true;
                break;
            }
        }
        if (found){
            return ("YES");
        }
        else{
            return ("NO");
        }

    }


}
