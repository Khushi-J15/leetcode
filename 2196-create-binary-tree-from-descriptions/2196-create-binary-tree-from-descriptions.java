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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for(int[] desc : descriptions){
            int parent = desc[0];
            int child  = desc[1];
            boolean isLeft = desc[2] == 1;
            
            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));
            
            if(isLeft){
                map.get(parent).left = map.get(child);
            }
            else{
                map.get(parent).right = map.get(child);
            }
            
            children.add(child);
        }
        
        for(int[] desc: descriptions){
            if(!children.contains(desc[0])){
                return map.get(desc[0]);
            }
        }
        
        return null;
    }
}