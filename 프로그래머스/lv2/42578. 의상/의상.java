import java.util.HashMap;
import java.util.Map;

class Solution {
 public int solution(String[][] clothes) {
    int len = clothes.length;
    int sum = 1;
    Map<String, Integer> map = new HashMap<>();
    for(int i =0; i < len; i++){
      String key = clothes[i][1];
      if(map.containsKey(key)){
        Integer value = map.get(key);
        map.put(key, value+1);
      }
      else{
        map.put(key,1);
      }
    }

    for(Integer i : map.values()){
      sum *=(i+1);
    }
    return sum -1;
  }
}