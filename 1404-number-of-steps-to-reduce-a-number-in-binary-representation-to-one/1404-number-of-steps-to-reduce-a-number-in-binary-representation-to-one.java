class Solution {
    public int numSteps(String s) {
        int carry = 0;
        int ans = 0;
        int n = s.length();
        
        for(int i=n-1; i>=1; i--){
            if((s.charAt(i) + carry)%2 == 1){ // odd => add one + right shift
                ans += 2;
                carry = 1;
            }
            else{ // even => only right shift
                ans += 1;
            }
        }
        
        return ans + carry;
    }
}