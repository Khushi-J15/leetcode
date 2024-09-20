class Solution {
    public String shortestPalindrome(String s) {
        int i = 0;
        int n = s.length();
        
        for(int j=0; j<n; j++){
            if(s.charAt(i) == s.charAt(n-1-j)){
                i++;
            }
        }
        
        if(i == n){
            return s;
        }
        
        String p = new StringBuilder(s.substring(i, n)).reverse().toString();
        return p + shortestPalindrome(s.substring(0, i)) + s.substring(i);
        
    }
}