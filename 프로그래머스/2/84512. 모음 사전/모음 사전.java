import java.util.*;

class Solution {
    
    private List<String> list;
    private int answer = 0;
    
public int solution(String w) {
    list = new ArrayList<>();
    dfs(w, "", 5, new char[]{'A', 'E', 'I', 'O', 'U'});
    return answer;
  }


  public void dfs(String target, String current, int len, char[] vowels) {
    if (target.equals(current)) {
      answer = list.size();
    }

    if (current.length() != len) {
      for (int i = 0; i < 5; i++) {
        list.add(current + vowels[i]);
        dfs(target, current + vowels[i], len, vowels);
      }

    }


  }
}