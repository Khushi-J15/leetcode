/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int res[][] = new int[m][n];
        
        for(int[] row : res){
            Arrays.fill(row,-1);
        }
        
        int left = 0, right = n-1, top = 0, bottom = m-1;
        
        ListNode curr = head;
        
        while(left <= right && top <= bottom && curr != null){
            
            for(int i=left; i<= right && curr!= null; i++){
                res[top][i] = curr.val;
                curr = curr.next;
            }
            top++;
            
            for(int i=top; i<= bottom && curr != null; i++){
                res[i][right] = curr.val;
                curr = curr.next;
            }
            right--;
            
            for(int i=right; i>=left && curr != null; i--){
                res[bottom][i] = curr.val;
                curr = curr.next;
            }
            bottom--;
            
            for(int i=bottom; i>=top && curr != null; i--){
                res[i][left] = curr.val;
                curr = curr.next;
            }
            left++;
        }
        return res;
    }
}