import java.util.*;
import java.util.stream.Collectors;

class Solution {

  public int solution(int[] o) {
    int len = o.length;
    int idx = 0;

    //보조
    Stack<Integer> stk = new Stack<>();
    //container
    List<Integer> container = Arrays.stream(o).boxed().sorted().collect(Collectors.toList());


    for (int i = 0; i < len; i++) {
      boolean flag = false;
      if (o[idx] == container.get(i)) {
        idx++;
        flag = true;
      }
      while (!stk.isEmpty() && stk.peek() == o[idx]) {
                stk.pop();
                idx++;
                flag = true;
            }
       if(!flag) {
        stk.push(container.get(i));
      }
    }

      for (int j = idx; j < len; ) {
        if (!stk.isEmpty() && stk.peek() == o[idx]) {
          stk.pop();
          idx++;
        } else {
          break;
        }
      }
    return idx;
    }


}