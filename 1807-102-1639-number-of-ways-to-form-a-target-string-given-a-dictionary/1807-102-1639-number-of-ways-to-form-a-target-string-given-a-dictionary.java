class Solution {
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        int targetLength = target.length();
        final int MOD = 1000000007;

        // Store the frequency of each character at every index of "words"
        int[][] charFrequency = new int[wordLength][26];

        for(String word : words){
            for(int j = 0; j < wordLength; ++j){
                charFrequency[j][word.charAt(j) - 'a']++;
            }
        }

        long[][] dp = new long[wordLength + 1][targetLength + 1];

        // One Way to Form an Empty Target String
        for(int i=0; i<=wordLength; ++i){
            dp[i][0] = 1;
        }

        for(int curWord=1; curWord <= wordLength; ++curWord){
            for(int curTarget=1; curTarget <= targetLength; ++curTarget){
                dp[curWord][curTarget] = dp[curWord - 1][curTarget];
                
                int curPos = target.charAt(curTarget - 1) - 'a';
                dp[curWord][curTarget] += (charFrequency[curWord - 1][curPos] * dp[curWord - 1][curTarget - 1])%MOD;
                dp[curWord][curTarget] %= MOD;
            }

        }

        return (int) dp[wordLength][targetLength];

    }
}