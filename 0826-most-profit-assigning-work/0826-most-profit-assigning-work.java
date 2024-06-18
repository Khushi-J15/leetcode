class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< profit.length; i++){
            map.put(difficulty[i], Math.max(map.getOrDefault(difficulty[i],0), profit[i]));
        }
        
        int max = Integer.MIN_VALUE;
        for(int n : worker){
            max = Math.max(max, n);
        }
        
        int[] dp = new int[max + 1];
        for(int i=1; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1], map.getOrDefault(i,0));
        }
        int res = 0;
        for(int n : worker){
            res += dp[n];
        }
        return res;
    }
}