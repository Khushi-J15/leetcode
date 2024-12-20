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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Use a queue to perform a level-order traversal
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0; // Start from level 0 (root level)

        while (!queue.isEmpty()) {
            List<TreeNode> currentLevelNodes = new ArrayList<>();
            int size = queue.size();

            // Collect all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                currentLevelNodes.add(current);

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // Reverse values at odd levels
            if (level % 2 != 0) {
                int left = 0, right = currentLevelNodes.size() - 1;
                while (left < right) {
                    // Swap values
                    int temp = currentLevelNodes.get(left).val;
                    currentLevelNodes.get(left).val = currentLevelNodes.get(right).val;
                    currentLevelNodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++; // Move to the next level
        }

        return root;
    }
}