class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        int n = nums.length; 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums){
            maxHeap.add(num);
        }
        
        for(int i=0; i<k; i++){
            int maxElement = maxHeap.poll();
            score += (long)(maxElement);
            maxHeap.add((int)Math.ceil(maxElement / 3.0));
        }
        
        return score;
    }
}