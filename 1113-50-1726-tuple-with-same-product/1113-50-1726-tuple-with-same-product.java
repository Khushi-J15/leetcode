class Solution {
    public int tupleSameProduct(int[] nums) {
        int len = nums.length;
    
        int numberOfTuples = 0;

        Map<Integer, Integer> prodFreqMap = new HashMap<>();

        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int prod = nums[i] * nums[j];
                prodFreqMap.put(prod, prodFreqMap.getOrDefault(prod, 0) + 1);
            }
        }

        for(int prodVal : prodFreqMap.keySet()){
            int prodFreq = prodFreqMap.get(prodVal);

            int totalWays = (prodFreq * (prodFreq - 1)) / 2;

            numberOfTuples += totalWays * 8;
        }

        return numberOfTuples;
    }
}