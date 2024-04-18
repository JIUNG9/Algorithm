import java.util.LinkedList;
import java.util.Queue;

class Solution {
  boolean[][] visited;
  private int counter = 0;
  private int currX;
  private int currY;
  private int leverX;
  private int leverY;
  private int destX;
  private int destY;
  private int width;
  private int length;
  private boolean leverFlag = false;
  private final int[][] moved = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};





  public void init(String[] maps) {

    width = maps[0].length();
    length = maps.length;
    visited = new boolean[length][width];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        char c = maps[i].charAt(j);
        if (c == 'X') {
          visited[i][j] = true;
        }
        if (c == 'S') {
          currY = i;
          currX = j;
        }
        if (c == 'E') {
          destX = j;
          destY = i;
        }
        if (c == 'L') {
          leverX = j;
          leverY = i;
        }
      }
    }
  }

  public int solution(String[] maps) {
    init(maps);
    Person p = new Person(currX, currY, counter);
    Queue<Person> q = new LinkedList<>();
    q.add(p);
    //start to lever
    while (!q.isEmpty()) {
      Person currentP = q.poll();

      if (currentP.currX == leverX && currentP.currY == leverY) {
        leverFlag = true;
        currX = leverX;
        currY = leverY;
        counter = currentP.counter;
        break;
      }
      for (int[] m : moved) {
        int movedX = currentP.currX + m[1];
        int movedY = currentP.currY + m[0];
        if (movedX >= 0 && movedX < width && movedY >= 0 && movedY < length) {
          if (!visited[movedY][movedX]) {
            visited[movedY][movedX] = true;
            q.add(new Person(movedX, movedY, currentP.counter + 1));
          }
        }
      }
    }
    if (!leverFlag) {
      return -1;
    }

    init(maps);
    Person startFromLeverPerson = new Person(leverX, leverY, counter);
    q = new LinkedList<>();
    q.add(startFromLeverPerson);

    while (!q.isEmpty()) {
      Person currentP = q.poll();
      if(currentP.currX == destX && currentP.currY == destY){
        return currentP.counter;
      }
      for (int[] m : moved) {
        int movedX = currentP.currX + m[1];
        int movedY = currentP.currY + m[0];
        if (movedX >= 0 && movedX < width && movedY >= 0 && movedY < length) {
          if (!visited[movedY][movedX]) {
            visited[movedY][movedX] = true;
            q.add(new Person(movedX, movedY, currentP.counter + 1));
          }
        }
      }

    }

    return -1;
  }

  class Person {

    private final int currX;
    private final int currY;
    private final int counter;

    public Person(int currX, int currY, int counter) {
      this.counter = counter;
      this.currX = currX;
      this.currY = currY;
    }
  }


}