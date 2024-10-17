class Solution {
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        int n = numStr.length();
        int maxNum = num;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                char[] arr = numStr.toCharArray();
                
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                int tempNum = Integer.parseInt(new String(arr));
                
                maxNum = Math.max(maxNum, tempNum);
            }
        }
        
        return maxNum;
    }
}