class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> prefSum = new HashMap<>();
        prefSum.put(0,1);
        
        for(int i=0; i<nums.length; i++){
            sum += (nums[i]%2 == 1) ? 1 : 0;
            if(prefSum.containsKey(sum - k)){
                result += prefSum.get(sum-k);
            }
            prefSum.put(sum, prefSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}