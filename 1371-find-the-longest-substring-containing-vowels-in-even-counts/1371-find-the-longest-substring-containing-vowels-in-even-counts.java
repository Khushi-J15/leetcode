class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 1);
        vowels.put('e', 2);
        vowels.put('i', 4);
        vowels.put('o', 8);
        vowels.put('u', 16);
        
        HashMap<Integer, Integer> firstOcc = new HashMap<>();
        firstOcc.put(0,-1);
        int maxLen = 0, mask = 0;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(vowels.containsKey(c)){
                mask ^= vowels.get(c);
            }
            
            if(firstOcc.containsKey(mask)){
               maxLen = Math.max(maxLen, i - firstOcc.get(mask));
            }
            
            else{
                firstOcc.put(mask, i);    
            }
        }
        
        return maxLen;
    }
}