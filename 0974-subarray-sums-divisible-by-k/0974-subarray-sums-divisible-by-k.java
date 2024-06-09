class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int num: nums){
            prefixSum += num;
            int mod = prefixSum % k;
            
            if(mod < 0){
                mod += k;
            }
            
            if(map.containsKey(mod)){
                count += map.get(mod);
                map.put(mod, map.get(mod) + 1);
            }
            else{
                map.put(mod, 1);
            }
        }
        return count;
    }
}