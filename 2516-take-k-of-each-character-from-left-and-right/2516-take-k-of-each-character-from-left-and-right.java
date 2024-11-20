class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int left = 0, right = 0;
        int totalA = 0, totalB = 0, totalC = 0;
        int a = 0, b = 0, c = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'a') totalA++;
            else if(ch == 'b') totalB++;
            else if(ch == 'c') totalC++;
        }
        
        if(totalA < k || totalB < k || totalC < k) return -1;
        
        int minMinutes = Integer.MAX_VALUE;
        
        while(right < n){
            if(s.charAt(right) == 'a') a++;
            else if(s.charAt(right) == 'b') b++;
            else if(s.charAt(right) == 'c') c++;
            right++;
            
            while(a > totalA-k || b > totalB-k || c > totalC-k){
                if(s.charAt(left) == 'a') a--;
                else if(s.charAt(left) == 'b') b--;
                else if(s.charAt(left) == 'c') c--;
                left++;
            }
            
            minMinutes = Math.min(minMinutes, n - (right - left));
        }
        
        return minMinutes;
    }
}