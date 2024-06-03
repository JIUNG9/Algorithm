import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
  public int[] solution(String[] genres, int[] plays) {
    List<Integer> answerList = new ArrayList<>();
    int len = genres.length;
    Map<String, PriorityQueue<int[]>> map = new HashMap<>();

    for (int i = 0; i < len; i++) {
      String key = genres[i];
      int idx = i;
      int value = plays[i];
      if (map.containsKey(genres[i])) {
        map.get(key).add(new int[]{idx, value});
      } else {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (arr1, arr2) -> Integer.compare(arr2[1], arr1[1]));
        q.add(new int[]{idx,value});
        map.put(key, q);
      }
    }

    Set<Entry<String, PriorityQueue<int[]>>> entrySet = map.entrySet();

    List<Entry<String, PriorityQueue<int[]>>> sortedList = entrySet.stream().sorted((v1, v2) -> {
      int sum1 = v1.getValue().stream().mapToInt(arr -> arr[1]).sum();
      int sum2 = v2.getValue().stream().mapToInt(arr -> arr[1]).sum();
      return Integer.compare(sum2, sum1);
    }).collect(Collectors.toList());

    for (Entry<String, PriorityQueue<int[]>> entry : sortedList) {
      int idx = 0;
        while (!entry.getValue().isEmpty() && idx < 2) {
          answerList.add(entry.getValue().poll()[0]);
          idx++;
        }
      }



    return answerList.stream().mapToInt(i -> i).toArray();

  }
}