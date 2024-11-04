class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int consecutiveCounts; 
        int pos = 0;
        
        while(pos < word.length()){
            char currentChar = word.charAt(pos);
            consecutiveCounts = 0;
            
            while(pos < word.length() &&
                 currentChar == word.charAt(pos) &&
                 consecutiveCounts < 9){
                pos++;
                consecutiveCounts++;
            }
            comp.append(consecutiveCounts).append(currentChar);
        }
        
        return comp.toString();
        
    }
}