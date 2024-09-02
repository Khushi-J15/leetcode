class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long sum = 0;
        for(int i=0; i<n; i++){
            sum += chalk[i];
            if(sum > k) break;
        }
        
        k = k % (int) sum;
        for(int i=0; i<n; i++){
            if(k < chalk[i]){
                return i;
            } 
            k = k - chalk[i];
        }
        
        return 0;
    }
}