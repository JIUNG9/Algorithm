import java.util.*;
class Solution {
   public int solution(int bl, int weight, int[] tr) {
    Queue<Truck> waitedQ = new LinkedList<>();
    Queue<Truck> movingQ = new LinkedList<>();
    int answer = 0;
    int totalW = 0;
    for (int i : tr) {
      waitedQ.add(new Truck(i));
    }
    //기다리는 트럭이 존재하지 않을 때 까지 반복
    //한 번에 하나의 트럭씩 진입
    //만약 현재의 무게가 weight보다 작다면 다리에 한 번 더 적재, 또한 bl보다 현재 다리에 있는 트럭 +1 이 작거나 같아야함, 또한 대기 중인 트럭이 존재
    //무빙 큐에 있는 것들은 하나씩 무빙, 그리고 이미 도달했다면 삭제

    while (!waitedQ.isEmpty() || !movingQ.isEmpty()) {
      answer++;

      //움직이는 것이 없다면 하나를 대기 중인 트럭을 가져오기
      if (movingQ.isEmpty()) {
        Truck t = waitedQ.poll();
        totalW += t.getWeight();
        movingQ.add(t);
          continue;
      }

      //다리에 있는 트럭  움직이기
        for (Truck t : movingQ) {
          t.moving();
        }
      //다리를 지난 트럭 내리기
         if (movingQ.peek().move > bl) {
                Truck t = movingQ.poll();
                totalW -= t.weight;
            }
        
      //다리에 올릴 수 있는 트럭 체크하고 올리기
      if (!waitedQ.isEmpty() && totalW + waitedQ.peek().getWeight() <= weight && movingQ.size()+1 <= bl) {
        Truck t = waitedQ.poll();
        totalW += t.getWeight();
        movingQ.add(t);
      }
    }
    return answer;
  }


  class Truck {

    int weight;
    int move;

    public Truck(int weight) {
      this.weight = weight;
      move = 1;
    }

    public void moving() {
      this.move++;
    }

    public int getWeight() {
      return this.weight;
    }

    public int getMove() {
      return this.move;

    }
  }
}