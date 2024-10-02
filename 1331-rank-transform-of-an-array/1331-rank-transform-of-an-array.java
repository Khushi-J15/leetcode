class Solution {
    public int[] arrayRankTransform(int[] arr) {
     int[] arr2 = new int[arr.length];
    
        for(int i=0; i<arr.length; i++){
            arr2[i] = arr[i];
        }
        
        Arrays.sort(arr2);
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<arr2.length; i++){
            if(map.containsKey(arr2[i])){
                continue;
            }
             j++;
            map.put(arr2[i], j);
        }
        
        int[] res = new int[arr.length];
        
        for(int i=0; i<arr.length; i++){
            res[i] = map.get(arr[i]);
        }
        
        return res;
    }
}