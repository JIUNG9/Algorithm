import java.util.*;

class Solution {
    
  List<String> answerList;

 public String[] solution(String[][] t) {
    answerList = new ArrayList<>();
    boolean[] visited = new boolean[t.length];
    dfs(t, visited, "ICN");

    answerList.sort(String::compareTo);
    return answerList.get(0).split(" ");
  }


  public void dfs(String[][] t, boolean[] visited, String current) {
    for (int i = 0; i < t.length; i++) {
      String[] words = current.split(" ");
      if (words.length == t.length + 1) {
        if (words[0].equals("ICN")) {
          answerList.add(current);
        }
      } else {
        if (!visited[i] && words[words.length-1].equals(t[i][0])) {
          visited[i] = true;
          dfs(t, visited, current + " " + t[i][1]);
          visited[i] = false;
        }
      }
    }

}
}