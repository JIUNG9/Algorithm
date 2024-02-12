
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Solution {
     public String solution(int[] numbers) {
  
      String answer = "";
      List<Integer> unSortedList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
  
      List<Integer> sortedList = unSortedList.stream()
          .sorted((o1, o2) -> new ArrangeByOnlyFirstDigit().compare(o1, o2)).collect(
              Collectors.toList());
  
      for (int i = sortedList.size() - 1; i >= 0; i--) {
          answer = answer.concat(String.valueOf(sortedList.get(i)));
      }
  
      return answer.charAt(0) == '0' ? "0": answer;
    }
  
  }
  
  class ArrangeByOnlyFirstDigit implements Comparator<Integer> {
  
    @Override
    public int compare(Integer o1, Integer o2) {
      //get only first digit
      int onlyFirstDigitO1 = getFirstDigit(o1);
      int onlyFirstDigitO2 = getFirstDigit(o2);
  
      if (onlyFirstDigitO1 == onlyFirstDigitO2) {
        //make the number with String value of o1, o2 and o2, o1 and compare
        String o1AndO2 = String.valueOf(o1) + o2;
        String o2AndO1 = String.valueOf(o2) + o1;
  
        return Integer.valueOf(o1AndO2).compareTo(Integer.valueOf(o2AndO1));
  
      } else if (onlyFirstDigitO1 > onlyFirstDigitO2) {
        return 1;
      } else {
        return -1;
      }
    }
  
    public int getFirstDigit(Integer i) {
      while ((i / 10) > 0) {
        i /= 10;
      }
      return i;
    }

}