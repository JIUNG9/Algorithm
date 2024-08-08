import java.util.*;
class Solution {
    
    private int counter = 0;
    private Queue<Task> tasks;
    private Queue<Integer> q;


  public int solution(int[] priorities, int location) {

    tasks = new LinkedList<>();
    q = new PriorityQueue<>(Collections.reverseOrder());
    init(priorities);

    while (!q.isEmpty() && !tasks.isEmpty()) {
      Task task = tasks.poll();
      if (task.idx == location && task.priority == q.peek()) {
        counter++;
        break;
      } else if (task.priority == q.peek()) {
        counter++;
        q.poll();
      } else {
        tasks.add(new Task(task.idx, task.priority));
      }
    }
    return counter;

  }

  public void init(int[] priorities) {
    int len = priorities.length;

    for (int i = 0; i < len; i++){
      Task task = new Task(i, priorities[i]);
      q.add(priorities[i]);
      tasks.add(task);
    }

  }

}

class Task {


  int idx;
  int priority;

  public Task(int idx, int priority) {
    this.idx = idx;
    this.priority = priority;
  }

  public String toString() {
    return "this idx : " + idx + " ," + "this priority : " + priority;


  }
}