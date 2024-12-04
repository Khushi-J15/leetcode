class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();
        int str2Index = 0;
        
        for(int str1Index = 0; str1Index < str1Length && str2Index < str2Length; ++str1Index){
            if(str1.charAt(str1Index) == str2.charAt(str2Index) || 
               str1.charAt(str1Index) + 1 == str2.charAt(str2Index) ||
               str1.charAt(str1Index) - 25 == str2.charAt(str2Index)){
                str2Index++;
            }
        }
        
        return str2Index == str2Length;
    }
}