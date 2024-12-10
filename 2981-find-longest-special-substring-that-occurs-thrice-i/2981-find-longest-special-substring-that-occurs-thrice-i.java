class Solution {
    public int maximumLength(String s) {
       HashMap<String, Integer> substringCount = new HashMap<>();
        int n = s.length();
        
        for(int i=0; i<n; i++){
            for(int l=1; l <= n-i; l++){
                String substring = s.substring(i, i + l);
                
                if (isSpecial(substring)) {
                    // Count the occurrence of this special substring
                    substringCount.put(substring, substringCount.getOrDefault(substring, 0) + 1);
                }
            }
        }
        
        int maxLen = -1;
        
        for(String substring: substringCount.keySet()){
            if(substringCount.get(substring) >=3){
                maxLen = Math.max(maxLen, substring.length());
            }
        }
        
        return maxLen;
    }
    
    public boolean isSpecial(String s){
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) != s.charAt(0)) return false;
        }
        
        return true;
    }
}