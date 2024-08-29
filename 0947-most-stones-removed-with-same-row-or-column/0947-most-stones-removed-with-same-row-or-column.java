class Solution {
    int n;
    int[] parent;
    
    public int removeStones(int[][] stones) {
        n = stones.length;
        parent = new int[20001];
        
        for(int i=0; i<parent.length; i++){
            parent[i] = i;
        }
        
        for(int[] stone : stones){
            int x = stone[0];
            int y = stone[1] + 10001;
            union(x,y);
        }
        
        Set<Integer> components = new HashSet<>();
        
        for(int[] stone : stones)
            components.add(find(stone[0]));
        
        return n - components.size();
    }
    
    public void union(int i, int j){
        int parI = find(i);
        int parJ = find(j);
        parent[parI] = parJ;
    }
    
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    
    
}