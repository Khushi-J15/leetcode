class Solution {
    public double averageWaitingTime(int[][] customers) {
        int busyUptill = 0;
        double waitingTime = 0;
        int n = customers.length;
        
        for(int i=0; i<n; i++){
            int arrival = customers[i][0];
            int time = customers[i][1];
            waitingTime += (Math.max(arrival, busyUptill) + time - arrival);
            busyUptill = Math.max(arrival, busyUptill) + time;
        }
        
        double ans = (waitingTime * 1.0) / n;
        return ans;
    }
}