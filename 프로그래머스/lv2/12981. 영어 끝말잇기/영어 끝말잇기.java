import java.util.HashMap;
import java.util.Map;
class Solution {
  public int[] solution(int n, String[] words) {
    int len = words.length;
    Map<String, Integer> map = new HashMap<>();
    if(words[0].length() <= 1){
      return new int[] {1,1};
    }
    map.put(words[0], 1);

    for(int i = 1; i < len; i++){
      int personNumber = i % n + 1;
      int iterationNumber = (i/n) + 1;
      if(map.containsKey(words[i])) return new int[]{personNumber,iterationNumber};
      if(words[i].length() <=1) return new int[] {personNumber,iterationNumber};
      if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)) return new int[]{personNumber, iterationNumber};
      map.put(words[i],personNumber);
    }
    return new int[]{0,0};
  }
}