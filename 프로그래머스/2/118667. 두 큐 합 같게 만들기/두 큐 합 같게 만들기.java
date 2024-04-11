import java.util.*;
import java.util.stream.*;

class Solution {
    
    Queue<Integer> q1;
    Queue<Integer> q2;
    
    public long getSum(int[] arr){
        int len = arr.length;
        int sum = 0;
        for(Integer i : arr){
            sum+=i;
        }
        return sum;
    }
    public int solution(int[] queue1, int[] queue2) {
        
        int counter = 0;
        List<Integer> list1 = Arrays.stream(queue1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(queue2).boxed().collect(Collectors.toList());
        q1 = new LinkedList<>(list1);
        q2 = new LinkedList<>(list2);
        
        int limit = 600000;
        long q1Sum = getSum(queue1);
        long q2Sum = getSum(queue2);
        
        
        while(!q1.isEmpty() && !q2.isEmpty()){
    
            if(q1Sum == q2Sum) return counter;
            if(counter > limit) return -1; 
                
            else if(q1Sum < q2Sum){    
                int value = q2.poll();
                q1Sum+=value;
                q2Sum-=value;
                q1.add(value);
                counter++;
            }
            else{
                int value = q1.poll();
                q2Sum+=value;
                q1Sum-=value;
                q2.add(value);
                counter++;
            }
            
        }
        
        return -1;
        
        
        
        
    }
}