import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            if(n == 0)
                break;
            else{
                StringTokenizer st = new StringTokenizer(br.readLine());
                int orix = Integer.parseInt(st.nextToken());
                int oriy = Integer.parseInt(st.nextToken());
                for(int i = 0; i < n; i++){
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    if(x == orix || y == oriy)
                        System.out.println("divisa");
                    else if(x > orix){
                        if(y > oriy)
                            System.out.println("NE");
                        else System.out.println("SE");
                    }
                    else {
                        if(y > oriy)
                            System.out.println("NO");
                        else System.out.println("SO");
                    }
                }
            }
        }
    }
}
