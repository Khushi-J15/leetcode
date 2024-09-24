class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> prefixMap = new HashMap<>();
        
        for(int num : arr1){
            String str = Integer.toString(num);
            String prefix = "";
            for(char c : str.toCharArray()){
                prefix += c;
                prefixMap.put(prefix, prefixMap.getOrDefault(prefix, 0) + 1);
            }
        }
        
        int maxLength = 0;
        
        for(int num : arr2){
            String str = Integer.toString(num);
            String prefix = "";
            for(char c : str.toCharArray()){
                prefix += c;
                if(prefixMap.containsKey(prefix)){
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }
        
        return maxLength;
    }
}