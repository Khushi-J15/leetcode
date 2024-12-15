class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0], a[0]));
        
        for(int[] c : classes){
            int pass = c[0], total = c[1];
            double improvement = gain(pass, total);
            pq.offer(new double[]{improvement, pass, total});
        }
        
        for(int i=0; i< extraStudents; i++){
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            pass++; // Add one extra student
            total++; // update total students
            
            double newImprovement = gain(pass, total);
            pq.offer(new double[]{newImprovement, pass, total});
        }
        
        double totalRatio = 0.0;
        
        while(!pq.isEmpty()){
            double[] top = pq.poll();
            int pass = (int) top[1], total = (int) top[2];
            totalRatio += (double) pass/ total;
        }
        
        return totalRatio/ classes.length;
    }
    
    public double gain(int pass, int total){
        return ((double) (pass + 1)/ (total + 1)) - ((double) pass/ total);
    }
}