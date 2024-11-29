class Solution {
    public int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        
        int rows = grid.length, cols = grid[0].length;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[rows][cols];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        pq.add(new int[] {grid[0][0], 0, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0], row = curr[1], col = curr[2];
            
            if(row == rows - 1 && col == cols - 1) return time;
            
            if(visited[row][col]) continue;
            
            visited[row][col] = true;
            
            for(int[] d : directions){
                int newRow = row + d[0], newCol = col + d[1];
                if(!isValid(visited, newRow, newCol)) continue;
                int waitTime = ((grid[newRow][newCol] - time) % 2 == 0) ? 1 : 0;
                int nextTime = Math.max(grid[newRow][newCol] + waitTime, time + 1);
                pq.add(new int[] { nextTime, newRow, newCol });
            }
        }
        
        return -1;
    }
    
    private boolean isValid(boolean[][] visited, int row, int col){
        return (row >= 0 &&
                col >= 0 &&
                row < visited.length &&
                col < visited[0].length &&
                !visited[row][col]);
    }
}



