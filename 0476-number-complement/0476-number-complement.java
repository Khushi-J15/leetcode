class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        String res = "";
        
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                res += "0";
            }
            else{
                res += "1";    
            }
        }
        
        return Integer.parseInt(res,2);
    }
}