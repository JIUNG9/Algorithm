import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
  public boolean canMakeSquare(int x, int y, int brown) {
    return x * 2 + 2 * (y - 2) == brown;
  }
    
    
  public int[] solution(int brown, int yellow) {

    Queue<int[]> q = new LinkedList<>();
    int area = brown + yellow;

    for (int i = 1; i <= area / 2; i++) {
      if (area % i == 0 && area/i >= i) {
        q.offer(new int[]{area / i, i});
      }
    }

    while (!q.isEmpty()) {
      int[] arr = q.poll();
      int x = arr[0];
      int y = arr[1];
      if (canMakeSquare(x, y, brown)) {
        return arr;
      }
    }
    return null;
  }
}