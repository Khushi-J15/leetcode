class Solution {
    Map<Integer, Integer> bobPath;
    private boolean[] visited;
    private List<List<Integer>> tree; // adjacency List

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length, maxIncome = Integer.MIN_VALUE;
        bobPath = new HashMap<>();
        visited = new boolean[n];
        tree = new ArrayList<>();

        Queue<int[]> queue = new LinkedList<>(); // queue of integer arrays
        queue.add(new int[]{0,0,0});

        for(int i=0; i<n; i++){
            tree.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        findBobPath(bob, 0);

        Arrays.fill(visited, false);

        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int srcNode = node[0], time = node[1], income = node[2];

            if(!bobPath.containsKey(srcNode) || time < bobPath.get(srcNode)){
                income += amount[srcNode];
            }
            else if(time == bobPath.get(srcNode)){
                income += amount[srcNode] / 2;
            }
            if(tree.get(srcNode).size() == 1 && srcNode != 0){ // is a leaf node
                maxIncome = Math.max(maxIncome, income);
            }

            for(int adjacentNode : tree.get(srcNode)){
                if(!visited[adjacentNode]){
                    queue.add(new int[] {adjacentNode, time + 1, income});
                }
            }

            visited[srcNode] = true;
        }

        return maxIncome;
    }

    private boolean findBobPath(int src, int time){
        bobPath.put(src, time);
        visited[src] = true;

        if(src == 0) return true; // destination for bob is found.

        for(int adjacentNode : tree.get(src)){
            if(!visited[adjacentNode]){
                if(findBobPath(adjacentNode, time + 1)){
                    return true;
                }
            }
        }

        bobPath.remove(src);
        return false;
    }
}