/*
ID: jamesya4
LANG: JAVA
TASK: shopping
*/
import java.io.*;
import java.util.*;

class shopping {
    private static int min = 0;
    private static promotion[] offers;
    private static int[] amount;
    private static HashMap<Integer, Integer> indices;
    private static int[][] allprice;
    private static int nitems;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("shopping.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shopping.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        int noffers = Integer.parseInt(st.nextToken());
        offers = new promotion[noffers];
        for(int i = 0; i < noffers; i++){
            st = new StringTokenizer(f.readLine());
            int nitems = Integer.parseInt(st.nextToken());
            offers[i] = new promotion(nitems);
            for(int j = 0; j < nitems; j++){
                offers[i].addItem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            offers[i].setPrice(Integer.parseInt(st.nextToken()));
        }
        //int[][][][][] prices = new int[5][5][5][5][5];
        //for(int i = 0; i < prices; i++);
        st = new StringTokenizer(f.readLine());
        nitems = Integer.parseInt(st.nextToken());
        indices = new HashMap<>();
        amount = new int[nitems];
        allprice = new int[nitems][5];
        for(int i = 0; i < nitems; i++)
            for(int j = 0; j < 5; j++)
                allprice[i][j] = -1;
        for(int i = 0; i < nitems; i++){
            st = new StringTokenizer(f.readLine());
            indices.put(Integer.parseInt(st.nextToken()), i);
            amount[i] = Integer.parseInt(st.nextToken());
            allprice[i][0] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < noffers; i++){
            if(offers[i].nitems == 1){
                if(offers[i].amount[0] == 1){
                    if(offers[i].price < allprice[indices.get(offers[i].item[0])][0]){
                        allprice[indices.get(offers[i].item[0])][0] = offers[i].price;
                        offers[i] = null;
                    }
                }
                else{
                    allprice[indices.get(offers[i].item[0])][offers[i].amount[0] - 1] = offers[i].price;
                }
            }
        }
        for(int i = 0; i < nitems; i++){
            for(int j = 1; j < 5; j++){
                if(allprice[i][j] == -1){
                    if(j == 1)
                        allprice[i][j] = 2 * allprice[i][0];
                    if(j == 2)
                        allprice[i][j] = allprice[i][0] + allprice[i][1];
                    if(j == 3){
                        allprice[i][j] = Math.min(allprice[i][1] + allprice[i][1], allprice[i][2] + allprice[i][0]);
                    }
                    if(j == 4){
                        allprice[i][j] = Math.min(allprice[i][1] + allprice[i][2], allprice[i][3] + allprice[i][0]);
                }
                }
                else{
                if(j == 1)
                    allprice[i][j] = Math.min(allprice[i][j], 2 * allprice[i][0]);
                if(j == 2)
                    allprice[i][j] = Math.min(allprice[i][j], allprice[i][0] + allprice[i][1]);
                if(j == 3){
                    allprice[i][j] = Math.min(allprice[i][j], allprice[i][2] + allprice[i][0]);
                    allprice[i][j] = Math.min(allprice[i][j], allprice[i][1] + allprice[i][1]);
                }
                if(j == 4){
                    allprice[i][j] = Math.min(allprice[i][j], allprice[i][3] + allprice[i][0]);
                    allprice[i][j] = Math.min(allprice[i][j], allprice[i][1] + allprice[i][2]);
                }
            }
            }
        }
        int count = 0;
        for(int i = 0; i < noffers; i++){
            if(offers[i] != null){
                int cost = 0;
                for(int j = 0; j < offers[i].nitems; j++){
                    cost += allprice[indices.get(offers[i].item[j])][offers[i].amount[j] - 1];
                }
                if(offers[i].nitems == 1 || offers[i].price > cost)
                    offers[i] = null;
                else count++;
            }
        }
        for(int i = 0; i < nitems; i++){
            min += amount[i] * allprice[i][0];
        }
        if(noffers > 0)
            search(noffers - 1, 0);
        out.println(min);                           // output result
        /*System.out.println(count);
        for(int i = 0; i < nitems; i++){
            for (int j = 0; j < 5; j++)
                System.out.print(allprice[i][j] + " ");
            System.out.println();
        }*/
        out.close();                                  // close the output file
    }
    private static void search(int n, int cost){
        if(offers[n] != null){
        promotion current = offers[n];
        int nsets = 5;
        for(int i = 0; i < current.nitems; i++){
            nsets = Math.min(nsets, amount[indices.get(current.item[i])] / current.amount[i]);
        }
        for(int i = 1; i <= nsets; i++){
            int newcost = cost;
            newcost += (current.price * i);
            for(int j = 0; j < current.nitems; j++){
                amount[indices.get(current.item[j])] -= (current.amount[j] * i);
            }
            int total = newcost;
            for(int j = 0; j < nitems; j++)
                if(amount[j] != 0)
                    total += allprice[j][amount[j] - 1];
            //System.out.println(total);
            if(total < min)
                min = total;
            if(n != 0)
            search(n - 1, newcost);
            for(int j = 0; j < current.nitems; j++){
                amount[indices.get(current.item[j])] += (current.amount[j] * i);
            }
        }
        if(n != 0)
            search(n - 1, cost);
    }
        else{
            if(n != 0)
                search(n - 1, cost);
        }
    }
}
class promotion{
    public int[] item;
    public int[] amount;
    public int nitems;
    public int price;
    private int count = 0;
    public promotion(int nitems){
        this.nitems = nitems;
        item = new int[nitems];
        amount = new int[nitems];
    }
    public void addItem(int index, int amount){
        item[count] = index;
        this.amount[count] = amount;
        count++;
    }
    public void setPrice(int price){
        this.price = price;
    }
}