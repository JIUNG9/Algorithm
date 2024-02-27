import java.util.*;
import java.util.stream.*;

class Solution {
public int solution(int[] p, int l) {
    int len = p.length;
    int counter = 0;
    Queue<int[]> q = new LinkedList<>();
    List<Integer> maxDESC = getDESCPrioirty(p);
    int idx = 0;
    int max = maxDESC.get(idx);

    for (int i = 0; i < len; i++) {
      q.add(new int[]{i, p[i]});
    }

    while(!q.isEmpty()){
      int[] polled = q.poll();
      int alpha = polled[0];
      int priority = polled[1];

      if (alpha == l && priority == max) {
        counter++;
        break;
      }
        if (priority != max) {
          q.add(polled);
        } else {
          counter++;
          idx++;
          max = maxDESC.get(idx);
        }
      }


    return counter;


  }
    public List<Integer> getDESCPrioirty(int[] p) {
        List<Integer> list = new ArrayList<>();
        int len = p.length;
        for(int i =0; i < len; i ++){
            list.add(p[i]);
        }
        return list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
    
    
}