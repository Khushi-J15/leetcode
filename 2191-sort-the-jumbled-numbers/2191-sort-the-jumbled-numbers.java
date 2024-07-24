class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
            int[] mapped = new int[nums.length];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int number = nums[i];
                int idx = 1;
                int mappedNumber = 0;
                while (number > 0) {
                    int remainder = number % 10;
                    mappedNumber = mappedNumber + (mapping[remainder] * idx);
                    number = number / 10;
                    idx *= 10;
                }
                if (nums[i] == 0) {
                    mappedNumber = mapping[0];
                }
                mapped[i] = mappedNumber;
                if (!map.containsKey(mapped[i])) {
                    map.put(mapped[i], new ArrayList<>());
                }
                map.get(mapped[i]).add(nums[i]);
            }
            Arrays.sort(mapped);
            int idx = 0;
            for (int i = 0; i < mapped.length; i++) {
                if (map.containsKey(mapped[i])) {
                    for (int val : map.get(mapped[i])) {
                        nums[idx] = val;
                        idx++;
                    }
                }
                map.remove(mapped[i]);
            }
            return nums;
    }
}