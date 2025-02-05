class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;

        char[] s1FreqMap = new char[26];
        char[] s2FreqMap = new char[26];

        int differCount = 0;

        for(int i=0; i<s1.length(); i++){
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if(s1Char != s2Char){
                differCount++;
                if(differCount > 2) return false;
            }

            s1FreqMap[s1Char - 'a']++;
            s2FreqMap[s2Char - 'a']++;
        }

        return Arrays.equals(s1FreqMap, s2FreqMap);
        
    }
}