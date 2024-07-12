class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x < y)
            return maximum(s, x, y, 'a', 'b');
        else
            return maximum(s, y, x, 'b', 'a');
    }

    public int maximum(String s, int x, int y, char a, char b){
        int total = 0; 
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){ 
            if (!stack.isEmpty() && s.charAt(i) == a && stack.peek() == b) {
                total += y;
                stack.pop();
            } else
                stack.push(s.charAt(i));
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (!stack.isEmpty() && str.charAt(i) == a && stack.peek() == b) {
                total += x;
                stack.pop();
            } else
                stack.push(str.charAt(i));
        }

        return total;

    }
}