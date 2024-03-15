import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] t) {
        
       //각 귤의 개수를 개수를 파악한 이후 같은 크기의 가장 많은 귤의 개수에서 k를 뺀다.(역순 정렬) 이것을 반복하고 k가 0보다 작아진다면 반복한 횟수를 리턴한다.
        
        int counter =0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i =0; i < t.length; i++){
            map.put(t[i],map.getOrDefault(t[i],0)+1);
        }
        
        List<Integer> valueList = new ArrayList<>(map.values());
        valueList = valueList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        for(int i = 0; i < valueList.size(); i++){
            if(k > 0) {
                k-=valueList.get(i);    
                counter++;
            }
        }
        return counter;
    }
}