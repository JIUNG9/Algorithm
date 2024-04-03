import java.util.*;
class Solution {
    public int[] solution(int[] n) {
        LinkedList<int[]> q = new LinkedList<>();
        int[] answer = new int[n.length];
        for(int i = 0; i < n.length; i++){
            int currentValue = n[i];
            while(!q.isEmpty() && q.peekLast()[1] < currentValue){        
                    int[] arr = q.pollLast();    
                    int idx = arr[0];
                    answer[idx] = currentValue;    
                }
                        q.add(new int[]{i, currentValue});
            }
    
        while(!q.isEmpty()){
            int[] arr = q.poll();
            answer[arr[0]] = -1;
        }
        
        return answer;
        
        }
        
        
    }
