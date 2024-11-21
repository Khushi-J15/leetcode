class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] visited = new int[m][n];
        
        for(int[] g : guards){
            visited[g[0]][g[1]] = 3;
        }
        
        for(int[] w : walls){
            visited[w[0]][w[1]] = 2;
        }
        
        int unguarded = 0;
        
        for(int[] g : guards){
            int row = g[0];
            int col = g[1];
            
            for(int i = row + 1; i<m; i++){
                if(visited[i][col] == 2 || visited[i][col] == 3) break;
                visited[i][col] = 1;
            }
            
            for(int i= row - 1; i>=0; i--){
                if(visited[i][col] == 2 || visited[i][col] == 3) break;
                visited[i][col] = 1;
            }
            
            for(int i=col + 1; i<n; i++){
                if(visited[row][i] == 2 || visited[row][i] == 3) break;
                visited[row][i] = 1;
            }
            
            for(int i= col - 1; i>=0; i--){
                if(visited[row][i] == 2 || visited[row][i] == 3) break;
                visited[row][i] = 1;
            }
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0) unguarded++;
            }
        }
        
        return unguarded;
        
    }
}