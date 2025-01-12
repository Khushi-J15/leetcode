class Solution {
    public boolean canBeValid(String s, String locked) {
        int stringLen = s.length(); 
        if(stringLen % 2 == 1) return false;

        Stack<Integer> openIndices = new Stack<>();
        Stack<Integer> unlockedI = new Stack<>();

        for(int i=0; i<stringLen; i++){

            if(locked.charAt(i) == '0'){
                unlockedI.push(i);
            } 
            else if(s.charAt(i) == '('){
                openIndices.push(i);
            } 
            else if(s.charAt(i) == ')'){

                if(!openIndices.isEmpty()) {
                    openIndices.pop();
                }
                else if(!unlockedI.isEmpty()){
                    unlockedI.pop();
                } 
                else {
                    return false;
                }

            }
        }

        while(!openIndices.isEmpty() && !unlockedI.isEmpty() && openIndices.peek() < unlockedI.peek()){
            openIndices.pop();
            unlockedI.pop();
        }

        if(openIndices.isEmpty() && !unlockedI.isEmpty()){
            return unlockedI.size() % 2 == 0;
        }

        return openIndices.isEmpty();
    }
}