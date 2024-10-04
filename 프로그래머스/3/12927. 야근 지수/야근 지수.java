import java.util.*;
class Solution {
    private long[] preCalc;
    public long solution(int n, int[] works) {
        //큰 수를 가장 많이 빼주는 게 가장 적은 제곱 수의 결과가 나온다.
        //야근을 해야하는 만큼, 지속해서 반복하고 가장 많은 양의 일부터 처리한다. 만약 일을 다 처리했으면 해당 일은 더 이상 고려하지 않는다.(끝낸다. -> 3번 테스트 케이스를 잘 확인하면 알 수 있다.)
        //주의할 점 : long 타입으로 해주기 (입력 값 50000), pq empty아닌 것 처리
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        initPreCalc();
        long sum = 0;
        for(int i = 0; i < works.length; i++){
            pq.add(works[i]);
        }
        while(!pq.isEmpty() && n > 0){
            int biggest = pq.poll();
            if(biggest - 1 != 0) pq.add(biggest-1);
            n--;
        }
        
        while(!pq.isEmpty()){
            int element =pq.poll();
            sum+= preCalc[element];
        }
        return sum;
        
    }
    
    public void initPreCalc(){
        preCalc = new long[1000001];
        for(int i = 0; i <= 1000000; i++){
            preCalc[i] = i * i;
        
        }
    }
}