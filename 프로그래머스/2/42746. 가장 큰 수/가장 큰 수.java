import java.util.*;
import java.util.stream.Collectors;

 class Solution {
  public String solution(int[] numbers) {

    int len = numbers.length;
    List<String> list = convertToStringList(numbers);
    List<String> sortedList = list.stream().sorted((o1, o2) -> {
      String firstCase = o1.concat(o2);
      String secondCase = o2.concat(o1);
      if(firstCase.equals(secondCase)) return 0;
      return (Integer.parseInt(firstCase) >= Integer.parseInt(secondCase)) ? -1 : 1;
    }).collect(Collectors.toList());
    String answer = "";
    for(int i = 0; i < len; i++){
      answer =answer.concat(sortedList.get(i));
    }
    return isAllElements0(answer) ? "0" : answer;
  }

  public List<String> convertToStringList(int[] numbers) {
    int len = numbers.length;
    List<String> list = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      list.add(String.valueOf(numbers[i]));
    }
    return list;
  }
    public boolean isAllElements0(String answer){
        for(int i =0; i <answer.length(); i++){
            if(answer.charAt(i)!='0') return false;
        }
        return true;
    }
}