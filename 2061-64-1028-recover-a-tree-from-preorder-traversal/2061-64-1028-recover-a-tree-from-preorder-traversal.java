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
    
    static int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return helper(traversal, 0);    
    }

    private TreeNode helper(String traversal, int depth){
        if(index >= traversal.length()){
            return null;
        }

        int dashCount = 0;
        // count number of dashes 
        while((index + dashCount) < traversal.length() && traversal.charAt(index + dashCount) == '-'){
            dashCount++;
        }

        if(dashCount != depth) return null;

        //Move index past the dashes
        index += dashCount;

        int value = 0;
        // Extract the node value 
        while(index < traversal.length() && Character.isDigit(traversal.charAt(index))){
            value = value * 10 + (traversal.charAt(index) - '0');
            index++;
        }

        TreeNode node = new TreeNode(value);

        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);

        return node;
    }
}