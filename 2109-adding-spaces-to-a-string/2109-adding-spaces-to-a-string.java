class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        
        Set<Integer> set = new HashSet<>();
        
        for(int i : spaces){
            set.add(i);
        }
        
        for(int i=0; i<s.length(); i++){
            if(set.contains(i)){
                sb.append(' ');
            }
            
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}