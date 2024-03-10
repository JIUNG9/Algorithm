# [level 2] 전력망을 둘로 나누기 - 86971 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/86971) 



### Approach
- Cut the node from the index 0 if the minimum value of the number which is substractraction number of connected each other.
- Use the dfs
- the visited array means the line. which is not node. so the number of connected node is connected line+1
- also visited array is pushed into the stack area. so when last one is out from the stack. the main method get only the first pushed visited array. so use the number of true value when dfs is end.
``` java
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

```




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
