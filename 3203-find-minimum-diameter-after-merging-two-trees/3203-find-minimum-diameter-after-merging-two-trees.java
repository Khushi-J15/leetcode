class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        
        // Build Adjacency Lists for Both Trees 
        List<List<Integer>> adjList1 = buildAdjList(n, edges1);
        List<List<Integer>> adjList2 = buildAdjList(m, edges2);
        
        // Calculate diameters for both trees
        int dia1 = findDia(n, adjList1);
        int dia2 = findDia(m, adjList2);
        
        int combinedDia = (int) Math.ceil(dia1 / 2.0) + (int) Math.ceil(dia2 / 2.0) + 1;
        
        return Math.max(Math.max(dia1, dia2), combinedDia);
    }
    
    private List<List<Integer>> buildAdjList(int size, int[][] edges){
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0; i<size; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        return adjList;
    }
    
    private int findDia(int n, List<List<Integer>> adjList){
        Pair firstBFS = findFarthestNode(n, adjList, 0);
        int farthestNode = firstBFS.getFirst();
        
        Pair secondBFS = findFarthestNode(n, adjList, farthestNode);
        
        return secondBFS.getSecond();
    }
    
    private Pair findFarthestNode(int n, List<List<Integer>> adjList, int sourceNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceNode);
        boolean[] visited = new boolean[n];
        visited[sourceNode] = true;
        
        int maxDist = 0;
        int farthestNode = sourceNode;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                farthestNode = cur;
                
                for(int neigh : adjList.get(cur)){
                    if(!visited[neigh]){
                        visited[neigh] = true;
                        queue.add(neigh);
                    }
                }
            }
            
            if(!queue.isEmpty()) maxDist++;
        }
        
        return new Pair(farthestNode, maxDist);
    }
    
    class Pair {
        private int first;
        private int second;
        
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
        
        public int getFirst(){
            return first;
        }
        
        public int getSecond(){
            return second;
        }
    }
}