class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long matrixSum = 0;
        int numNegatives = 0;
        int minAbsValue = Integer.MAX_VALUE;
        
        for(int[] row: matrix){
            for(int value : row){
                matrixSum += Math.abs(value);
                
                if(value < 0) numNegatives++;
                
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }
        
        if(numNegatives % 2 != 0) matrixSum -= 2 * minAbsValue;
        
        return matrixSum;
    }
}