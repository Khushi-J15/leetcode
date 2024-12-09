class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int m = queries.length;
        int n = nums.length;
        int[] prefix = new int[n];
        
        for(int i=1; i<n; i++){
            if(nums[i]%2 == nums[i-1]%2){
                prefix[i] = 1 + prefix[i-1];
            } else {
                prefix[i] = prefix[i-1]; 
            }
        }
        
        boolean[] ans = new boolean[m]; 
        
        for(int i=0; i<m; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            
            ans[i] = (prefix[e] - prefix[s] == 0);
        }
        
        return ans;
    }
}