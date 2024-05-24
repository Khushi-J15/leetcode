class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
       for(char c1 : s.toCharArray()){
           c ^= c1;
       }
        for(char c2 : t.toCharArray()){
           c ^= c2;
       }
        return c;
    }
}