class Solution {
public int solution(int m, int n, int[][] puddles) {
    // declare the padding array
    // init the puddle as -1

    int[][] dp = new int[n+1][m+1];
    int xLen = m+1;
    int yLen = n+1;



    for (int i = 1; i < xLen; i++) {
      dp[1][i] = 1;
    }
    for (int j = 1; j < yLen; j++) {
      dp[j][1] = 1;
    }
    for (int[] p : puddles) {
      int x = p[0];
      int y = p[1];
      dp[y][x] = -1;
    }

    for (int i = 1; i < yLen; i++) {
      for (int j = 1; j < xLen; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        if (dp[i][j] == -1) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = (dp[i - 1][j] + dp[i][j - 1])%1000000007;
        }
      }
    }
    return dp[yLen - 1][xLen - 1];
  }
}