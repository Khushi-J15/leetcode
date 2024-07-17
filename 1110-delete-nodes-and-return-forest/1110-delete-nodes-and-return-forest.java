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
     List<TreeNode> res;
     Set<Integer> to_delete_set;
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        to_delete_set = new HashSet<>();
        
        for(int i : to_delete){
            to_delete_set.add(i);    
        }
        
        helper(root, true);
        return res;
    }
    
    public TreeNode helper(TreeNode node, boolean is_root){
        if(node == null) return null;
        
        boolean deleted = to_delete_set.contains(node.val);
        if(!deleted && is_root) res.add(node);
        node.left = helper(node.left, deleted);
        node.right = helper(node.right, deleted);
        return deleted ? null : node;
        
    }
}