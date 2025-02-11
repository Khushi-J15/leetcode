class Solution {
    public String removeOccurrences(String s, String part) {
        
        while(s.contains(part)){
            int partStartIndex = s.indexOf(part);
            s = s.substring(0, partStartIndex) + s.substring(partStartIndex + part.length());
        }

        return s;
    }
}