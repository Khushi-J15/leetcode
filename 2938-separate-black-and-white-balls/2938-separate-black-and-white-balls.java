class Solution {
    public long minimumSteps(String s) {
        long totalSwaps = 0;
        int whitePos = 0;
        
        for(int cur=0; cur<s.length(); cur++){
            if(s.charAt(cur) == '0'){
                totalSwaps += cur - whitePos;
                whitePos++;
            }
        }
        
        return totalSwaps;
    }
}