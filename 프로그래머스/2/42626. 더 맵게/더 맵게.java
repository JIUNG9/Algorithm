import java.util.*;

class Solution {
    public int solution(int[] scoville, int k) {

        Queue<Integer> q = new PriorityQueue<>();
        int len = scoville.length;
        int counter =0;
        
        for(int i = 0; i < len; i++){
            q.add(scoville[i]);
        }
        
        //System.out.println("");
        while(!q.isEmpty()){
            if(q.peek() < k){
                int smallest = q.poll();
                if(q.isEmpty()) return -1;
                int next = q.poll();
                

                int mixed = mixScoville(smallest, next);
                counter++;
                
                q.add(mixed);
                
            }
            else{
                break;
            }
        }
        return counter;
        
    }
    
    public int mixScoville(int smallest, int next){
        return smallest + next * 2;
        
    }
}