import java.util.*;

class Solution {
    private Set<Integer> set;
 public static boolean isPrime(int num) {
    if (num == 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    if (num % 2 == 0) {
      return false;
    }

    for (int i = 3; i <= Math.sqrt(num); i += 2) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }

  public int solution(String numbers) {
    set = new HashSet<>();
    int len = numbers.length();
    boolean[] visited = new boolean[len];
    dfs(visited, numbers, "");
    int answer = (int) set.stream().filter(Solution::isPrime).count();
    return answer;
  }

  public void dfs(boolean[] visited, String elements, String curr) {
    for (int i = 0; i < elements.length(); i++) {
      if (!visited[i]) {
        visited[i] = true;
        set.add(Integer.parseInt(curr + elements.charAt(i)));
        dfs(visited, elements, curr + elements.charAt(i));
        visited[i] = false;
      }
    }
  }

    
}