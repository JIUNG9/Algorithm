import java.util.HashSet;
import java.util.Set;

class Solution {
public int[] solution(int n, String[] words) {

    //The return [1] is The number of iteration number
    //The return [0] who is failed

    int len = words.length;
    Set<String> s = new HashSet<>();
    s.add(words[0]);
    for (int i = 1; i < len; i++) {
      if (s.contains(words[i]) || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
        return new int[]{i % n + 1, i / n + 1};
      } else {
        s.add(words[i]);
      }
    }

    return new int[]{0, 0};
  }
}
