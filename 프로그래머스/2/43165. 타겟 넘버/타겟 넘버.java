class Solution {

    private int answer = 0;
  public int solution(int[] numbers, int target) {
    dfs(numbers, 0, 0, numbers.length, target);
    return answer;
  }

  public void dfs(int[] arr, int sum, int currentLen, int len, int target) {

    if (currentLen == len) {
      if (target == sum ) {
        answer++;
      }
    } else {
      dfs(arr, sum + arr[currentLen], currentLen + 1, len, target);
      dfs(arr, sum - arr[currentLen], currentLen + 1, len, target);
    }
  }
    
    
}
