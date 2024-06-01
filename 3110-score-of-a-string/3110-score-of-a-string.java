class Solution {
    public int scoreOfString(String s) {
        int[] arr = new int[s.length()];
        int result = 0;
        
        for(int i=0; i<s.length(); i++){
           arr[i] = s.charAt(i);
        }
        
        for(int j=0; j<arr.length - 1; j++){
            result += Math.abs((int)arr[j] - (int)arr[j+1]);
        }
        return result;
    }
}