class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
       Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        
        for(int value : arr2){
            countMap.put(value, 0);
        }
        
        for(int val : arr1){
            if(countMap.containsKey(val)){
                countMap.put(val, countMap.get(val) + 1); // increasing the frequency
            }
            else{
                remaining.add(val);
            }
        }
        
        Collections.sort(remaining);
        
        for(int value : arr2){
            for(int j=0; j<countMap.get(value); j++){
                result.add(value);
            }
        }
        
        result.addAll(remaining);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}