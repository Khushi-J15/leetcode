class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        
        for(char curChar: expression.toCharArray()){
            if(curChar == ')'){
                ArrayList<Character> values = new ArrayList<>();
                
                while(st.peek() != '('){
                    values.add(st.pop());
                }
                st.pop(); // removing '('
                char op = st.pop(); // & , |
                
                char result = evaluate(op, values);
                st.push(result);
            }else if(curChar != ','){
                st.push(curChar);
            }
        }
        
        return st.peek() == 't';
    }
    
    private char evaluate(char op, ArrayList<Character> values){
        if(op == '!'){
            return values.get(0) == 't' ? 'f': 't'; 
        }
        
        else if(op == '|'){
            for(char c: values){
                if(c == 't') return 't';
            }
            return 'f';
        }
        
        else if(op == '&'){
            for(char c: values){
                if(c == 'f') return 'f'; 
            }
            return 't';
        }
        
        return 'f';
    }
}