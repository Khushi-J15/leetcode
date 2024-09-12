class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        boolean[] isAllowed = new boolean[26];
        
        for(int i=0; i<allowed.length(); i++){
            isAllowed[allowed.charAt(i) - 'a'] = true;
        }
        
        for(String word : words){
            boolean isConsistent = true;
            
            for(int i=0; i<word.length(); i++){
                if(!isAllowed[word.charAt(i) - 'a']){
                    isConsistent = false;
                    break;
                }
            }
            
            if(isConsistent){
                count++;
            }
        }
        
        return count;
        
    }
}