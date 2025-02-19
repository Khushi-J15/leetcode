class Solution {

    List<String> happyStrings = new ArrayList<>();

    public String getHappyString(int n, int k) {
        String str = "";
        backtrack(n, str);

        if(happyStrings.size() < k) return "";
        
        Collections.sort(happyStrings);
        return happyStrings.get(k - 1);
    }

    private void backtrack(int n, String str){
        if(str.length() == n){
            happyStrings.add(str);
            return;
        }
        // for each char in arr.
        for(char currChar = 'a'; currChar <= 'c'; currChar++){
            if(str.length() > 0 && currChar == str.charAt(str.length() - 1)){
                continue;
            }
            backtrack(n, str + currChar);
        }
    }
}