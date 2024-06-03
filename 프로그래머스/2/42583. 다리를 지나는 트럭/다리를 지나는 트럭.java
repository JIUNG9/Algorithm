import java.util.PriorityQueue;
    
class Solution {

     private int secondCounter = 0;
    
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Bridge bridge = new Bridge(bridge_length, weight);
    int idx = 0;

    while (idx < truck_weights.length) {
      Truck newTruck = new Truck(truck_weights[idx]);
      if (bridge.canLoad(newTruck)) {
        bridge.load(newTruck);
        idx++;
      }
      secondCounter++;
      bridge.move();
      bridge.unload();

    }

    while (!bridge.isBridgeEmpty()) {
      secondCounter++;
      bridge.move();
      bridge.unload();
    }
    return secondCounter+1;

  }

  class Truck {

    int weight;
    int movedTime;


    public Truck(int weight) {
      this.weight = weight;
      this.movedTime = 0;
    }

    public void move() {
      this.movedTime += 1;
    }
  }

  class Bridge {

    int currentWeight;
    int tolerableWeight;
    int length;
    PriorityQueue<Truck> truckQ;


    public Bridge(int length, int tolerableWeight) {
      this.tolerableWeight = tolerableWeight;
      this.length = length;
      this.truckQ = new PriorityQueue<>((t1, t2) -> {
        return Integer.compare(t2.movedTime, t1.movedTime);
      });
      this.currentWeight = 0;
    }

    public boolean canLoad(Truck newTruck) {
      return currentWeight + newTruck.weight <= tolerableWeight;
    }

    public boolean isBridgeEmpty() {
      return this.truckQ.isEmpty();

    }

    public void load(Truck newTruck) {
      if (currentWeight + newTruck.weight <= tolerableWeight) {
        truckQ.add(newTruck);
        currentWeight += newTruck.weight;
      }

    }

    public void move() {
      truckQ.forEach(Truck::move);
    }

    public void unload() {
      while (!truckQ.isEmpty() && truckQ.peek().movedTime >= length) {
        this.currentWeight -= truckQ.remove().weight;
      }
    }

  }
}