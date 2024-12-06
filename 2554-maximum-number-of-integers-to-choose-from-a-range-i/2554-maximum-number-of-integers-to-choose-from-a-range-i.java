import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Create a set for banned numbers
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        
        int count = 0;
        
        // Create a set of usable numbers from 1 to n, excluding banned ones
        Set<Integer> usableSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if(maxSum - i < 0){
                return count;
            } 
            else {
                maxSum = maxSum - i;
                count++;
            }
        }
        
        return count;
    }
}
