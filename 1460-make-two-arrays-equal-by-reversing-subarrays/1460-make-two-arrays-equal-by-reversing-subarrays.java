class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;
        
        int[] freq1 = new int[1001];
        int[] freq2 = new int[1001];
        
        for(int i : target){
            freq1[i]++;
        }
        
        for(int i: arr){
            freq2[i]++;
        }
        
        if(Arrays.equals(freq1, freq2)) return true;
        
        return false;

    }
}