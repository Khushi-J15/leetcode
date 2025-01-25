class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            numsSorted[i] = nums[i];
        }
        Arrays.sort(numsSorted);

        int currGrp = 0;
        HashMap<Integer, Integer> numToGrp = new HashMap<>();
        numToGrp.put(numsSorted[0], currGrp);

        HashMap<Integer, LinkedList<Integer>> grpToList = new HashMap<>();
        grpToList.put(currGrp, new LinkedList<Integer>(Arrays.asList(numsSorted[0])));

        // Iterate through rest of numsSorted
        for(int i=1; i<nums.length; i++){
            if(Math.abs(numsSorted[i] - numsSorted[i-1]) > limit){
                currGrp++;
            }
            numToGrp.put(numsSorted[i], currGrp);

            if(!grpToList.containsKey(currGrp)){
                grpToList.put(currGrp, new LinkedList<Integer>());
            }
            grpToList.get(currGrp).add(numsSorted[i]);
        }

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int group = numToGrp.get(num);
            nums[i] = grpToList.get(group).pop();
        }

        return nums;
    }
}