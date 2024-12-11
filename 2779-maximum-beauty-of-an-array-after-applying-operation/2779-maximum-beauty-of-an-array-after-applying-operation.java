class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int maxBeauty = 0;
        Arrays.sort(nums);
        int right = 0;
        
        for(int left = 0; left<nums.length; left++){
            while(right < nums.length &&
              nums[right] - nums[left] <= 2*k){
                right++;
            }
            
            maxBeauty = Math.max(maxBeauty, right - left);
        }
        
        return maxBeauty;
    }
}