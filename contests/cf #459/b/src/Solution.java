import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nnames = Integer.parseInt(st.nextToken());
        int ncommands = Integer.parseInt(st.nextToken());
        HashMap<String, String> names = new HashMap<>();
        for(int i = 0; i < nnames; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ip = st.nextToken();
            names.put(ip, name);
        }
        for(int i = 0; i < ncommands; i++){
            String command = br.readLine();
            String[] segments = command.split(" ");
            int len = segments.length;
            String ip = segments[len - 1];
            String  name = names.get(ip.substring(0,  ip.length() - 1));
            for(int j = 0; j < len - 1; j++){
                System.out.print(segments[j] + " ");
            }
            System.out.println(ip + " #" + name);
        }
    }
}
