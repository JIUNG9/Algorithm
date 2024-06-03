# [level 2] 다리를 지나는 트럭 - 42583 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42583) 

### Approach

- when the current loaded on the bridge total weight is not over the input weight the truck can be on the bridge
- when time passed by the truck should be moved
- when the truck can successfully pass the bridge when move the length of bridge
  

### Object Modeling



#### Truck
``` java

Class Truck
        private weight
        private movedTime;

        //The responsibility The truck should be moved as time passed by
        public move() this.movedTime++;
        public init(int weight) this.movedTime = 0; this.weight = weight
```
#### Bridge

Class Bridge
{
        private PrioirityQueue<Truck> q;
        private int tolerableWeight;
        private int currentWeight;
        private int length

        public Bridge(int toleralbeWeight, int length){
                this.length = length;
                this.tolerableWeight = tolerableWeight;
                q = new PrioirtyQueue<>((t1,t2)-> sorted by truck movedTime desc);
        }

        public void move() q.forEach(t -> t.move);
        public void unload() while(!q.isEmpty() && q.peek().movedTime <= len) currentWeight-=q.remove().weight;
        public void canLoad(Truck newTruck) if(currentWeight + newTruckWeight <= tolerableWeight);
        public void load(Truck newTruck) q.add(newTruck);

        

}

#### implmenetation
- For checking the truck is passed by or current position use the PriorityQueue as the data structure. sorted by the currentTime desc makes doesn't have to check all of the elements in queue
- When the truck is remained at the queue even all truck is loaded should check also when it is unloaded
### code

``` java

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
```


  

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
