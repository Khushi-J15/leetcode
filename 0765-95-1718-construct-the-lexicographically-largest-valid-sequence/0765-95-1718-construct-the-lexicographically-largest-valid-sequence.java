class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] resSeq = new int[n * 2 - 1];
        // initialize the result sequence with size 2*n - 1

        boolean[] isNumUsed = new boolean[n + 1];
        // keep track of which numbers are already placed in the sequence.

        backtrack(0, resSeq, isNumUsed, n);

        return resSeq;
    }

    private boolean backtrack(int curIndex, int[] resSeq, boolean[] isNumUsed, int n){
        if(curIndex == resSeq.length) return true;

        if(resSeq[curIndex] != 0){
            return backtrack(curIndex + 1, resSeq, isNumUsed, n);
        }

        for(int numToPlace = n; numToPlace > 0; numToPlace--){
            if(isNumUsed[numToPlace]) continue;

            isNumUsed[numToPlace] = true;
            resSeq[curIndex] = numToPlace;

            if(numToPlace == 1){
                if(backtrack(curIndex + 1, resSeq, isNumUsed, n)) return true;
            }

            else if(curIndex + numToPlace < resSeq.length && resSeq[curIndex + numToPlace] == 0){
                resSeq[curIndex + numToPlace] = numToPlace;

                if(backtrack(curIndex + 1, resSeq, isNumUsed, n)) return true;

                resSeq[curIndex + numToPlace] = 0;
            }

            resSeq[curIndex] = 0;
            isNumUsed[numToPlace] = false;
        }

        return false;
    }
}