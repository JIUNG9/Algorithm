import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
  private List<Integer> answerList;
  private Map<String, Integer> map;
  private int sequence = 1;

//   public static void main(String[] args) {

//     압축 g = new 압축();

//     int[] arr = g.solution("KAKAO");
//     for (Integer i : arr) {
//       System.out.println(i);
//     }
//   }

 public int[] solution(String msg) {
    //range check => should do the range check in here
    int len = msg.length();
    int i = 0;
    map = new HashMap<>();
    answerList = new ArrayList<>();
    makePreDefinedTable();

    while (i < len) {
      String current = msg.substring(i, i + 1);
      String temp = msg.substring(i, i + 1);
      while (map.containsKey(current)) {
        i++;
        if (i + 1  > len) {
          break;
        }
        temp = current;
        current = current.concat(msg.substring(i, i + 1));
      }
      if(!map.containsKey(current)){
        map.put(current,sequence++);
        answerList.add(map.get(temp));
      }
      else{
        answerList.add(map.get(current));
      }
    }
    return answerList.stream().mapToInt(integer -> integer).toArray();
  }

  public void makePreDefinedTable() {
    Character[] upperCaseAlphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
        'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    for (Character c : upperCaseAlphabet) {
      map.put(String.valueOf(c), sequence++);
    }


  }
}