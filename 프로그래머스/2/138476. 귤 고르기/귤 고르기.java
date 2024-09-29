import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int[] t) {
        //종류의 개수가 최소가 되게 t에서 k개를 뽑아 귤의 최소의 종류의 값을 반환
        //각 종류별 개수를 구하여 내림 차순 정렬한 후 k가 0이 될 때까지 뺀다.
        Map<Integer,Integer> map = new HashMap<>();
        int answer = 0;
        for(int i = 0; i < t.length; i++){
            int key = t[i];
            if(map.containsKey(key)){
                map.put(key, map.get(key) + 1);
            }
            else{
                map.put(key, 1);
            }
        }
        
        
    List<Integer> amount = map.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        
        
            for(Integer i : amount){
                if(k <= 0) break;
                k-=i;
                answer++;
            }
        return answer;
    }
}