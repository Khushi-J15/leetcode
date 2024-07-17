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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        find(root, startValue, s);
        find(root, destValue, d);
        int i=0, j=0;
        
        s.reverse();
        d.reverse();
        
        while(i < s.length() && j < d.length()){
            if(s.charAt(i) == d.charAt(j)){
                i++;
                j++;
            }
            else break;
        }
         
       StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            sb.append("U");
            i++;
        }
        sb.append(d.substring(j));
        return sb.toString();
        
    }
    
    public boolean find(TreeNode n, int val, StringBuilder sb){
        if(n.val == val) return true;
        
        if(n.left != null && find(n.left, val, sb)) sb.append("L");
        else if(n.right != null && find(n.right, val, sb)) sb.append("R");
        
        return sb.length() > 0;
    }
}

