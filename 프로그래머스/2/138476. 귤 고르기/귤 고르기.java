import java.util.*;
class Solution {
    public int solution(int k, int[] t) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0; i < t.length; i++){
            map.put(t[i], map.getOrDefault(t[i],0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        int counter =0;
        for(Integer i: list){
            // System.out.println("i: "+ i);
            if(k <= 0) break;
            k-=i;
            counter++;
            
        }
        return counter;
    }
}