class Solution {
    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        
        for(int i=0; i<k; i++){
            int richestPileIdx = 0;
            for(int currentPileIdx = 0; currentPileIdx < n; currentPileIdx++){
                if(gifts[richestPileIdx] < gifts[currentPileIdx]){
                    richestPileIdx = currentPileIdx;
                }
            }
            gifts[richestPileIdx] = (int) Math.floor(Math.sqrt(gifts[richestPileIdx]));
        }
        
        long remainingGifts = 0;
        
        for(int g : gifts){
            remainingGifts += g;
        }
        
        return remainingGifts;
    }
}