class Solution {
    public void sortColors(int[] nums) {
        int zeroCnt = 0, oneCnt = 0, twoCnt = 0;
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) zeroCnt++;
            else if(nums[i] == 1) oneCnt++;
            else twoCnt++;
        }
        
        int index = 0;
        for(int i=0; i<zeroCnt; i++){
            nums[index] = 0;
            index++;
        }
        for(int i=0; i<oneCnt; i++){
            nums[index] = 1;
            index++;
        }
        for(int i=0; i<twoCnt; i++){
            nums[index] = 2;
            index++;
        }
    }
}