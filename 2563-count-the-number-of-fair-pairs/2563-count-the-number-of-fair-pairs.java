class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countLess(nums, upper + 1) - countLess(nums, lower);
    }
    
    private long countLess(int[] nums, int val){
        int left = 0, right = nums.length - 1;
        long res = 0;
        while(left <= right){
            if(nums[left] + nums[right] < val){
                res += right - left;
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}