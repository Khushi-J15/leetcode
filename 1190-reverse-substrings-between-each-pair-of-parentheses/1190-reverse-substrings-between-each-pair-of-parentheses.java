class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(c);
            else if(c == ')'){
                String temp = "";
                while(stack.peek() != '('){
                  temp += stack.peek();
                    stack.pop();
                }
                stack.pop();
                for(char c1 : temp.toCharArray()) stack.push(c1);
            }
            else stack.push(c);
        }
        
        String ans = "";
        while(!stack.isEmpty()){
            ans += stack.peek();
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();

        sb.append(ans);

        String res = sb.reverse().toString();
        return res;
    }
}