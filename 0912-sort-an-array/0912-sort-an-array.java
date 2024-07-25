class Solution {
    public int[] sortArray(int[] nums) {
        int key;
        
        for(int i=1; i<nums.length; i++){
            key = nums[i];
            int j = i-1;
            while(j >= 0 && nums[j] > key){
                nums[j+1] = nums[j];
                j--;
            }
            j = j+1;
            nums[j] = key;
        }
        
        return nums;
    }
}