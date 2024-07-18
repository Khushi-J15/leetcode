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
    private int noOfGoodPairs;
    
    public int countPairs(TreeNode root, int distance) {
        noOfGoodPairs = 0;
        dfs(root, distance);
        return noOfGoodPairs;
    }
    
    private List<Integer> dfs(TreeNode node, int distance){
        if(node == null) return new ArrayList<>();
        if(node.left == null && node.right == null) return Arrays.asList(1);
        
        List<Integer> leftList = dfs(node.left , distance);
        List<Integer> rightList = dfs(node.right, distance);
        
        for(int lc : leftList){
            for(int rc : rightList){
                if(lc + rc <= distance) noOfGoodPairs++;
            }
        }
        
        List<Integer> parentList = new ArrayList<>();
        
        for(int lc : leftList){
            if(lc + 1 <= distance) parentList.add(lc + 1);
        }
        
        for(int rc : rightList){
            if(rc + 1 <= distance) parentList.add(rc + 1);
        }
        
        return parentList;
    }
}