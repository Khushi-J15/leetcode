class Solution {
    private int[] dirs = {-1, 0, 1};
    
    private int DFS(int row, int col, int[][] grid, int[][] dp){
        int m = grid.length;
        int n = grid[0].length;
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int maxMoves = 0;
        
        for(int dir: dirs){
            int newRow = row + dir;
            int newCol = col + 1;
            
            if(newRow >=0 && newCol >= 0 &&
               newRow < m && newCol < n &&
              grid[row][col] < grid[newRow][newCol]){
                
                maxMoves = Math.max(maxMoves, 1 + DFS(newRow, newCol, grid, dp));
            }
        }
        
        dp[row][col] = maxMoves;
        return maxMoves;
    }
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        
        int maxMoves = 0;
        for(int i=0; i<m; i++){
            int movesReq = DFS(i, 0, grid, dp);
            maxMoves = Math.max(maxMoves, movesReq);
        }
        
        return maxMoves;
    }
}