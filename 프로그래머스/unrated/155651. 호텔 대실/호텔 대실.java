import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
class Solution {
  public int solution(String[][] book_time) {
  int len = book_time.length;
  int[][] intTime = new int[len][2];
  int answer = 0;

    for (int i = 0; i < len; i++) {
      intTime[i][0] = this.stringTimeToIntTime(book_time[i][0]);
      intTime[i][1] = this.stringTimeToIntTime(book_time[i][1]) + 10;
         if(intTime[i][1] % 100 >= 60){
        intTime[i][1]+=100;
        intTime[i][1]-=60;
      }
    }
    Arrays.sort(intTime, Comparator.comparingInt(o -> o[0]));

  Queue<int[]> room = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1],o2[1]));
  room.add(intTime[0]);
  answer = 1;
  for(int i = 1; i < len; i++){
    int[] earliestEmptyRoom = room.peek();
    int earliestEndTime = earliestEmptyRoom[1];
    int newCusStartTime = intTime[i][0];
    if(earliestEndTime <= newCusStartTime) {
      room.poll();
    }
    room.add(intTime[i]);
    answer = Math.max(answer, room.size());
  }
return answer;


      }


    public int stringTimeToIntTime(String time){
    String resultString ="";
    String[] StringTime = time.split(":");
    for(String s : StringTime){
     resultString = resultString.concat(s);
    }
    return Integer.parseInt(resultString);
  }
}