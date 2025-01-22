class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] cellHeights = new int[m][n];
        
        for(int[] arr : cellHeights){
            Arrays.fill(arr, -1);
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<int[]> cellQueue = new LinkedList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(isWater[i][j] == 1){
                    cellQueue.add(new int[] {i,j});
                    cellHeights[i][j] = 0;
                }
            }
        }

        int heightOfNextLayer = 1;

        while(!cellQueue.isEmpty()){
            int size = cellQueue.size();

            for(int i=0; i<size; i++){
                int[] currentCell = cellQueue.poll();

                for(int d=0; d<4; d++){
                    int neighborX = currentCell[0] + dx[d];
                    int neighborY = currentCell[1] + dy[d];

                    if(isValid(neighborX, neighborY, m, n) && cellHeights[neighborX][neighborY] == -1){
                        cellHeights[neighborX][neighborY] = heightOfNextLayer;
                        cellQueue.add(new int[] {neighborX, neighborY});
                    }
                }
            }

            heightOfNextLayer++;
        }

        return cellHeights;
    }

    private boolean isValid(int i, int j, int m, int n){
        return (i>=0 && j>=0 && i<m && j<n);
    }
}