class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0] - b[0]);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxBeauty = 0;
        
        for(int[] item: items){
            maxBeauty = Math.max(maxBeauty, item[1]);
            map.put(item[0], maxBeauty);
        }
        
        int[] ans = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int query = queries[i];
            int index = binarySearch(items, query);
            ans[i] = map.getOrDefault(index >= 0 ? items[index][0] : 0, 0);
        }
        
        return ans;
    }
    
    private int binarySearch(int[][] items, int query){
        int left = 0; 
        int right = items.length - 1;
        
        while(left <= right){
            int mid = left + ( right - left )/2;
            if(items[mid][0] <= query){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}