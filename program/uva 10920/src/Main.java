import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    private static int[] xmove = {-1, 0, 1, 0};
    private static int[] ymove = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            if(n == 0 && p == 0)
                break;
            long square = (long)Math.sqrt(p);
            if((square + 1) * (square + 1) == p)
                square = square + 1;
            long startx = 0;
            long starty = 0;
            int startp = 0;
            if(square % 2 == 0){
                starty = (n + 1) / 2 - square / 2;
                startx = (n + 1) / 2 - square / 2 + 1;
                startp = 0;
            }
            else{
                startx = (n + 1) / 2 + (square - 1) / 2;
                starty = (n + 1) / 2 + (square - 1) / 2;
                startp = 2;
            }
            long count = square * square;
            if(count != p){
                startx += xmove[startp];
                starty += ymove[startp];
                count++;
                startp = (startp + 1) % 4;
                if(count != p){
                    for(int i = 0; i < square; i++){
                        startx += xmove[startp];
                        starty += ymove[startp];
                        count++;
                        if(count == p)
                            break;
                    }
                    if(count != p){
                        startp = (startp + 1) % 4;
                        for(int i = 0; i < square; i++){
                            startx += xmove[startp];
                            starty += ymove[startp];
                            count++;
                            if(count == p)
                                break;
                        }
                    }
                }
            }
            System.out.format("Line = %d, column = %d.\n", startx, starty);
        }
    }
}
