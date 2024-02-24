import java.util.*;
class Solution {
    
   public int solution(int cacheSize, String[] cities) {

    List<String> list = new ArrayList<>();
    initAsLowerCase(cities);
    int len = cities.length;
    int answer = 0;

    if (cacheSize == 0) {
      return 5 * cities.length;
    }

    for (int i = 0; i < len; i++) {
      String s = cities[i];

      if(list.size() < cacheSize) {
        answer+=initCache(list,s);
      }
      else if (isCachedHit(s, list)) {
        answer++;
        cacheHit(s, list);
      } else {
        answer += 5;
        nonCacheHit(s, list);
      }
    }
    return answer;

  }


   public int initCache(List<String> list, String s) {
    if(list.contains(s)) {
      list.remove(s);
      list.add(s);
      return 1;
    }
    else{
      list.add(s);
      return 5;
    }
  }


  

  public void initAsLowerCase(String[] cities) {
    int len = cities.length;
    for (int i = 0; i < len; i++) {
     cities[i] =  cities[i].toLowerCase();
    }

  }

  public boolean isCachedHit(String s, List<String> list) {
    return list.contains(s);
  }

  public void cacheHit(String s, List<String> cached) {
    cached.remove(s);
    cached.add(s);
  }

  public void nonCacheHit(String s, List<String> cached) {
    cached.remove(0);
    cached.add(s);
  }
}