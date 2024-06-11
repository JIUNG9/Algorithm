import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private long q1Sum = -1L;
    private long q2Sum = -1L;
    private long target = -1L;
    private int counter = 0;
    
public void init(int[] arr1, int[] arr2) {
    q1Sum = Arrays.stream(arr1).sum();
    q2Sum = Arrays.stream(arr2).sum();

    q1 = new LinkedList<>(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
    q2 = new LinkedList<>(Arrays.stream(arr2).boxed().collect(Collectors.toList()));

    target = (q1Sum + q2Sum) / 2;

  }
    


  public int solution(int[] queue1, int[] queue2) {
      
    init(queue1, queue2);
      
      
    while (counter <= queue1.length * 3 - 1) {
      if (q1Sum == q2Sum && q1Sum == target) {
        return counter;
      } else if (q1Sum < q2Sum) {
        int q2Element = q2.poll();
        q1Sum += q2Element;
        q2Sum-=q2Element;
        q1.add(q2Element);
        counter++;
      } else if(q1Sum > q2Sum) {
        int q1Element = q1.poll();
        q2Sum += q1Element;
        q1Sum-=q1Element;
        q2.add(q1Element);
        counter++;
      }
    }
    return -1;
  }

}