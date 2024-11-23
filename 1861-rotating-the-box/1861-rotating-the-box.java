class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        char[][] res = new char[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[i][j] = box[j][i];
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m/2; j++){
                char temp = res[i][j];
                res[i][j] = res[i][m-1-j];
                res[i][m-1-j] = temp;
            }
        }
        
        for(int j=0; j<m; j++){ // for each column
            int lowestRowWithEmptyCell = n - 1;
            for(int i=n-1; i>=0; i--){
                if(res[i][j] == '#'){
                    res[i][j] = '.';
                    res[lowestRowWithEmptyCell][j] = '#';
                    lowestRowWithEmptyCell--;
                }
                if(res[i][j] == '*'){
                    lowestRowWithEmptyCell = i-1;
                }
            }
        }
        
        return res;
    }
}