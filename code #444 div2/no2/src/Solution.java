import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[][] cubes = new int[n][6];
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 6; j++)
                    cubes[i][j] = Integer.parseInt(st.nextToken());
            }
            int number = 1;
            while (true){
                int numcopy = number;
                ArrayList<Integer> numbers = new ArrayList<>();
                while(numcopy > 0){
                    numbers.add(numcopy % 10);
                    numcopy /= 10;
                }
                HashSet<Integer> ncube = new HashSet<>();
                boolean containall = true;
                for(int i = 0; i < numbers.size(); i++){
                    boolean contain = false;
                    for(int j = 0; j < n; j++)
                        for(int k = 0; k < 6; k++){
                        if(cubes[j][k] == numbers.get(i)){
                            ncube.add(j);
                            contain = true;}
                        }
                        if(!contain){
                            containall = false;
                            break;
                        }
                }
                if (!containall)
                    break;
                if(ncube.size() < numbers.size())
                    break;
                else number++;
            }
                System.out.println(number - 1);
        }
        catch (IOException err){}
    }
}
