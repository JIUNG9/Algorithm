import java.util.*;
import java.util.stream.*;

class Solution {
    private int counter = 0;
    private Map<Integer,Integer> map;
    public int solution(int k, int[] t) {
        map = new HashMap<>();
        
        for(int i = 0; i < t.length; i++){
            map.put(t[i],map.getOrDefault(t[i],0)+1);
        }
        
        List<Integer> valuesDesc = map.values().stream().sorted((i1,i2)->{
            return Integer.compare(i2,i1);
        }).collect(Collectors.toList());
        
        
        for(Integer i: valuesDesc){
            if(k <= 0) break;
            k-=i;
            counter++;
        }    
            
        return counter;
            
    
    }
}