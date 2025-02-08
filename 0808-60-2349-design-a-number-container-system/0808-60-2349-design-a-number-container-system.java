class NumberContainers {
    private Map<Integer, PriorityQueue<Integer>> numToIndices;
    private Map<Integer, Integer> indexToNum;

    public NumberContainers() {
        numToIndices = new HashMap<>();
        indexToNum = new HashMap<>();    
    }
    
    public void change(int index, int number) {
        if(indexToNum.containsKey(index)){
            int prevNum = indexToNum.get(index);
            if(prevNum == number) return;
            numToIndices.get(prevNum).remove(index);
    
        }
        numToIndices.computeIfAbsent(number, k -> new PriorityQueue<>()).offer(index);
        indexToNum.put(index, number);
    }
    
    public int find(int number) {
        PriorityQueue<Integer> pq = numToIndices.getOrDefault(number, new PriorityQueue<>());
        return pq.isEmpty() ? -1 : pq.peek();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */