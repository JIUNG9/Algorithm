import java.util.Map;
import java.util.HashMap;
class Solution {
    public int solution(int[] t) {
        int counter = 0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        
        for(int i = 0; i < t.length; i++){
            map2.put(t[i], map2.getOrDefault(t[i],0)+1);
        }
        
        
        for(int i =0; i < t.length; i++){
            map1.put(t[i], map2.getOrDefault(t[i],0)+1);
            if(map2.containsKey(t[i]) && map2.get(t[i])==1){
                map2.remove(t[i]);
            }
            else{
                map2.put(t[i], map2.get(t[i])-1);
            }
            if(map1.size() == map2.size()) counter++;
        }
        return counter;

    }
}