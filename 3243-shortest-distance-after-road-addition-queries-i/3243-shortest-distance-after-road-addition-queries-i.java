class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer> answer = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i<n-1; i++){
            adjList.get(i).add(i+1);
        }
        
        for(int[] road: queries){
            int u = road[0];
            int v = road[1];
            adjList.get(u).add(v);
            
            answer.add(findMinDistance(adjList, n));
        }
        
        int[] result = new int[answer.size()];
        
        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
    
    public int findMinDistance(List<List<Integer>> adjList, int n){
        int[] dp = new int[n];
        dp[n-1] = 0;
        
        for(int curNode = n-2; curNode >=0; curNode--){
            int minDistance = n;
            
            for(int neighbour : adjList.get(curNode)){
                minDistance = Math.min(minDistance, dp[neighbour] + 1);
            }
            dp[curNode] = minDistance;
        }
        
        return dp[0];
    }
}