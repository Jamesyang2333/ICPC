import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        HashMap<Integer, Integer> distincts= new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!distincts.containsKey(nums[i]))
                distincts.put(nums[i], 1);
            else distincts.put(nums[i], distincts.get(nums[i]) + 1);
        }
        int size = distincts.size();
        int[] all = new int[size];
        int count = 0;
        for(int a : distincts.keySet()){
            all[count++] = a;
        }
        Arrays.sort(all);
        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                if(-all[i]-all[j] >= all[j]){
                if(i == j){
                    if(distincts.get(all[i]) >= 2){
                        if(distincts.containsKey(-all[i]-all[j])){
                            if(-all[i]-all[j] == all[i]){
                                if(distincts.get(all[i]) >= 3){
                                    ArrayList<Integer> pair = new ArrayList<>();
                                    pair.add(all[i]);
                                    pair.add(all[i]);
                                    pair.add(-all[i] - all[j]);
                                    result.add(pair);
                                }
                            }
                            else{
                                ArrayList<Integer> pair = new ArrayList<>();
                                pair.add(all[i]);
                                pair.add(all[j]);
                                pair.add(-all[i] - all[j]);
                                result.add(pair);
                            }
                        }
                    }
                }
                else{
                    if(distincts.containsKey(-all[i] - all[j])){
                        if(-all[i] - all[j] == all[i]){
                            if(distincts.get(all[i]) >= 2){
                                ArrayList<Integer> pair = new ArrayList<>();
                                pair.add(all[i]);
                                pair.add(all[j]);
                                pair.add(-all[i] - all[j]);
                                result.add(pair);
                            }
                        }
                        else if(-all[i] - all[j] == all[j]){
                            if(distincts.get(all[j]) >= 2){
                                ArrayList<Integer> pair = new ArrayList<>();
                                pair.add(all[i]);
                                pair.add(all[j]);
                                pair.add(-all[i] - all[j]);
                                result.add(pair);
                            }
                        }
                        else{
                            ArrayList<Integer> pair = new ArrayList<>();
                            pair.add(all[i]);
                            pair.add(all[j]);
                            pair.add(-all[i] - all[j]);
                            result.add(pair);
                        }
                    }
                }
            }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] test = new int[]{-1,-2,-3,4,1,3,0,3,-2,1,-2,2,-1,1,-5,4,-3};
        Solution a = new Solution();
        List<List<Integer>> hh = a.threeSum(test);
        System.out.println(test.length);
        System.out.println(hh.toString());
    }
}