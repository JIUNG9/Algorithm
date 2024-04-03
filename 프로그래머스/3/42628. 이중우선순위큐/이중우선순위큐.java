import java.util.*;
class Solution {
    public int[] solution(String[] op) {
        LinkedList<Integer> q = new LinkedList<>();
        
        //1. op를 순회하면서 "l" 을 포함할 경우 list에 추가
        for(String s: op){
            if(s.contains("I")) {
                String[] temp = s.split("I ");
                int number = Integer.parseInt(temp[1]);
                q.add(number);
                q.sort((o1,o2)->{
                    return Integer.compare(o1,o2);
                });
                }
            
                if(s.equals("D -1") && !q.isEmpty()) q.removeFirst();
                if(s.equals("D 1") && !q.isEmpty()) q.removeLast();
        }    
 
        
        if(q.isEmpty()) return new int[]{0,0};
        return new int[] {q.pollLast(), q.pollFirst()};
    }
}