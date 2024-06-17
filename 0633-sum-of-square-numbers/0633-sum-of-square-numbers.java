class Solution {
    public boolean judgeSquareSum(int c) {
       long left = 0;
       long right = (int)Math.sqrt(c);
        
        while(left <= right){
            long total = left * left + right * right;
            if(total == c) return true;
            else if(total < c) left++;
            else right--;
        }
        return false;
    }
}