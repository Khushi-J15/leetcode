class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), s);
        return res;
    }
    
    public void dfs(List<List<String>> res, List<String> currList, String s){
        if(s.length() == 0){
            res.add(new ArrayList<String>(currList));
            return;
        }
        
        for(int i=0; i<s.length(); i++){
            if(checkPalindrome(s,0,i)){
                currList.add(s.substring(0, i+1));
                dfs(res, currList, s.substring(i+1));
                currList.remove(currList.size()-1);
            }
        }
    }
    
    private boolean checkPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}