import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public List<String> ipToCIDR(String ip, int range) {
        ArrayList<String> result = new ArrayList<>();
        ip = ip.replace(".", " ");
        StringTokenizer st = new StringTokenizer(ip);
        boolean[] iparray = new boolean[32];
        for(int i = 0; i < 4; i++){
            int current = Integer.parseInt(st.nextToken());
            for(int j = 7; j >= 0; j--){
                if(((1 << j) & current) > 0){
                    iparray[i * 8 + 7 - j] = true;
                }
                else iparray[i * 8 + 7 - j] = false;
            }
        }
        int count = 0;
        boolean ini = true;
        for(int i = 31; i >= 0; i--){
            if(ini) {
                if(iparray[i]){
                    if(count + (1 << (31 - i)) < range) {
                        count += (1 << (31 - i));
                        String newip = transform(iparray);
                        result.add(newip + "/" + (i + 1));
                        for(int j = i + 1; j <= 31; j++){
                            iparray[j] = true;
                        }
                        ini = false;
                    }
                    else{
                        for(int j = 31 - i; j >= 0; j--){
                            if(count + (1 << j) <= range){
                                count += (1 << j);
                                result.add(transform(iparray) + "/" + (31 - j + 1));
                                iparray[31 - j] = true;
                            if(count == range){
                                break;
                            }
                            }
                        }
                    }
                }
            }
            else{
                if(!iparray[i]){
                    iparray[i] = true;
                    for(int j = i + 1; j <= 31; j++){
                        iparray[j] = false;
                    }
                    if(count + (1 << (31 - i)) < range) {
                        count += (1 << (31 - i));
                        String newip = transform(iparray);
                        result.add(newip + "/" + (i + 1));
                        for(int j = i + 1; j <= 31; j++){
                            iparray[j] = true;
                        }
                        ini = false;
                    }
                    else{
                        for(int j = 31 - i; j >= 0; j--){
                            if(count + (1 << j) <= range){
                                count += (1 << j);
                                result.add(transform(iparray) + "/" + (31 - j + 1));
                                iparray[31 - j] = true;
                                if(count == range){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if(count == range)
                break;
        }
        return result;
    }
    public static String transform(boolean[] a){
        String result = "";
        for(int i = 0; i < 4; i++){
            int sum = 0;
            for(int j = 0; j < 8; j++){
                if(a[i * 8 + j])
                    sum += (1 << (7 - j));
            }
            result += sum;
            if(i != 3)
                result += ".";
        }
        return result;
    }
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.ipToCIDR("207.170.41.0", 168).toString());
    }
}
