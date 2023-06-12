class Solution {
    private static int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0 , target, 0);
        return ans;
            
        
         
    }
     public void dfs(int[] n, int depth, int target, int counter) {
         
    if (depth == n.length) {
      if (target == counter) {
        ans++;
      }
      return;
    }

      dfs(n, depth + 1, target, counter + n[depth]);
      dfs(n, depth + 1, target, counter - n[depth]);

  }
}