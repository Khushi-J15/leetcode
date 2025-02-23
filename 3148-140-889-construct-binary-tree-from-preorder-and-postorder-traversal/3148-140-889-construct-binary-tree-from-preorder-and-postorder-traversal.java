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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int numOfNodes = preorder.length;
        return constructTree(0, numOfNodes - 1, 0, preorder, postorder);
    }

    public TreeNode constructTree(int preStart, int preEnd, int postStart, int[] preOrder, int[] postOrder){
        if(preStart > preEnd) return null;
        if(preStart == preEnd) return new TreeNode(preOrder[preStart]);

        int leftRoot = preOrder[preStart + 1];
        int numOfNodesInLeft = 1;

        while(postOrder[postStart + numOfNodesInLeft - 1] != leftRoot){
            numOfNodesInLeft++;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        root.left = constructTree(preStart + 1, preStart + numOfNodesInLeft, postStart, preOrder, postOrder);
        root.right = constructTree(preStart + numOfNodesInLeft + 1, preEnd, postStart + numOfNodesInLeft, preOrder, postOrder); 

        return root;
    }
}