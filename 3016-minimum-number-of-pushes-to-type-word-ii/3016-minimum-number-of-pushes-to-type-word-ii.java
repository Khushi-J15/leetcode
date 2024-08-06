class Solution {
    
    static class Pair{
        int val;
        char c;
        Pair(int v, char c){
            this.val = v;
            this.c = c;
        }
    }
    
    public int minimumPushes(String word) {
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }
        
        List<Pair> list = new ArrayList<>();
        
        for(char c: freq.keySet()){
            list.add(new Pair(freq.get(c), c));
        }
        
        Collections.sort(list, (a,b) -> Integer.compare(b.val, a.val));
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<list.size(); i++){
            char c = list.get(i).c;
            if(map.size() <8 && !map.containsKey(c)) map.put(c,1);
            else if(map.size() >= 8){
                int count = map.size()/8;
                if(!map.containsKey(c)) map.put(c, count+1);
            }
        }
        
        int ans = 0;
        
        for(int i=0; i<list.size(); i++){
            char c = list.get(i).c;
            ans += map.get(c)*list.get(i).val;
        }
        
        return ans;
    }
}
