import java.util.*;
class Data{
   int value, index;
   public Data(int value, int index) {
      this.value = value;
      this.index = index;
   }
}
class Solution {

   public static int solution(int[] stones, int k) {
      int answer = Integer.MAX_VALUE;

      int n = stones.length;
      ArrayDeque<Data> q = new ArrayDeque<>();

      for(int i = 0; i < n; i++) {
         int cur = stones[i];
         if(!q.isEmpty() && q.peek().index <= i - k) {
            q.pollFirst();
         }
         while(!q.isEmpty() && q.peekLast().value <= cur) {
            q.pollLast();
         }
         q.add(new Data(cur, i));
         if(answer >= q.peekFirst().value && i >= k - 1) {
            answer = q.peekFirst().value;
         }
      }

      return answer;
   }
}
