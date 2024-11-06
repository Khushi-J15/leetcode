class Solution {
    public boolean canSortArray(int[] nums) {
        
        
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[j] < nums[i]){
                    if(Integer.bitCount(nums[j]) != Integer.bitCount(nums[i])){
                        return false;
                    } else {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
        
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) return false;
        }
        
        return true;
    }
}