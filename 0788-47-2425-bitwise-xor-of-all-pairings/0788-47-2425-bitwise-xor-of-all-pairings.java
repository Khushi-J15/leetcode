class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int xor1 = 0, xor2 = 0;

        if(len2 % 2 != 0){ // when nums2 is odd length
            for(int num : nums1){
                xor1 ^= num;
            }
        }

        if(len1 % 2 != 0){  // when nums1 is odd length
            for(int num : nums2){
                xor2 ^= num;
            }
        }

        return xor1 ^ xor2;

    }
}