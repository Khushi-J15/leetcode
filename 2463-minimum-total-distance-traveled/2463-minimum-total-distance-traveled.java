class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
       Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        
        List<Integer> factoryPositions = new ArrayList<>();
        
        for(int[] f : factory){
            for(int i=0; i<f[1]; i++){
                factoryPositions.add(f[0]);        
            }
        }
        
        int robotCount = robot.size();
        int factoryCount = factoryPositions.size();
        
        // Initialize dp array 
        long[][] dp = new long[robotCount + 1][factoryCount + 1];
        
        for(int i=0; i<robotCount; i++){
            dp[i][factoryCount] = (long) 1e12;
        }
        
        // Fill dp table bottom-up
        
        for(int i = robotCount - 1; i>=0; i--){
            for(int j = factoryCount - 1; j>=0; j--){
                long assign = Math.abs(robot.get(i) - factoryPositions.get(j)) + dp[i+1][j+1];
                long skip = dp[i][j+1];
                dp[i][j] = Math.min(assign, skip);
            }
        }
        
        return dp[0][0];
    }
}