class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
       Map<Character, Integer> freqMap = new HashMap<>();
       
       for(char c : s.toCharArray()){
           freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
       } 
        
       PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> Character.compare(b,a));
        
       for(char c : freqMap.keySet()){
           maxHeap.offer(c);
       } 
        
        StringBuilder res = new StringBuilder();
        
       while(!maxHeap.isEmpty()){
           char ch = maxHeap.poll();
           int count = freqMap.get(ch);
           int times = Math.min(repeatLimit, count);
           
           for(int i=0; i<times; i++){
               res.append(ch);
           }
           
           freqMap.put(ch, count - times);
           
           if(!maxHeap.isEmpty() && freqMap.get(ch) > 0){
               char nextCh = maxHeap.poll();
               res.append(nextCh);
               freqMap.put(nextCh, freqMap.get(nextCh) - 1);
               if(freqMap.get(nextCh) > 0){
                   maxHeap.offer(nextCh);
               }
               maxHeap.offer(ch);
           }
           
       }
        
       return res.toString(); 
        
    }
}