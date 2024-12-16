class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        
        for(int t=0; t<k; t++){
            int minIdx = 0;
            for(int i=0; i<n; i++){
                if(nums[i] < nums[minIdx]){
                    minIdx = i;
                }       
            }
            nums[minIdx] *= multiplier;
        }
        
        return nums;
        
    }
}