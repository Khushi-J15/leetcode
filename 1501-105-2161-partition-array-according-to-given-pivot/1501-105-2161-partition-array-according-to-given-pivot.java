class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for(int num : nums){
            if(num < pivot){
                list1.add(num);
            } else if(num == pivot){
                list2.add(num);
            } else {
                list3.add(num);
            }
        }

        list2.addAll(list3);
        list1.addAll(list2);
        return list1.stream().mapToInt(Integer::intValue).toArray();
    }
}