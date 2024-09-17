class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        
        HashMap<String, Integer> wordCount = new HashMap<>();
        for(String str : str1){
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        }
        
        for(String str : str2){
            wordCount.put(str, wordCount.getOrDefault(str, 0) + 1);
        }
        
        ArrayList<String> res = new ArrayList<>();
        
        for(String s : wordCount.keySet()){
            if(wordCount.get(s) == 1){
                res.add(s);
            }
        }
        
        String[] resArr = new String[res.size()];
        resArr = res.toArray(resArr);
        return resArr;
    }
}