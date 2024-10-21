class Solution {
    public int maxUniqueSplit(String s) {
        return backTrack(0, s, new HashSet<String>());
    }
    
    public int  backTrack(int start, String s, HashSet<String> seen){
        if(start ==  s.length()) return 0;
        
        int maxSplits = 0;
        
        for(int end = start+1; end<= s.length(); end++){
            String str = s.substring(start, end);
            if(!seen.contains(str)){
                seen.add(str);
                maxSplits = Math.max(maxSplits, 1+ backTrack(end, s, seen));
                seen.remove(str);
            }
        }
        
        return maxSplits;
    }
}