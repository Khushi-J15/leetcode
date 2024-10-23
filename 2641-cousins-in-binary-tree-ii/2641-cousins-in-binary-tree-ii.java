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
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> levelSums = new ArrayList<>();
        
        // First BFS
        while(!queue.isEmpty()){
            int levelSum = 0;
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode curNode = queue.poll();
                levelSum += curNode.val;
                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);
            }
            
            levelSums.add(levelSum);
        }
        
        // Second BFS
        queue.offer(root);
        int levelIndex = 1;
        root.val = 0;
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int i=0; i<levelSize; i++){
                TreeNode curNode = queue.poll();
                int siblingSum = (curNode.left != null ? curNode.left.val : 0) + (curNode.right != null ? curNode.right.val : 0);
                
                if(curNode.left != null){
                    curNode.left.val = levelSums.get(levelIndex) - siblingSum;
                    queue.offer(curNode.left);
                }
                if(curNode.right != null){
                    curNode.right.val = levelSums.get(levelIndex) - siblingSum;
                    queue.offer(curNode.right);
                }
            }
            levelIndex++;
        }
        
        return root;
    }
}