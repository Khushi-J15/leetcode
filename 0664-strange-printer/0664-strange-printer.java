class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[101][101];
        
        for(int i=0; i<101; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return solve(0, n-1, s, dp);
    }
    
    public int solve(int i, int j, String s, int[][] dp){
        if(i==j) return 1;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int minTurns = Integer.MAX_VALUE;
        
        for(int k=i; k<j; k++){
            minTurns = Math.min(minTurns, solve(i, k, s, dp) + solve(k+1, j, s, dp));
        }
        
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = minTurns - 1;
        }else{
            dp[i][j] = minTurns;
        }
        
        return dp[i][j];
    }
}