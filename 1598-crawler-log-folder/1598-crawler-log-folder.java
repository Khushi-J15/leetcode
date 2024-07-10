class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s = new Stack<>();
        
        for(String operation : logs){
            if(operation.equals("../")){
                if(!s.isEmpty())
                s.pop();
            }
            else if(!operation.equals("./")){
                s.push(operation);
            }
        }
        
        return s.size();
    }
}