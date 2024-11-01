class Solution {
    public String makeFancyString(String s) {
        char prev = s.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        sb.append(s.charAt(0));
        int frequency = 1;
        
        for(int i=1; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(c != prev){
                frequency = 1;
                prev = c;
            } else if(c == prev){
                frequency++;
            }
            
            if(frequency < 3){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}