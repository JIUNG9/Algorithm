import java.util.Arrays;


class Solution {
 public int solution(int k, int[] tangerine) {
    int len = tangerine.length;
    int[] weight = new int[len];
    int j = 0;
    int sum = 0;
    int counter = 1;
    int answer = 1;
    Arrays.sort(tangerine);

    weight[j] = 1;

    //get weights with same element
    for (int i = 0; i < len - 1; ) {
      if (tangerine[i] == tangerine[i + 1]) {
        weight[j] = ++counter;
      } else {
        j += 1;
        counter = 1;
        weight[j] = 1;
      }
      i++;
    }

    Arrays.sort(weight);

    for (int i = len-1; i >= 0; i--) {
      sum += weight[i];
      if (sum >= k) {
        return answer;
      }
      else{
        answer++;
      }
    }
    return -1;
  }

}