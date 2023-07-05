import java.util.ArrayList;
import java.util.List;
class Solution {
  public int[] solution(int n, long k) {
    int[] result = new int[n];
    long fact = 1;
    int factorialDivider = n;
    List<Integer> numberList = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      numberList.add(i);
      fact *=i;
    }


    k--;
    for (int i = 0; i < n; i++) {
      fact/= factorialDivider--;
      int digit = (int) (k / fact);
      result[i] = numberList.remove(digit);
      k %= fact;
    }
    return result;

  }
}