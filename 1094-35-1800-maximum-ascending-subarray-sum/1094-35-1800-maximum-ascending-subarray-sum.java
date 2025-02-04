class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                currSum += nums[i];
            } else {
                currSum = nums[i];
            }

            max = Math.max(max, currSum);
        }

        return max;
    }
}