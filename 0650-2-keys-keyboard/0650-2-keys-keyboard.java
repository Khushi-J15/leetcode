class Solution {
    public int minSteps(int n) {
        if(n == 1) return 0;
        
        int steps = 0;
        int factors = 2;
        
        while(n > 1){
            while(n % factors == 0){
                steps += factors;
                n /= factors;
            }
            factors++;
        }
        return steps;
    }
}