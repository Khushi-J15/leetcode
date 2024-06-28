class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];
        
        for(int[] edge: roads){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Arrays.sort(degree);
        
        long value = 1;
        long totalSum = 0;
        
        for(long d : degree){
            totalSum += (value * d);
            value++;
        }
        
        return totalSum;
    }
}