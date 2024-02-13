class Solution {
 public int solution(int n) {

    int counter = 0;
    for(int i = 1; i <= n; i++){
      int sum = 0;
      int j = i;
      while (sum < n) {
        sum+=j++;
      }
      if(sum==n) counter++;
    }

    return counter;
  }
}