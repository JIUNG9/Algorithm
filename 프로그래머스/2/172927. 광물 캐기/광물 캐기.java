import java.util.*;
class Solution {
    private int answer = Integer.MAX_VALUE;


 public int getFatigue(String m, int p) {
    if (p == 0) {
      return 1;

    }
    if (p == 1) {
      if (m.equals("diamond")) {
        return 5;
      } else {
        return 1;
      }

    }
    if (p == 2) {
      if (m.equals("diamond")) {
        return 25;
      } else if (m.equals("iron")) {
        return 5;
      } else {
        return 1;
      }
    }
    return -1;
  }

  public int solution(int[] p, String[] m) {

        /*
        while(true){
            if(곡갱이가 남아있지 않거나 광물이 남아있지 않은 경우){
                answer = Math.min(current,answer)
                break;
            }
            else{
                if(다이아곡괭이가 존재하고, 방문하지 않은 경우){
                방문처리
                dfs(다이아곡갱이 -1 , 그리고 5개 가중치 계산한 값, visited);
                방문미처리
                }
            }
        }
        */
    boolean[] visited = new boolean[m.length / 5+1];

    //dfs
    dfs(visited, 0, p, m, 0);
    return answer;


  }

  public void dfs(boolean[] visited, int currentFatigue, int[] p, String[] m, int depth) {
    for (int i = 0; i < p.length; i++) {
      //캘 수 없는 경우와 곡괭이를 다쓴 경우를 어떻게 구현할 거지?
      if (p[0] + p[1] + p[2] == 0 || depth == visited.length) {
        answer = Math.min(answer, currentFatigue);
        break;
      } else {
        if (!visited[depth] && p[i] > 0) {
          int newFatigue = 0;
          for (int j = depth * 5; j < depth*5+ 5 && j < m.length; j++) {
            newFatigue += getFatigue(m[j], i);
          }
          //이전에 있던 피로도를 합치고, 방문처리 하고, 곡괭이 하나 감소
          p[i] = p[i]-1;
          visited[depth] = true;
          dfs(visited, newFatigue + currentFatigue, p, m, depth + 1);
          visited[depth] = false;
          p[i] = p[i]+1;
        }
      }


    }

  }
}