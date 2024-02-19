import java.util.*;

class Solution {
   public int[] solution(int[] numbers) {
    int len = numbers.length;
    int[] answer = new int[len];

    Arrays.fill(answer, -1);

    //use the stack
    Stack<int[]> s = new Stack<>();

    for (int i = 0; i < len; i++) {
        while (!s.isEmpty() && numbers[i] > s.peek()[1]) {
          answer[s.pop()[0]] = numbers[i];
        }
      s.add(new int[]{i, numbers[i]});
    }
      return answer;
  }
}