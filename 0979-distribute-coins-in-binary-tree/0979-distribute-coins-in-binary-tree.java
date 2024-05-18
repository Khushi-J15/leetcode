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
    int moves;
    public int distributeCoins(TreeNode root) {
        moves = 0;
        get_coins(root);
        return moves;
    }
    
    public int get_coins(TreeNode root){
        if(root == null) return 0;
        
        int left = get_coins(root.left);
        int right = get_coins(root.right);
        
        moves += Math.abs(left) + Math.abs(right);
        
        return root.val + left + right - 1;

    }
}