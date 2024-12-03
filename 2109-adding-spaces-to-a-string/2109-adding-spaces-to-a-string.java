class Solution {
    public String addSpaces(String s, int[] spaces) {
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        
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