class Solution {
    private Node root;
    
    public Solution(){
        root = new Node();    
    }
    
    public void insert(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.put(ch, new Node());
            }
            node.inc(ch);
            node = node.get(ch);
        }
    }
    
    public int search(String word){
        Node node = root;
        int preCount = 0;
        for(char ch: word.toCharArray()){
            preCount += node.retCount(ch);
            node = node.get(ch);
        }
        return preCount;
    }
    
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] res = new int[n];
        
        for(String w : words){
            insert(w);
        }
        
        for(int i=0; i<n; i++){
            res[i] = search(words[i]);
        }
        
        return res;
    }
}

class Node {
    int count = 0;
    Node[] list = new Node[26];
    
    public boolean containsKey(char ch){
        return list[ch - 'a'] != null;
    }
    
    public Node get(char ch){
        return list[ch - 'a'];
    }
    
    public void put(char ch, Node new_node){
        list[ch - 'a'] = new_node;
    }
    
    public void inc(char ch){
        list[ch - 'a'].count++;
    }
    
    public int retCount(char ch){
        return list[ch - 'a'].count;
    }
}