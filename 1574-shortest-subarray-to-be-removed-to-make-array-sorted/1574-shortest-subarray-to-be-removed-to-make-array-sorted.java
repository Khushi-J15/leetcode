class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int n = arr.length;
        
        // Find longest increasing prefix
        while(left < n-1 && arr[left] <= arr[left + 1]){
            left++;
        } // left = 3
        
        if(left == n-1){
            return 0;
        }
        
        int right = n-1;
        
        while(right > 0 && arr[right - 1] <= arr[right]){
            right--;
        }
        
        int minlength = Math.min(n - left - 1, right);
        
        for(int i=0; i<=left; i++){
            while(right < n && arr[i] > arr[right]){
                right++;
            }
            
            minlength = Math.min(minlength, right - i - 1);
        }
        
        return minlength;
    }
    
}