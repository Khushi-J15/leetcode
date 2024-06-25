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
    int globalSum;
    public TreeNode bstToGst(TreeNode root) {
        globalSum = 0;
        solve(root);
        return root;
    }
    
    public void solve(TreeNode root){
        if(root == null) return;
        
        solve(root.right);
        globalSum += root.val;
        root.val = globalSum;
        solve(root.left);
        
        return;
    }
}