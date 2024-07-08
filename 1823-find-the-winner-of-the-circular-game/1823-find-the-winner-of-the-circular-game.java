class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1; i<=n; i++) q.offer(i);
        
        while(q.size() > 1){
           for(int j=1; j<k; j++){
               q.offer(q.poll());
           } 
           q.poll();    
        }
        
        return q.poll();
    }
}