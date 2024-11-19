class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        long curSum = 0;
        
        for(int right = 0; right < nums.length; right++){
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            curSum += nums[right];
            
            while(freqMap.get(nums[right]) > 1){
                freqMap.put(nums[left], freqMap.getOrDefault(nums[left], 0) - 1);
                curSum -= nums[left];
                left++;
            }
            
            if(right - left + 1 == k){
                maxSum = Math.max(curSum, maxSum);
                curSum -= nums[left];
                freqMap.put(nums[left], freqMap.getOrDefault(nums[left], 0) - 1);
                left++;
            }
        }
        
        return maxSum;
    }
}