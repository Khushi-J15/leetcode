class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        
        for(int num : nums){
            uniqueSet.add(num);
        }
        
        int longestStreak = 0;
        
        for(int i=0; i<nums.length; i++){
            long current = nums[i];
            int currentStreak = 0;
            
            while(uniqueSet.contains((int) current)){
                currentStreak++;   
                if(current * current > 1e5) break;
                current *= current;
            }
            
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        
        return longestStreak < 2 ? -1 : longestStreak; 
    }
}