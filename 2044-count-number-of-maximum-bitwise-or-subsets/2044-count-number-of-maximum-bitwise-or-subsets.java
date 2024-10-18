class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int n = nums.length;
        
        for(int num : nums){
            maxOr |= num;
        }
        
        Integer[][] memo = new Integer[n][maxOr + 1];
        
        return countSubsetsWithMaxOr(nums, 0, 0, maxOr, memo);
    }
    
    public int countSubsetsWithMaxOr(int[] nums, int index, int currentOr, int maxOr, Integer[][] memo){
        if(index == nums.length){
            return (currentOr == maxOr) ? 1 : 0;
        }
        
        if(memo[index][currentOr] != null){
            return memo[index][currentOr];
        }
        
        int include = countSubsetsWithMaxOr(nums, index+1, currentOr | nums[index], maxOr, memo);
        
        int exclude = countSubsetsWithMaxOr(nums, index+1, currentOr, maxOr, memo);
        
        return memo[index][currentOr] = include + exclude;
    }
}