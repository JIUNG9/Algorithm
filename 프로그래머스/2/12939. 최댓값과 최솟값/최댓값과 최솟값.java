import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
   public String solution(String s) {
    StringBuilder sb = new StringBuilder();

    String[] arr = s.split(" ");

    List<Integer> arrangedList = Arrays.stream(arr).mapToInt(Integer::valueOf).sorted().boxed()
        .collect(
            Collectors.toList());

    int min = arrangedList.get(0);
    int max = arrangedList.get(arrangedList.size()-1);

    sb.append(min);
    sb.append(" ");
    sb.append(max);

    return sb.toString();


  }

}