class Solution {
    public int passThePillow(int n, int time) {
        int completed = time/(n-1);
        int remaining = time%(n-1);
        int ans = 0;
        
        if(completed%2 == 0){ // even
            ans = remaining + 1;
        }
        else{ // odd
            ans = n - remaining;
        }
        
        return ans;
    }
}