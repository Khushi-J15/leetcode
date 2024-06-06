class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        if((r*c) != rows * cols) return mat;
        int[][] output = new int[r][c];
        int output_r = 0;
        int output_c = 0;
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                output[output_r][output_c] = mat[i][j];
                output_c++;
                if(output_c == c){
                    output_c = 0;
                    output_r++;
                }
            }
        }
        return output;
    }
}