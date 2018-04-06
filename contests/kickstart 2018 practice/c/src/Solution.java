//The reversepostorder function is false in general. It's only true in this special case where every node has exacly one child.
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {
    private static ArrayList<Integer>[] adj;
    private static boolean[] marked;
    private static Stack<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ncase = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        for(int cc = 0; cc < ncase; cc++){
            int nflights = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            String[] allcites = new String[nflights + 1];
            HashMap<String, Integer> symbolTable = new HashMap<>();
            adj = (ArrayList<Integer>[]) new ArrayList[nflights + 1];
            int current = 0;
            for(int i = 0; i <= nflights; i++)
                adj[i] = new ArrayList<Integer>();
            for(int i = 0; i < nflights; i++){
                String start = new StringTokenizer(br.readLine()).nextToken();
                String end = new StringTokenizer(br.readLine()).nextToken();
                int startno = 0;
                int endno = 0;
                if(!symbolTable.containsKey(start)){
                    allcites[current] = start;
                    symbolTable.put(start, current);
                    startno = current;
                    current++;
                }
                else startno = symbolTable.get(start);
                if(!symbolTable.containsKey(end)){
                    allcites[current] = end;
                    symbolTable.put(end, current);
                    endno = current;
                    current++;
                }
                else endno = symbolTable.get(end);
                adj[startno].add(endno);
            }
            result = new Stack<>();
            marked = new boolean[nflights + 1];
            for(int i = 0; i <= nflights; i++)
                marked[i] = false;
            for(int i = 0; i < nflights + 1; i++){
                if(!marked[i])
                    reversePostOrder(i);
            }
            System.out.format("Case #%d: ", cc + 1);
            System.out.print(allcites[result.pop()]);
            for(int i = 0; i < nflights - 1; i++){
                int index = result.pop();
                System.out.print("-" + allcites[index] + " " + allcites[index]);
            }
            System.out.println("-" + allcites[result.pop()]);
        }
    }
    private static void reversePostOrder(int v){
        Stack<Integer> states = new Stack<>();
        states.push(v);
        ArrayList<Integer> cites = new ArrayList<>();
        while(!states.isEmpty()){
            int current = states.pop();
            cites.add(current);
        marked[current] = true;
        for(int next : adj[current]){
            if(!marked[next])
                states.push(next);
        }
        }
        int len = cites.size();
        for(int i = len - 1; i >= 0; i--){
        result.push(cites.get(i));
        }
    }
}
