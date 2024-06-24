class Solution {
    public int minKBitFlips(int[] A, int k) {
          int n = A.length, flipped = 0, res = 0;
        int[] fp = new int[n];
        for (int i = 0; i < A.length; ++i) {
            if (i >= k)
                flipped ^= fp[i - k];
            if (flipped == A[i]) {
                if (i + k> A.length)
                    return -1;
                fp[i] = 1;
                flipped ^= 1;
                res++;
            }
        }
        return res;
    }
}