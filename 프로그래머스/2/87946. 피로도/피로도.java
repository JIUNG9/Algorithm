import java.util.*;

class Solution {
    
    private int answer = -1;
    private int len;
    private boolean[] visited;
    
    
     public int solution(int k, int[][] d) {
    len = d.length;
    visited = new boolean[len];
    dfs(d, k, 0);

    return answer;
  }


  public void dfs(int[][] d, int hp, int counter) {
    for (int i = 0; i < len; i++) {
      if (hp >= d[i][0] && !visited[i]) {
        answer = Math.max(answer, counter + 1);
        visited[i] = true;
        dfs(d, hp - d[i][1], counter + 1);
        visited[i] = false;
      }
    }
  }
}