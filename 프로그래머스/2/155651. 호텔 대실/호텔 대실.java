
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int solution(String[][] t) {
    int answer = 0;
    Queue<String> endTime = new PriorityQueue<>();
    Queue<String> startTime = new PriorityQueue<>();
    for (String[] s : t) {
      endTime.add(s[1]);
      startTime.add(s[0]);
    }

    while(!startTime.isEmpty()){
      String endTimeStr = endTime.peek();
      if (startTime.poll().compareTo(addedCleaningTime(endTimeStr, 10)) < 0) {
        answer++;
      } else {
        endTime.poll();
      }
    }
    return answer;
  }

  public String addedCleaningTime(String s, int cleaningTime) {
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    LocalTime time = LocalTime.parse(s, timeFormatter);

    LocalTime newTime = time.plusMinutes(cleaningTime);
    return newTime.toString();

  }



}