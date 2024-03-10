class Solution {
    private int answer = Integer.MAX_VALUE;
  private boolean[] visited;


public int solution(int n, int[][] w) {

    int len = w.length;
    for (int i = 0; i < len; i++) {
      int connectedLen;
      visited = new boolean[len];
      if (i == len - 1) {
        connectedLen =dfs(w, i, 0, w[0][0], w[0][1]);
      } else {
        connectedLen = dfs(w, i, 0, w[i + 1][0], w[i + 1][1]);
      }
      int anotherConnectedLen = n-connectedLen;
      answer = Math.min(Math.abs(anotherConnectedLen- connectedLen), answer);
    }
    return answer;
  }

  public int dfs(int[][] w, int cut, int counter, int a, int b) {
    for (int i = 0; i < w.length; i++) {
      if (i == cut) {
        continue;
      }
      if (!visited[i] && (w[i][0] == a || w[i][1] == a || w[i][0] == b || w[i][1] == b)) {
        visited[i] = true;
        dfs(w, cut, counter + 1, w[i][0], w[i][1]);
      }
    }
    return getConnected(visited)+1;
  }

  private int getConnected(boolean[] visited) {
    int counter = 0;
    for (int i = 0; i < visited.length; i++) {
      if (visited[i]) {
        counter++;
      }
    }
    return counter;
  }

}