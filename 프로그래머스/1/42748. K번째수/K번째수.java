import java.util.*;
import java.util.stream.Collectors;


class Solution {
public int[] solution(int[] array, int[][] commands) {
      int[] answer = new int[commands.length];
      int answerIdx = 0;
      for(int[] co : commands){
      List<Integer> list = arrToSortedList(array,co[0]-1,co[1]-1);
      answer[answerIdx++] = list.get(co[2]-1);
      }

      return answer;
    }

    public List<Integer> arrToSortedList(int[] arr, int start, int end){

    List<Integer> list = new ArrayList<>();
    for(int i = start; i <= end; i++){
      list.add(arr[i]);
    }
      return list.stream().sorted().collect(Collectors.toList());
    }

}