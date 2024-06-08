class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefSum = 0;
        Map<Integer, Integer> firstOccur = new HashMap<>();
        firstOccur.put(0,0);
        
        for(int i=0; i<n; i++){
            prefSum = (prefSum + nums[i])%k;
            if(firstOccur.containsKey(prefSum)){
                if(i + 1 - firstOccur.get(prefSum) >= 2) return true;
            }
            else{
                firstOccur.put(prefSum, i+1);
            }
        }
        return false;
    }
}