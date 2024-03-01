import java.util.*;

class Solution {
      public int solution(int[][] land) {
      //DP[i][j]는 DP[i-1][j]를 제외한 DP[i-1]의 행의 가장 큰 값과 land[i][j]의 값으로 이뤄진다.
    int len = land.length;
    int width = land[0].length;
    int[][] dp = initDp(land);

    for(int i = 1; i < len; i++){
      for(int j = 0; j < width; j++){
        dp[i][j] = land[i][j] + getMaxValueWithoutInputIdx(dp[i-1], j);
      }
    }
    return getMaxValueWithoutInputIdx(dp[len-1], Integer.MAX_VALUE);
  }

  private int getMaxValueWithoutInputIdx(int[] arr, int idx) {
    int len = arr.length;
    int max = 0;
    for(int i = 0; i < len; i++){
      if(i == idx) continue;
      max = Math.max(max,arr[i]);
    }
    return max;
  }

  public int[][] initDp(int[][] land){
    int width = land.length;
    int len = land[0].length;
    int[][] dp = new int[width][len];
        for(int i =0; i < len; i++){
          dp[0][i] = land[0][i];
        }
    return dp;
  }
}