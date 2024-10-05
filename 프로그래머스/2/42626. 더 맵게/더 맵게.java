import java.util.*;
class Solution {
    public int solution(int[] s, int K) {
        // 재료가 1개가 남았을 때까지, 모든 원소들이 맵기가 K이상이 될 때까지 가장 맵지 않은 것과 맵지 않은 것을 * 2만큼 섞는다. 이때 가장 맵지 않은 것을 선택했을 때 K이상이라는 것은 모든 맵기가 K이상임을 뜻한다. 이때 반복한 횟수를 구한다. 만약 재료가 1개 남았을 때, 스코빌 지수가 K이상이 아니라면 -1을 반환한다.
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int len = s.length;
        int counter = 0;
        for(int i = 0; i < len; i++){
            pq.add(s[i]);
        }
        
        while(pq.size() > 1){
            if(pq.peek() >= K) return counter;
            int first = pq.poll();
            int second = pq.poll();
            int newProduct = first + second * 2;
            counter++;
            pq.add(newProduct);
        }
        
        return pq.peek() >= K ? counter : -1;
        
    }
}