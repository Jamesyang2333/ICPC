import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

    public class Solution {
        private static HashSet<Long> s;
        private static HashMap<Long, Integer> grundys = new HashMap<>();
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            s = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i++)
                s.add(Long.parseLong(st.nextToken()));
            int nimsum = grudy(n);
            if(nimsum == 0)
                System.out.println("Second");
            else System.out.println("First");
        }
        private static int grudy(long a){
            if(a == 1 || a == 2)
                return 0;
            if(grundys.containsKey(a))
                return grundys.get(a);
            else{
                HashSet<Integer> next = new HashSet<>();
                for(Long sep : s){
                    if(a % sep == 0){
                        if(sep % 2 == 1)
                            next.add(grudy(a / sep));
                        else next.add(0);
                    }
                }
                if(next.isEmpty()){
                    grundys.put(a,  0);
                    return 0;
                }
                else{
                    int result = 0;
                    while(true){
                        if(!next.contains(result))
                            break;
                        else result++;
                    }
                    grundys.put(a, result);
                    //System.out.println(result);
                    return result;
                }
            }
        }
    /*private static boolean isPrime(long a){
        long limit = (long)Math.sqrt(a);
        if((limit + 1) * (limit + 1) == a)
            limit++;
        boolean prime = true;
        for(long  i = 2; i <= limit; i++){
            if(a % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }*/
    }

    private static HashSet<Long> s;
    private static HashMap<Long, Integer> grundys = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        s = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++)
            s.add(Long.parseLong(st.nextToken()));
        int nimsum = grudy(n);
        if(nimsum == 0)
            System.out.println("Second");
        else System.out.println("First");
    }
    private static int grudy(long a){
        if(a == 1 || a == 2)
            return 0;
        if(grundys.containsKey(a))
            return grundys.get(a);
        else{
        HashSet<Integer> next = new HashSet<>();
        for(Long sep : s){
            if(a % sep == 0){
                if(sep % 2 == 1)
                    next.add(grudy(a / sep));
                else next.add(0);
            }
        }
        if(next.isEmpty()){
            grundys.put(a,  0);
            return 0;
        }
        else{
        int result = 0;
        while(true){
            if(!next.contains(result))
                break;
            else result++;
        }
        grundys.put(a, result);
        //System.out.println(result);
        return result;
    }
    }
    }
    /*private static boolean isPrime(long a){
        long limit = (long)Math.sqrt(a);
        if((limit + 1) * (limit + 1) == a)
            limit++;
        boolean prime = true;
        for(long  i = 2; i <= limit; i++){
            if(a % i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }*/
}
