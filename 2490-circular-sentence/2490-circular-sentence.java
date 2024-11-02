class Solution {
    public boolean isCircularSentence(String sentence) {
        List<String> al = new ArrayList<>();
        String[] strArray = sentence.split(" ");
        
        for(int i=0; i<strArray.length; i++){
            al.add(strArray[i]);
        }
        
        for(int i=0; i<strArray.length; i++){
            String str1 = strArray[i];
            String str2 = strArray[(i+1)%strArray.length];
            
            char ch1 = str1.charAt(str1.length()-1);
            char ch2 = str2.charAt(0);
            
            if(ch1 != ch2){
                return false;
            }
        }
        
        return true;
    }
}