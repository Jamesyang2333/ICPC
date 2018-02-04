import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x;
        while((x = sc.nextInt())!=0) {
            int[] blocks = new int[x];
            for(int i=0;i<x;i++)
                blocks[i]=0;
            for (int i = 0; i < x; i++) {
                for(int j=0;j<2;j++){
                String line = sc.next();
                if(line.length()==25){
                    blocks[i] += line.length();
                    break;
                }
                blocks[i] += line.length();
                }
            }
            int max=blocks[0];
            for(int i=1;i<x;i++)
                if(blocks[i]>max)
                    max = blocks[i];
            int vac=0;
            for(int i=0;i<x;i++)
                vac += (max-blocks[i]);
            System.out.println(vac);
        }
    }
}
