class Solution {
    public int maximumSum(int[] nums) {
        int[] maxSum = new int[82];
        int ans = -1;

        for(int num : nums){
            int sum = 0;
            int temp = num;

            while(temp != 0){
                sum += temp % 10;
                temp /= 10;
            }

            if(maxSum[sum] != 0){
                ans = Math.max(ans, num + maxSum[sum]);
            }

            maxSum[sum] = Math.max(maxSum[sum], num);
        }

        return ans;
    }
}