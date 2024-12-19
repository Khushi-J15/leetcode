class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunkCount = 0;
        int maxChunkEnd = 0;
        
        for(int i=0; i<n; i++){
            maxChunkEnd = Math.max(maxChunkEnd, arr[i]);
            if(i == maxChunkEnd){
                chunkCount++;
            }
        }
        
        return chunkCount;
    }
}