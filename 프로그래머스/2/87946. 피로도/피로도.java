class Solution {

    private int answer = Integer.MIN_VALUE;
    
 public int solution(int k, int[][] dungeons) {
    boolean[] visited = new boolean[dungeons.length];
    dfs(visited,dungeons,k,0);
    return answer;
  }

  public void dfs(boolean[] visited, int[][] d, int currentStamina, int visitCounter) {

    answer = Math.max(answer, visitCounter);

    for (int i = 0; i < d.length; i++) {
      int atLeastRequirementStamina = d[i][0];
      int requireStamina = d[i][1];
      if (currentStamina >= atLeastRequirementStamina && !visited[i]) {
        visited[i] = true;
        dfs(visited, d, currentStamina - requireStamina, visitCounter + 1);
        visited[i] = false;
      }
    }
  }
}