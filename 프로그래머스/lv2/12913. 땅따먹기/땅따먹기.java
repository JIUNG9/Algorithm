class Solution {
    int solution(int[][] land) {
    int row = land.length;
    int col = land[0].length;
    int[][] dp = new int[row][col];

      for(int index = 0; index < col; index++){
        dp[0][index] = land[0][index];
    }

      for(int i = 1; i < row; i++){
        for(int j = 0; j < col; j++){
          for(int k = 0; k < col; k++){
              if(j==k) continue;
            dp[i][j] = Math.max(dp[i][j],dp[i-1][k] + land[i][j]);
          }
        }
      }

    int maxValue = dp[row-1][0];
    for(int index = 1; index < col; index++){
        maxValue = Math.max(maxValue, dp[row-1][index]);
      }
    return maxValue;


  }
}