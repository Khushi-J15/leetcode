class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];

        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        int[][] bestSum = new int[4][n+1];
        int[][] bestIndex = new int[4][n+1];

        for(int i=1; i<=3; i++){
            for(int j=k*i; j<=n; j++){
                int currentSum = prefixSum[j] - prefixSum[j-k] + bestSum[i-1][j-k];
                
                if(currentSum > bestSum[i][j-1]){
                bestSum[i][j] = currentSum;
                bestIndex[i][j] = j-k;
                } else {
                    bestSum[i][j] = bestSum[i][j-1];
                    bestIndex[i][j] = bestIndex[i][j-1];
                }
            }
        }

        int[] result = new int[3];
        int currentEnd = n;

        for(int i=3; i >= 1; i--){
            result[i-1] = bestIndex[i][currentEnd];
            currentEnd = result[i-1];
        }
        
        return result;
    }
}