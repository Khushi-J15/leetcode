class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                }
            }
        }
        
        int total = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                total += matrix[i][j];
            }
        }
        
        return total;
    }
}