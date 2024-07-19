class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<m; i++){
            int min = Integer.MAX_VALUE;
            int minj = -1;
            for(int j=0; j<n; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minj = j;
                }
            }
            
            boolean flag = true;
            
            for(int k=0; k<m; k++){
                if(matrix[k][minj] > min) flag = false;
            }
            
            if(flag) res.add(min);
        }
        
        return res;
    }
}