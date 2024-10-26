/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, int[]> map = new HashMap<>(); // for storing height, depth
        Map<Integer, int[]> levels = new HashMap<>(); // for storing max, second max height
        
        int max = dfs(root,0,map,levels) - 1;
        
        int n = queries.length;
        
        for(int i=0; i<n; i++){
            int q = queries[i];
            int[] node = map.get(q);
            int height = node[0];
            int level = node[1];
            int[] lev = levels.get(level); // we'll get max 2 heights 
            
            if(lev[0] == height){
                if(lev[1] != -1){
                    queries[i] = max - Math.abs(lev[0] - lev[1]);
                }else{
                    queries[i] = max - height - 1;
                }
            }else{
                queries[i] = max;
            }
        }
        return queries;
    }
    
    public int dfs(TreeNode root, int level, Map<Integer, int[]> map, Map<Integer, int[]> levels){
        if(root == null) return 0;
        
        int left = dfs(root.left, level+1, map, levels);
        int right = dfs(root.right, level+1, map, levels);
        
        int height = Math.max(left,right);
        
        // updation of HashMaps
        int[] lev = levels.getOrDefault(level, new int[]{-1,-1});
        if(height >= lev[0]){
            lev[1] = lev[0];
            lev[0] = height;
        }
        else{
            lev[1] = Math.max(lev[1], height);
        }
        
        levels.put(level, lev);
        map.put(root.val, new int[]{height, level});
        
        return Math.max(left, right) + 1;
    }
}