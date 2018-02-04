import java.util.Scanner;
class Main {
    public static void main(String[] args){
        int caseNumber;
        Scanner sc = new Scanner(System.in);
        caseNumber=Integer.parseInt(sc.next());
        for(int i=0;i<caseNumber;i++){
            int farmNumber;
            int sum=0;
            farmNumber=Integer.parseInt(sc.next());
            for(int j=0;j<farmNumber;j++){
                int area=Integer.parseInt(sc.next());
                sc.next();
                int index=Integer.parseInt(sc.next());
                sum += area * index;


            }
            System.out.println(sum);
        }
    }
}
