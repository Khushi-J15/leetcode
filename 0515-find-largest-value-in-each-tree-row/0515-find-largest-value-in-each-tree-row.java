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
    
    public List<Integer> largestValues(TreeNode root) {
        List<List<Integer>> list = levelOrderTraversal(root);
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i<list.size(); i++){
            
            List<Integer> curLevel = list.get(i);
            
            int max = curLevel.get(0);
            
            for(int j=0; j<curLevel.size(); j++){
                if(max < curLevel.get(j)){
                    max = curLevel.get(j);
                }
            }
            
            res.add(max);
        }
        
        return res;
    }
    
    private List<List<Integer>> levelOrderTraversal(TreeNode root){
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            
           for(int i=0; i<size; i++){
               TreeNode curr = queue.poll();
               level.add(curr.val);
               
               if(curr.left != null){
                   queue.add(curr.left);
               }
               if(curr.right != null){
                   queue.add(curr.right);
               }
           }
            
           result.add(level);
        }
        
        return result;
    }
}


