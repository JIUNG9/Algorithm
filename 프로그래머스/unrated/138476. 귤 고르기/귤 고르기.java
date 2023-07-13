import java.util.Arrays;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
class Solution {
 public int solution(int k, int[] t) {

    int answer = 0;
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < t.length; i++) {
      map.put(t[i],map.getOrDefault(t[i],0)+1);
    }
    List<Entry<Integer,Integer>> list = map.entrySet().stream().sorted(
        new Comparator<Entry<Integer, Integer>>() {
          @Override
          public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
           return o2.getValue().compareTo(o1.getValue());
          }
        }).collect(Collectors.toList());

    for(Entry<Integer,Integer> e : list ){
      if (k <= 0)
        break;
      answer++;
      k -= e.getValue();
    }

    return answer;

  }
}