class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int n = s.length();

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                ones++;
            }
        }

        int zeros = 0;
        int max = 0;

        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '1'){
                ones--;
            } else {
                zeros++;
            }

            max = Math.max(max, ones + zeros);
        }

        return max;
    }
}