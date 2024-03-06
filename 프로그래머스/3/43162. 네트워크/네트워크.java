import java.util.*;

class Solution {
    private boolean[][] visited;
  
  public int solution(int n, int[][] computers) {
    int counter = 0;
    visited = new boolean[n][n];
    initVisited(n, computers);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (computers[i][j] == 1 && !visited[i][j]) {
          counter++;
          visited[i][j] = true;
          visited[j][i] = true;
          dfs(i, j, computers);
          dfs(j, i, computers);
        }
      }
    }
    return counter + countStandAlone(n);
  }


  public int countStandAlone(int n){
    int counter = 0;
    for(int i = 0; i < n; i++){
      boolean flag = false;
      for(int j = 0; j < n; j++){
        if(i!=j && visited[i][j]){
          flag = true;
        }
      }
      if(!flag) counter++;
    }
    return counter;
  }
  public void dfs(int node1, int node2, int[][] c) {
    for (int i = 0; i < c.length; i++) {
      if (c[node2][i] == 1) {
        if (!visited[i][node1]) {
          visited[i][node1] = true;
          visited[node1][i] = true;
          dfs(i, node1, c);
          dfs(node2, i, c);
        }
      }
    }

  }

  public void initVisited(int len, int[][] computer) {
    for (int i = 0; i < len; i++) {
      visited[i][i] = true;
    }
  }
}