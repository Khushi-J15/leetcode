class Solution {
    private static final int MOD = 1000000000 + 7;
    
    public int checkRecord(int n) {
        int prevDp[][] = new int[2][3];
        prevDp[0][0] = 1;
        prevDp[0][1] = 1;
        prevDp[0][2] = 1;
        prevDp[1][0] = 1;
        prevDp[1][1] = 1;
        prevDp[1][2] = 1;
        
        for(int i=1; i<=n; i++){
            int newDp[][] = new int[2][3];
            
            for(int a=0; a<2; a++){ // a = 0,1
                
                for(int l = 0; l<3; l++){ // l = 0,1,2
                    // pick P
                    newDp[a][l] += prevDp[a][2]; 
                    if(a > 0){
                        // pick A
                        newDp[a][l] += prevDp[a-1][2];
                        newDp[a][l] %= MOD;
                    }
                    if(l > 0){
                        // pick L
                        newDp[a][l] += prevDp[a][l-1];
                        newDp[a][l] %= MOD;
                    }
                }
            }
            prevDp = newDp;
            
        }
        
        return prevDp[1][2];

    }
}

