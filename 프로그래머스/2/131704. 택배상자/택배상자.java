import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {
   public int solution(int[] order) {
    SupplementBelt supplementBelt = new SupplementBelt();
    MainBelt mainBelt = new MainBelt(1000001);
    Loaded loaded = new Loaded();
    int i = 0;
    int currentShouldBeLoad = order[0];

    while (mainBelt.isThereBox()) {

        while (mainBelt.isThereBox() && mainBelt.currentBox() <= currentShouldBeLoad) {
          supplementBelt.input(mainBelt.out());
        }

      while (supplementBelt.isThereBox() && supplementBelt.getRecentBox() == currentShouldBeLoad) {
        loaded.load(supplementBelt.out());
        i++;
        if (i < order.length) {
          currentShouldBeLoad = order[i];
        }
      }
      if(mainBelt.currentBox() > currentShouldBeLoad){
        if(supplementBelt.isThereBox()){
          if(supplementBelt.getRecentBox() != currentShouldBeLoad) break;
        }
        else break;
      }

}
    return loaded.totalLoaded();


  }


  class Loaded {

    private final List<Integer> list;

    public Loaded() {
      this.list = new ArrayList<>();
    }

    public void load(int value) {
      list.add(value);
    }

    public int totalLoaded() {
      return list.size();

    }

  }


  class MainBelt {

    Queue<Integer> q;

    public MainBelt(int size) {
      init(size);
    }

    private void init(int size) {
      q = new LinkedList<>();
      for (int i = 1; i <= size; i++) {
        q.add(i);
      }
    }

    public int out() {
      return q.poll();
    }

    public boolean isThereBox() {
      return !q.isEmpty();
    }

    public int currentBox() {
      return q.peek();
    }


  }

  class SupplementBelt {

    private Stack<Integer> stk;

    public SupplementBelt() {
      init();
    }

    private void init() {
      stk = new Stack<>();

    }

    public boolean isThereBox() {
      return !stk.isEmpty();
    }

    public void input(int box) {
      if (stk == null) {
        init();
      }
      stk.add(box);
    }

    public int out() {
      return stk.pop();
    }

    public int getRecentBox() {
      return stk.peek();
    }

  }

    
}