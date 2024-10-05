import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        //만약 현재 초에 확인하는 주식이 이전에 저장했던 주식 기록'들'보다 가격이 떨어졌다면(항상 큰 값이 위로 와야한다. PQ DESC) 그떄의 시각과 현재 확인하는 시각의 차이를, 그때의 시각에 기록을 한다. 그리고 현재 시각의 (초) 주식을 초 단위로 기록한다.(큐에등록),  만약 변동 사항이 없다면 해당 값은 바뀌지 않았으므로 지속적으로 1초씩 증가한다.(즉 매번 가장 주식의 가격이 작을 때를 확인하여, 현재 확인하는 것과 비교하고 '이전' 것들 또한 비교한다. )
        
        int len = prices.length;
        int[] answer = new int[len];
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1,arr2)->{
            return Integer.compare(arr2[1],arr1[1]);
        });
        
        for(int i = 0; i < len; i++){
            answer[i] = len-i-1;
        }
        
        pq.add(new int[]{0,prices[0]});
        
        for(int j = 0; j < len; j++){
            int current = prices[j];
            while(!pq.isEmpty() && pq.peek()[1] > current){
                int[] arr = pq.poll();
                int idx = arr[0];
                answer[idx] = j - idx;
            }
            pq.add(new int[]{j,current});
        }
        return answer;
        
        
        
    }
}