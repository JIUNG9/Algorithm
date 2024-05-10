import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;


class Solution {
 private int counter = 0;
  private Map<String, int[]> move;
  private Set<Person> set;



  public int solution(String dirs) {
    String[] arr = dirs.split("");
    int len = arr.length;
    move = new HashMap<>();
    set = new HashSet<>();
    initMap();
    Person p = new Person(0, 0, 0, 0);

    for (int i = 0; i < len; i++) {
      String dir = arr[i];
      int[] newPosition = move.get(dir);
      int newX = newPosition[0];
      int newY = newPosition[1];
      int willBeMovedX = p.currentX + newX;
      int willBeMovedY = p.currentY + newY;
      p = new Person(willBeMovedX,willBeMovedY,p.currentX,p.currentY);
      Person reversedP = new Person(p.currentX,p.currentY,willBeMovedX,willBeMovedY);
      if (isRangeSatisfied(willBeMovedX, willBeMovedY) && !set.contains(p) && ! set.contains(reversedP)) {
        set.add(new Person(willBeMovedX, willBeMovedY, p.currentX, p.currentY));
        set.add(new Person(p.currentX, p.currentY,willBeMovedX, willBeMovedY));
        counter++;
      }
      if(isRangeSatisfied(willBeMovedX,willBeMovedY)){
        p.updateX(willBeMovedX);
        p.updateY(willBeMovedY);
      }


    }

    return counter;

  }


  public boolean isRangeSatisfied(int willBeMovedX, int willBeMovedY) {
    if (willBeMovedX >= -5 && willBeMovedY >= -5 && willBeMovedX <= 5 && willBeMovedY <= 5) {
      return true;
    }
    return false;


  }

  public void initMap() {
    move.put("U", new int[]{0, 1});
    move.put("D", new int[]{0, -1});
    move.put("R", new int[]{1, 0});
    move.put("L", new int[]{-1, 0});
  }

  class Person {

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Person)) {
        return false;
      }
      Person person = (Person) o;
      return willBeMovedX == person.willBeMovedX && willBeMovedY == person.willBeMovedY
          && currentX == person.currentX && currentY == person.currentY;
    }

    @Override
    public int hashCode() {
      return Objects.hash(willBeMovedX, willBeMovedY, currentX, currentY);
    }

    int willBeMovedX;
    int willBeMovedY;
    int currentX;
    int currentY;

    public Person(int willBeMovedX, int willBeMovedY, int currentX, int currentY) {
      this.willBeMovedX = willBeMovedX;
      this.willBeMovedY = willBeMovedY;
      this.currentX = currentX;
      this.currentY = currentY;

    }

    public void updateX(int x) {
      this.currentX = x;
    }

    public void updateY(int y) {
      this.currentY = y;
    }




  }

  }