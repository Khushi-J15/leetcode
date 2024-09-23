import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
    
      int n = s.length();
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1] + 1;
            for (int j = i; j < n; j++) {
                var curr = s.substring(i, j + 1);
                if (dictionarySet.contains(curr)) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}