import java.util.PriorityQueue;


class Solution {
 public int solution(int n, int k, int[] enemy) {
    int len = enemy.length;
    int idx = 0;
    int counter =0;
    PriorityQueue<Integer> q = new PriorityQueue<>();

      while (idx < len && k > 0) {
        k--;
        q.add(enemy[idx++]);
        counter++;
      }
      while (idx < len && n > 0) {
        if (!q.isEmpty() && enemy[idx] > q.peek()) {
          if (n - q.peek() >= 0) {
            n-=q.poll();
            q.add(enemy[idx++]);
            counter++;
          }
          else{
            return counter;
          }
        } else {
          if(n-enemy[idx] >=0){
            n-=enemy[idx++];
            counter++;
          }
          else{
            return counter;
          }
        }
      }
    return counter;

  }

}