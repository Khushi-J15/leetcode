class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1000000007;

        int[] dp = new int[high + 1];
        dp[0] = 1;

        for(int i=0; i<=high; i++){
            if(dp[i] > 0){
                if(i + zero <= high){
                    dp[i + zero] = (dp[i + zero] + dp[i])%mod;
                }
                if(i + one <= high){    
                    dp[i + one] = (dp[i + one] + dp[i])%mod;
                }
            }
        }

        int res = 0;
        for(int i=low; i<=high; i++){
            res = (res + dp[i])%mod;
        }

        return res;
    }
}