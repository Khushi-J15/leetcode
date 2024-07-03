class Solution {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if(len <= 4) return 0;
        
         // four smallest elements 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int num : nums){
            maxHeap.offer(num);
            if(maxHeap.size() > 4){
                maxHeap.poll();
            }
        }
        
        List<Integer> smallestFour = new ArrayList<>(maxHeap);
        Collections.sort(smallestFour);
        
        // four largest elements 
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > 4){
                minHeap.poll();
            }
        }
        
        List<Integer> largestFour = new ArrayList<>(minHeap);
        Collections.sort(largestFour);
        
        int minDiff = Integer.MAX_VALUE;
        // four scenarios 
        for(int i=0; i<4; i++){
            minDiff = Math.min(minDiff, largestFour.get(i) - smallestFour.get(i));
        }
        
        return minDiff;
        
    }
}