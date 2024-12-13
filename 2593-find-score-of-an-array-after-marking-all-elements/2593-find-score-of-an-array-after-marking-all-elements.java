class Solution {
    public long findScore(int[] nums) {
        long score = 0;
        int n = nums.length;
        boolean[] marked = new boolean[n];
        int[][] sorted = new int[n][2];
        
        
        for(int i = 0; i<n; i++){
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        
        Arrays.sort(sorted, (arr1, arr2) -> arr1[0] - arr2[0]);
        
        for(int i=0; i<n; i++){
            int num = sorted[i][0];
            int idx = sorted[i][1];
            
            if(!marked[idx]){
                 score += num;
                marked[idx] = true;

                if(idx - 1 >= 0){
                    marked[idx - 1] = true;   
                }
                if(idx + 1 < nums.length){
                    marked[idx + 1] = true;
                }
            }
        }
        
        return score;
    }
}