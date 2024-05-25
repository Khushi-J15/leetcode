class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        return helperWordBreak(s, 0, hs);
    }
    
    public List<String> helperWordBreak(String s, int start, HashSet<String> dict){
        List<String> validSubString = new ArrayList<>();
        
        if(start == s.length()) validSubString.add("");
        
        for(int end = start + 1; end <= s.length(); end++){
            String prefix = s.substring(start, end);
            if(dict.contains(prefix)){
                List<String> suffixes = helperWordBreak(s, end, dict);
                for(String suffix : suffixes){
                    validSubString.add(prefix + (suffix.equals("") ? "" : " ") + suffix);
                }
            }
        }
        
        return validSubString;
    }
}