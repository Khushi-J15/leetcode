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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);
        
        while(!bfsQ.isEmpty()){
            // level order traversal
            int size = bfsQ.size();
            long sum = 0;
            for(int i=0; i<size; i++){
                TreeNode poppedNode = bfsQ.remove();
                sum += poppedNode.val;
                if(poppedNode.left != null){
                    bfsQ.add(poppedNode.left);
                }
                if(poppedNode.right != null){
                    bfsQ.add(poppedNode.right);
                }
            }
            
            pq.add(sum);
            if(pq.size() > k) pq.remove();
        }
        
        if(pq.size() < k) return -1;
        return pq.peek();
    }
}