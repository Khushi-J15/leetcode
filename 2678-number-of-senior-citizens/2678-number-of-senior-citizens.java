class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        
        for(int i=0; i<details.length; i++){
            String s = details[i].substring(11,13);
            if(Integer.parseInt(s) > 60){
                count++;
            }
            else{
                continue;
            }
        }
        
        return count;
    }
}