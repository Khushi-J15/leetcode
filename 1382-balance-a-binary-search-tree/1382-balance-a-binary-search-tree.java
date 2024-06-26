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
    List<TreeNode> sortedArr = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        inorderTraversal(root);
        return sortedArrayToBst(0, sortedArr.size() - 1);
    }
    
    private void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        sortedArr.add(root);
        inorderTraversal(root.right);
    }
    
    private TreeNode sortedArrayToBst(int start, int end){
        if(start > end) return null;
        
        int mid = ( start + end ) / 2;
        TreeNode node = sortedArr.get(mid);
         node.left = sortedArrayToBst(start, mid - 1);
         node.right = sortedArrayToBst(mid + 1, end);
        return node;
    }
    
}