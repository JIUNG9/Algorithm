import java.util.*;
class Solution {
 public String solution(String number, int k) {
    StringBuilder sb = new StringBuilder();
    int len = number.length();
    Stack<Integer> stk = new Stack<>();
    stk.push(Integer.parseInt(number.substring(0, 1)));
    int removeCounter = 0;

    for (int i = 1; i < len; i++) {
      int currValue = Integer.parseInt(number.substring(i, i + 1));

      if(removeCounter == k) {
        stk.push(currValue);
        continue;
      }

      while (!stk.isEmpty() && stk.peek() < currValue && removeCounter < k) {
        stk.pop();
        removeCounter++;
      }
      stk.push(currValue);
    }
   while(!stk.isEmpty()){
      sb.append(String.valueOf(stk.pop()));
   }
   return sb.reverse().substring(0,len-k);

  }
}