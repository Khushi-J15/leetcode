class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        // Stack will store Pair like (0,1) ...
        List<Pair<Integer, Integer>> monoStack = new ArrayList<>(); 
        
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        
        List<List<Pair<Integer, Integer>>> newQueries = new ArrayList<>();
        
        for(int i=0; i<heights.length; i++){
            newQueries.add(new ArrayList<>());
        }
        
        for(int i=0; i<queries.length; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            // we have to make sure that b (index) is always greater >> and is on right 
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }
            
            if(heights[b] > heights[a] || a == b){
                result[i] = b;
            } else {
                newQueries.get(b).add(new Pair<>(heights[a], i));
            }
        }
        
        for(int i=heights.length - 1; i>=0; i--){ // Traversing from right
            int monoStackSize = monoStack.size();
            for(Pair<Integer, Integer> pair : newQueries.get(i)){
                // Apply binary Search on monoStack to get nearest greatest height
                int position = search(pair.getKey(), monoStack);
                if(position < monoStackSize && position >= 0){
                    result[pair.getValue()] = monoStack.get(position).getValue();
                }
            }
            
            while(!monoStack.isEmpty() 
                  && monoStack.get(monoStack.size() - 1).getKey() <= heights[i]){
                monoStack.remove(monoStack.size() - 1);
            }
            
            monoStack.add(new Pair<>(heights[i], i));
        }
        
        return result;
    }
    
    public int search(int height, List<Pair<Integer, Integer>> monoStack){
        int left = 0, right = monoStack.size() - 1;
        int ans = -1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(monoStack.get(mid).getKey() > height){
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return ans;
    }
}

 // the top element gives the position of the next taller building