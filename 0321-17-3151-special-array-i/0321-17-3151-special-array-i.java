class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;
        for(int i=0; i<nums.length-1; i++){
            // both are odd
            if(nums[i]%2 != 0 && nums[i + 1]%2 != 0) return false;
            // both are even
            else if(nums[i]%2 == 0 && nums[i + 1]%2 == 0) return false;
        }
        return true;
    }
}