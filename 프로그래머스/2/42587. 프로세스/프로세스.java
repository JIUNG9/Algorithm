import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {

        //현재 확인하는 작업의 idx가 location과 일치하고  처리해야하는 작업의 우선 순위와 일치한다면 현재까지 처리한 작업의 개수 + 1을 반환한다. 아니라면 현재 확인하는 작업의 우선순위와 처리해야하는 작업 순위가 동일하다면 해당 작업을 처리하고 처리한 작업의 개수를 1 증가시키고 아니라면 해당 작업을 뽑아 가장 맨 마지막으로 넣는다.
        //-> 수정(함축) 현재 확인하는 작업(poll)이 우선순위와 일치하다면 우선순위 작업 큐에서 해당 작업을 처리하고 이때(Inner for loop) idx가 location과 일치하다면 정답을 반환
        
        int counter = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<P> q = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            pq.add(priorities[i]);
            q.add(new P(i,priorities[i]));
        }
        while(!q.isEmpty()){
            P p = q.poll();
                if(p.priority == pq.peek()) 
                {
                    counter+=1;
                    pq.poll();
                    if(p.idx == location) return counter;

                }
                else{
                    q.add(p);
                }
            }
        return counter;

        }
        
    
    class P{
        private int idx;
        private int priority;
        
        public P(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
}