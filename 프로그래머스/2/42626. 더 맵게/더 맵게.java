import java.util.*;
class Solution {
    public int solution(int[] s, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int counter = 0;
        
        for(int i = 0; i < s.length; i++){
            q.add(s[i]);    
        }
        
        while(!q.isEmpty() && q.peek() < k){
            int min = q.poll();
            if(q.isEmpty()) return -1;
            int newScoville = makeNewScoville(min, q.poll());
            q.add(newScoville);
            counter++;
        }
        
        return counter;
        
    }
    
    public int makeNewScoville(int low, int high){
        return low + (high *2);
    }
}