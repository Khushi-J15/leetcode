class Solution {
    public int removeStones(int[][] stones) {
        if (stones.length == 0) return 0;

        Map<Integer, List<Integer>> rowMap = new HashMap<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();

        for (int[] stone : stones) {
            rowMap.computeIfAbsent(stone[0], k -> new ArrayList<>()).add(stone[1]);
            colMap.computeIfAbsent(stone[1], k -> new ArrayList<>()).add(stone[0]);
        }

        boolean[] visited = new boolean[stones.length];
        int removedStones = 0;

        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                removedStones += dfs(stones, i, rowMap, colMap, visited) - 1;
            }
        }
        return removedStones;
    }
    
    private int dfs(int[][] stones, int index, Map<Integer, List<Integer>> rowMap, Map<Integer, List<Integer>> colMap, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        visited[index] = true;
        int count = 0;

        while (!stack.isEmpty()) {
            int currIndex = stack.pop();
            count++;
            int[] currStone = stones[currIndex];
            int row = currStone[0];
            int col = currStone[1];

            for (int nextCol : rowMap.get(row)) {
                for (int nextRow : colMap.get(nextCol)) {
                    int nextIndex = findIndex(stones, nextRow, nextCol);
                    if (!visited[nextIndex]) {
                        visited[nextIndex] = true;
                        stack.push(nextIndex);
                    }
                }
            }
        }

        return count;
    }

    private int findIndex(int[][] stones, int row, int col) {
        for (int i = 0; i < stones.length; i++) {
            if (stones[i][0] == row && stones[i][1] == col) {
                return i;
            }
        }
        return -1;
    }

}