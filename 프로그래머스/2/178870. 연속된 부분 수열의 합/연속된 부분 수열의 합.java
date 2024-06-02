import java.util.*;
import java.util.stream.*;
class Solution {
     public int[] solution(int[] sequence, int k) {
    List<int[]> list = new ArrayList<>();
    int len = sequence.length;
    int sum = 0;
    int preIdx = 0;
    int postIdx = 0;
    while (preIdx < len || postIdx < len) {
      if (postIdx < len && sum < k) {
        sum += sequence[postIdx++];
      } else if(preIdx < len) {
        sum -= sequence[preIdx++];
      }
      if (sum == k) {
        list.add(new int[]{preIdx, postIdx - 1});
      }
    }
    int[] answer = list.stream().sorted((arr1, arr2) -> {
      //arr1과 arr2의 첫 번째 원소와 두 번째 원소의 차이가 작은 것
      // 같다면 앞의 숫자가 작은 것
      int result = Integer.compare(arr1[1] - arr1[0], arr2[1] - arr2[0]);
      if (result == 0) {
        return Integer.compare(arr1[0], arr2[0]);
      } else {
        return result;
      }

    }).collect(Collectors.toList()).get(0);
    return answer;
  }
}