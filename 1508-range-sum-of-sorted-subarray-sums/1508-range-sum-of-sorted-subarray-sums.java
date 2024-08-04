class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> arr = new ArrayList<>();
        int prefix = 0;
        
        for(int i=0; i<n; i++){
            prefix = 0;
            
            for(int j=i; j<n; j++){
                prefix += nums[j];
                arr.add(prefix);
            }
        }
        
        Collections.sort(arr);
        int res = 0;
        int mod = 1000000007;
        
        for(int l = left-1; l<right; l++){
            res = (res  + arr.get(l))%mod;
        }
        
        return res;
    }
}