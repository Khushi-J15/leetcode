class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = nums[0];
        
        for(int i=1; i<n; i++){
            prefixXor[i] = prefixXor[i-1] ^ nums[i];
        }
        
        int mask = (1 << maximumBit) - 1;
        int[] ans = new int[n];
        
        for(int i=0; i<n; i++){
            int curXor = prefixXor[prefixXor.length - 1 - i];
            
            int bestK = curXor ^ mask;
            ans[i] = bestK;
        }
        
        return ans;
    }
}