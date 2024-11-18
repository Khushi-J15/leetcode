class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        
        if(k == 0) return ans;
        
        for(int i=0; i< ans.length; i++){
            if(k > 0){
                for(int j=i+1; j < i+k+1; j++){
                    ans[i] += code[j % code.length]; 
                } 
            } 
            else {
                for(int j= i - Math.abs(k); j<i; j++){
                    ans[i] += code[(j + code.length) % code.length]; 
                }
            }
        }
        
        return ans;
    }
}