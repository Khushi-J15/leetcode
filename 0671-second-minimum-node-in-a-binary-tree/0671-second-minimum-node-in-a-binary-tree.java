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
    public void solve(TreeNode root, TreeSet s){
        if(root != null){
            s.add(root.val);
            solve(root.left, s);
            solve(root.right, s);
        }    
    }
    
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> s = new TreeSet<>();
        solve(root, s);
        
        s.pollFirst();
        
        if(!s.isEmpty()){
          return s.first();
        }
        return -1;
    }
}