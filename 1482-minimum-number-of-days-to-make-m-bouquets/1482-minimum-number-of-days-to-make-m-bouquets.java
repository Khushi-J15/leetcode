class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val =  (long)m * k;
        if(val > bloomDay.length) return -1;
        
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0; i<bloomDay.length; i++){
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        
        int low = mini, high = maxi;
        
        while(low <= high){
            int mid = (low + high)/2;
            if(possible(bloomDay, mid, m, k)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    public boolean possible(int[] arr, int day, int m, int k){
        int cnt = 0;
        int BDay = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= day){
                cnt++;
            }
            else{
                BDay += (cnt/k);
                cnt = 0;
            }
        }
        BDay += (cnt/k);
        return BDay >=  m;
    }
}