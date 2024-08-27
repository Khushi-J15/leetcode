class Solution {
    
    static class Pair{
        int node;
        double prob;
        Pair(int n , double p){
            this.node = n;
            this.prob = p;
        }
    }
    
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++){
            int temp[] = edges[i]; // arraylist me add krna Pair ko 
            adj.get(temp[0]).add(new Pair(temp[1], succProb[i]));
            adj.get(temp[1]).add(new Pair(temp[0], succProb[i]));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        double[] curr_prob = new double[n];
        curr_prob[start_node] = 1;
        q.offer(new Pair(start_node, 1));
        
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int node = pair.node;
            double prob = pair.prob;
            
            if(node == end_node) return prob;
            
            for(Pair i: adj.get(node)){
                if(curr_prob[i.node]<i.prob*prob){
                    curr_prob[i.node]=i.prob*prob;
                    q.offer(new Pair(i.node, i.prob*prob));
                }
            }
        }
        
        return 0.0;
        
    }
}

