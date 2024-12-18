class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n-1; j++){
                if(prices[i] >= prices[j]){
                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        
        return answer;
    }
}