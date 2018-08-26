import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> domains = new HashMap<>();
        int ndominas = cpdomains.length;
        for(int cc = 0; cc < ndominas; cc++){
            String[] separate = cpdomains[cc].split(" ");
            int times = Integer.parseInt(separate[0]);
            String[] tokens = separate[1].split("\\.");
            int nparts = tokens.length;
            for(int i = 0; i < nparts; i++){
                String address = "";
                for(int j = i; j < nparts; j++){
                    if(j != i)
                        address += ".";
                    address += tokens[j];
                }
                if(domains.containsKey(address))
                    domains.put(address, times + domains.get(address));
                else
                    domains.put(address, times);
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for(String address: domains.keySet()){
            String combined = domains.get(address) + " " + address;
            result.add(combined);
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        Solution test = new Solution();
        String[] input = new String[1];
        input[0] = "9001 discuss.leetcode.com";
        ArrayList<String> result = (ArrayList)test.subdomainVisits(input);
        System.out.println(result.size());
    }
}