class Solution {
    public boolean canConstruct(String s, int k) {
        if(k > s.length()) return false;

        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(char c : s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c,0) + 1);
        }

        int oddCount = 0;
        for(int value : freqMap.values()){
            if(value%2 != 0) oddCount++;
        }

        return oddCount <= k;
    }
}