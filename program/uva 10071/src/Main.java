import java.util.Scanner;
class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int x=Integer.parseInt(sc.next());
            int y=Integer.parseInt(sc.next());
            System.out.println(2*x*y);
        }
    }
}
