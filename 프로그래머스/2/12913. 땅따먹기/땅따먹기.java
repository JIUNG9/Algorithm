class Solution {
    private int answer = -1;
    int solution(int[][] land) {
        
        int row = land.length;
        int[][] dp= new int[row][4];

        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        
        for(int i = 1; i< row; i++){
            int[] prevRow = dp[i-1];
            for(int j = 0; j < prevRow.length; j++){
                int max = getMaxValueWithoutCurrIdx(j,prevRow);
                dp[i][j] +=(land[i][j] + max);
            }
        }
        
        for(int k = 0; k < 4; k++){
            answer = Math.max(answer,dp[row-1][k]);
        }
    
        return answer;

    }
    
    private int getMaxValueWithoutCurrIdx(int idx, int[] row){
        int max = -1;
        for(int i = 0; i < 4; i++){
            if(idx == i) continue;
            max = Math.max(max,row[i]);
        }
        return max;
        
        
    }
}