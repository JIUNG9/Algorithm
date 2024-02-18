import java.util.HashSet;
import java.util.Set;

class Solution {
public int solution(int[] elements) {
    Set<Integer> set = new HashSet<>();
    function(set, elements, 0, 0);
    return set.size();

  }

  public void function(Set<Integer> set, int[] elements, int sum, int index) {

    for (int i = 0; i < elements.length; i++) {
      for (int j = 0; j < elements.length; j++) {
        sum+=elements[j];
        set.add(sum);
      }
      int temp = elements[0];
      System.arraycopy(elements, 1, elements, 0, elements.length - 1);
      elements[elements.length - 1] = temp;
      sum = 0;
    }
  }
}