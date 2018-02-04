/*
ID: jamesya4
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class milk {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int total = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        farmer[] farmers = new farmer[n];
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            farmers[i] = new farmer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        byPrice comp = new byPrice();
        Arrays.sort(farmers, comp);
        int cost = 0;
        for(int i = 0; i < n; i++){
            if(total > farmers[i].amount){
                total -= farmers[i].amount;
                cost += farmers[i].amount * farmers[i].price;
            }
            else{
                cost += total * farmers[i].price;
                break;
            }
        }


        out.println(cost);                           // output result
        out.close();                                  // close the output file
    }
}

class farmer{
    int price;
    int amount;
    public farmer(int price, int amount){
        this.price = price;
        this.amount = amount;
    }
}
class byPrice implements Comparator<farmer>{
    public int compare(farmer a, farmer b){
        return (a.price - b.price);
    }
}