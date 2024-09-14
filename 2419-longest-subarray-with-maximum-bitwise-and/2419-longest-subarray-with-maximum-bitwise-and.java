class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0, maxValue = 0, currStreak = 0;
        
        for(int num : nums){
            if(maxValue < num){
                maxValue = num;
                ans = 0;
                currStreak = 0;
            }
            
            if(maxValue == num){
                currStreak++;
            }else{
                currStreak = 0;
            }
            
            ans = Math.max(ans, currStreak);
        }
        
        return ans;
    }
}