class Solution {
    int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0} };
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[] {0,0,0} );

        int nRows = grid.length;
        int nCols = grid[0].length;
        int[][] minCost = new int[nRows][nCols];
        
        for(int row = 0; row < nRows; row++){
            Arrays.fill(minCost[row], Integer.MAX_VALUE);
        }

        minCost[0][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0], row = curr[1], col = curr[2];

            if(minCost[row][col] != cost) continue;

            for(int dir = 0; dir < 4; dir++){
                int newRow = row + dirs[dir][0];
                int newCol = col + dirs[dir][1];

                if(newRow < nRows && newCol < nCols && newRow >= 0 && newCol >= 0){
                    int newCost = cost + (dir != (grid[row][col] - 1) ? 1 : 0);

                    if(minCost[newRow][newCol] > newCost){
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[] {newCost, newRow, newCol});
                    }
                }
            }
        }

        return minCost[nRows - 1][nCols - 1];
    }
}