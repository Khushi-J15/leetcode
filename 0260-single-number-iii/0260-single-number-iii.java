class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int[] result = new int[2];
        int index = 0;
        
        for(int i=0; i<n; i++){
            boolean flag = false;
            for(int j=0; j<n; j++){
                if(i != j && nums[i] == nums[j]){
                    flag = true;
                    break;
                }
            }
            
            if(!flag){
                result[index++] = nums[i];
                if(index == 2) break;
            }
        }
        
        return result;
    }
}