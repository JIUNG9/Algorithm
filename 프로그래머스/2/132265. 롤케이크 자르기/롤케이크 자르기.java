import java.util.*;


class Solution {
public int solution(int[] t){
    int len = t.length;
    int answer =0;
    Map<Integer,Integer> map = sliceTheCake(t);
    Set<Integer> brotherHasToppingSet = new HashSet<>();
    for(int i = 0; i < len; i++){
      brotherHasToppingSet.add(t[i]);
      int value = map.get(t[i]);
      if(value -1 <=0) {
        map.remove(t[i]);
      }
      else{
        map.put(t[i],value-1);
      }
      if(brotherHasToppingSet.size()== map.size()){
        answer++;
      }
      }
      return answer;
    }


  private Map<Integer,Integer> sliceTheCake(int[] c){
    int len = c.length;
    Map<Integer,Integer> map = new HashMap<>();
    for(int i =0; i < len; i++){
      map.put(c[i], map.getOrDefault(c[i],0)+1);
    }
    return map;

  }

}