import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
     int sLen = s.length();
    String[] strArr = s.split(" ");
   List<Integer> numbs = Arrays.stream(strArr).map(Integer::parseInt).sorted(Comparator.comparing(Integer::valueOf)).collect(
        Collectors.toList());
    int firstNumber = numbs.get(0);
    int lastNumber = numbs.get(numbs.size() - 1);

    return firstNumber + " " + lastNumber;

    }
}