import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collectors;
class Solution {
  public int solution(int[] people, int limit) {

    Arrays.sort(people);
    Deque<Integer> dq = new ArrayDeque<>();
    dq.addAll(Arrays.stream(people)
        .boxed()
        .collect(Collectors.toList()));

    int ans = 0;
    while (!dq.isEmpty()) {
      int weight = dq.pollLast();
      if (!dq.isEmpty()&& weight + dq.peekFirst() <= limit) {
        dq.pollFirst();
      }
      ans++;
    }

    return ans;

  }

}