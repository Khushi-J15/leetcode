class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = Integer.MAX_VALUE;
        int maxPrefixSum = Integer.MIN_VALUE;
        int prefixSum = 0;
        int maxAbsSum = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            minPrefixSum = Math.min(prefixSum, minPrefixSum);
            maxPrefixSum = Math.max(prefixSum, maxPrefixSum);
            if(prefixSum >= 0){
            maxAbsSum = Math.max(maxAbsSum, Math.max(prefixSum, prefixSum - minPrefixSum));
            }
            else {
                maxAbsSum = Math.max(maxAbsSum, Math.max(Math.abs(prefixSum), Math.abs(prefixSum - maxPrefixSum)));
            }
        }

        return maxAbsSum;
    }
}