import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] arr) {
        
        List<Integer> sortedList = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        
        while(sortedList.size() > 1){
            int first = sortedList.get(0);
            int second = sortedList.get(1);
            
            int gcb = getGcb(first,second);
            int lcm = (first/gcb) * second;
            
            sortedList.add(lcm);    
            sortedList.remove(0);
            sortedList.remove(0);

        }
        return sortedList.get(0);
        
        
    }
    public int getGcb(int a, int b){
        int gcb = 1;
        for(int i = 1; i <= a; i++){
            if(a%i == 0 && b%i == 0 && gcb < i){
                gcb = i;
            }
        }
        return gcb;
        
    }
}