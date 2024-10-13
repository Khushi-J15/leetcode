class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        
        int maxVal = Integer.MIN_VALUE, rangeStart = 0, rangeEnd = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.size(); i++){
            pq.offer(new int[] { nums.get(i).get(0), i, 0 });
            maxVal = Math.max(maxVal, nums.get(i).get(0));
        }
            
        while(pq.size() == nums.size()){
            int[] data = pq.poll();
            int minVal = data[0], row = data[1], col = data[2];
            
            if(maxVal - minVal < rangeEnd - rangeStart){
                rangeStart = minVal;
                rangeEnd = maxVal;
            }
            
            if(col + 1 < nums.get(row).size()){
                int nextVal = nums.get(row).get(col + 1);
                pq.offer(new int[] { nextVal , row, col + 1 });
                maxVal = Math.max(maxVal, nextVal);
            }
        }
        
        return new int[] { rangeStart, rangeEnd };
    }
}