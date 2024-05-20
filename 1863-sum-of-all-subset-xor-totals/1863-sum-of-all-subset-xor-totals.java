class Solution {
    int sum = 0;
    
    public void dfs(int[] nums, int start, int prevSum){
        if(start >= nums.length) return;
        
        for(int i = start; i<nums.length; i++){
            int currentSum = prevSum ^ nums[i];
            sum += currentSum;
            dfs(nums, i+1, currentSum);
        }
    }
        
    public int subsetXORSum(int[] nums) {
        dfs(nums, 0, sum);
        return sum;
    }
}


// int sum = 0; // Initialize a variable to accumulate the sum of XOR values
    
//     // Entry point method to compute the subset XOR sum
//     public int subsetXORSum(int[] nums) {
//         dfs(nums, 0, sum); // Call the DFS function to explore subsets starting from index 0
//         return sum; // Return the accumulated sum
//     }
    
//     // Depth-first search method to explore subsets and calculate XOR sums
//     public void dfs(int[] nums, int start, int prevSum) {
//         if(start >= nums.length) { // Base case: If the start index exceeds array length, return
//             return;
//         }
        
//         for(int i = start; i < nums.length; i++) { // Iterate through the array from start index
//             int currentSum = prevSum ^ nums[i]; // Calculate XOR value of current element with previous sum
//             sum += currentSum; // Add current XOR sum to the total sum
//             dfs(nums, i + 1, currentSum); // Recursively explore subsets with updated parameters
//         }