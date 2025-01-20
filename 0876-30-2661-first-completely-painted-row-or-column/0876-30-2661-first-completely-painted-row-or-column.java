class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<Integer, int[]> numPos = new HashMap<>();
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int val = mat[row][col];
                numPos.put(val, new int[] {row, col});
            }
        }

        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            int[] pos = numPos.get(num);
            int row = pos[0], col = pos[1];

            rowCount[row]++;
            colCount[col]++;

            if(rowCount[row] == cols || colCount[col] == rows){
                return i;
            }
        }

        return -1;
    }
}