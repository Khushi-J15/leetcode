class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int maxIdenticalRows= 0;
        
        for(int[] currentRow : matrix){
            int[] flippedRow = new int[n];
            int count = 0;
            
            for(int i=0; i<n; i++){
                flippedRow[i] = Math.abs(currentRow[i] - 1);
            }
            
            for(int[] row : matrix){
                if(Arrays.equals(row, currentRow) || Arrays.equals(row, flippedRow)){
                    count++;
                }
            }
            
            maxIdenticalRows = Math.max(maxIdenticalRows, count);
        }
        
        return maxIdenticalRows;
    }
}