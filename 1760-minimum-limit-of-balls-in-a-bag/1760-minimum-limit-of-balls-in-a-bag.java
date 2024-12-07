class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int max = nums[0];
        
       for(int i=0;i<n;i++)
        {
            if(max<nums[i])
              max=nums[i];
        }
        
        int left = 1, right = max;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(withinRange(nums, maxOperations, mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        return left;
    }
    
    private boolean withinRange(int[] nums, int maxOperations, int k){
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i] > k){
                maxOperations -= (nums[i] - 1)/k;
            }
            
            if( maxOperations < 0 ){
                return false;
            } 
        }
        
        return true;
    }
}