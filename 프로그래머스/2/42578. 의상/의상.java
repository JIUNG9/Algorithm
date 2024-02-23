import java.util.*;
class Solution {
     
     public int solution(String[][] clothes) {
    int len = clothes.length;
    Map<String, Integer> map = new HashMap<>();
    int cases = 1;

    //save into Map
    for (int i = 0; i < len; i++) {
      map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
    }


    for (int i = 0; i < len; i++) {
      if (map.containsKey(clothes[i][1])) {
        cases *= (map.get(clothes[i][1])+1);
        map.remove(clothes[i][1]);
      }
    }

    return cases -1 ;


  }
}