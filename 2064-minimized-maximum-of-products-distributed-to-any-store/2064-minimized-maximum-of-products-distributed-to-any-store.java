class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 0, right = 0;
        
        for(int quantity : quantities){
            if(quantity > right){
                right = quantity;
            }
        }
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(isPossible(mid, n, quantities)){
                right = mid;
            } else{
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean isPossible(int maxLimitPerStore, int n, int[] quantities){
        int noOfStoresRequired = 0;
        
        for(int quantity: quantities){
            noOfStoresRequired += Math.ceil((quantity * 1.0)/maxLimitPerStore);
        }
        
        return (noOfStoresRequired<=n);
    }
}