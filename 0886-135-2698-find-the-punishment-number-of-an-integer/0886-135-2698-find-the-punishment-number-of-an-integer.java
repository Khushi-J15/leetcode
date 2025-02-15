class Solution {
    public int punishmentNumber(int n) {
        int punishNum = 0;

        for(int i=1; i<=n; i++){
            int currNum = i;
            int sqNum = currNum * currNum;
            String stringNum = Integer.toString(sqNum);

            int[][] memoArray = new int[stringNum.length()][currNum + 1];

            for(int[] row : memoArray){
                Arrays.fill(row, -1);
            }

            boolean flag = findPartitions(0, 0, stringNum, currNum, memoArray);

            if(flag == true){
                punishNum += sqNum;
            }
        }

        return punishNum;

    }

    private boolean findPartitions(int startIndex, int sum, String stringNum, int target, int[][] memo){
        if(startIndex == stringNum.length()) return sum == target;

        if(sum > target) return false;

        if(memo[startIndex][sum] != -1) return memo[startIndex][sum] == 1;

        boolean partitionFound = false;

        for(int i=startIndex; i < stringNum.length(); i++){
            String currString = stringNum.substring(startIndex, i+1);
            int addend = Integer.parseInt(currString);

            partitionFound = partitionFound || findPartitions(i + 1, sum + addend, stringNum, target, memo);

            if(partitionFound){
                memo[startIndex][sum] = 1;
                return true;
            }
        }

        memo[startIndex][sum] = 0;
        return false;
    }

}