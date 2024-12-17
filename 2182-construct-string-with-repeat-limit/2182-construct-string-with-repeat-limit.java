class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }

        // Step 3: Build the result string
        StringBuilder result = new StringBuilder();
        
        while(!maxHeap.isEmpty()){
            int[] first = maxHeap.poll();
            char ch1 = (char)first[0];
            int count1 = first[1];
            
            int times = Math.min(repeatLimit, count1);
            for (int i = 0; i < times; i++) {
                result.append(ch1);
            }
            count1 -= times;
            
            if (count1 > 0) {
                // Check if there's another character to break the sequence
                if (maxHeap.isEmpty()) {
                    break; // If no other character is left, stop
                }

                // Get the next largest character
                int[] second = maxHeap.poll();
                char ch2 = (char) second[0];
                int count2 = second[1];

                // Append the next largest character once to break the sequence
                result.append(ch2);
                count2--;

                // Put both characters back in the heap if they still have remaining counts
                if (count2 > 0) {
                    maxHeap.offer(new int[]{ch2, count2});
                }
                maxHeap.offer(new int[]{ch1, count1});
            }
    
        }
        
        return result.toString();
    }
}