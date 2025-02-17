class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> uniqueSet = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        backtrack(tiles, new StringBuilder(), used, uniqueSet);
        return uniqueSet.size();
    }

    private static void backtrack(String tiles, StringBuilder current, boolean[] used, HashSet<String> uniqueSet){
        if(current.length() > 0){
            uniqueSet.add(current.toString());
        }

        for(int i=0; i<tiles.length(); i++){
            if(used[i]) continue;
            used[i] = true;
            current.append(tiles.charAt(i));
            backtrack(tiles, current, used, uniqueSet);
            current.deleteCharAt(current.length()-1);
            used[i] = false;
        }
    }
}