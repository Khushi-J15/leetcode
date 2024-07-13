class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        List<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int index = 0; index < n; ++index) {
            indices[index] = index;
        }
        
        Arrays.sort(
            indices,
            (a,b) -> Integer.compare(positions[a], positions[b])
        );
        
        
        for(int curIndex : indices){
            if(directions.charAt(curIndex) == 'R') st.push(curIndex);
            else{
                while(!st.isEmpty() && healths[curIndex] > 0){
                    int topIndex = st.pop();
                    if(healths[topIndex] > healths[curIndex]){
                        healths[curIndex] = 0;
                        healths[topIndex] -= 1;
                        st.push(topIndex);
                    }
                    else if(healths[curIndex] > healths[topIndex]){
                        healths[topIndex] = 0;
                        healths[curIndex] -= 1;
                    }
                    else{
                        healths[curIndex] = 0;
                        healths[topIndex] = 0;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(healths[i] > 0) result.add(healths[i]);
        }
        
        return result;
    }
}