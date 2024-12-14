class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        
        long result = 0;
        
        for(int right = 0; right < n; right++){
           while(!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]){
               minDeque.pollLast();
           } 
           minDeque.offerLast(right); 
           while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]){
               maxDeque.pollLast();
           } 
           maxDeque.offerLast(right); 
           
           while(nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2){
               if(maxDeque.peekFirst() == left){
                   maxDeque.pollFirst();
               }
               if(minDeque.peekFirst() == left){
                   minDeque.pollFirst();
               }
               left++;
           } 
            
           result += right - left + 1; 
        }
        
        return result;
    }
}