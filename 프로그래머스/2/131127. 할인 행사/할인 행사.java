import java.util.*;
class Solution {
    private Map<String,Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        //특정날 부터 10일동안 해당 want에 존재하는 number가 모두 존재한다면 그 날은 사용자가 원하는 개수만큼의 제품이 모두 할인한다는 것을 의미한다.
        //구현 첫 날부터 모든 날까지 10일동안 want와 number를 각각  key,value로 설정한 Map을 만들고 특정날부터 10일동안 해당 number가 모두 0이되는지 확인하여 모두 0이라면 해당 날은 되는 날로 숫자를 세고 아니라면 안 되는날로 센다.
        
        int answer = 0;
     
        for(int j =0; j < discount.length; j++){
            //Should init the Map every time. even point to cache Map, It will use the reference of the cache Key and Value
            initMap(want,number);
            //The second problem is set the k with condition with this for loop
            //by iterating this loop k will be increased so using the K with condition will scan all of element which is smaller than discount.length
            for(int k = j; k < j + 10 && k < discount.length; k++){
            String key = discount[k];
            if(map.containsKey(key)){
                int value = map.get(key) - 1;
                if(value == 0) map.remove(key);
                else{
                    map.put(key,value);
                }
            }
        }
            if(map.size()==0) {
                answer++;
            }
        }
        return answer;
    }
    
    public void initMap(String[] want, int[] number){
        map = new HashMap();
        for(int i = 0; i < want.length; i++){
            map.put(want[i],number[i]);
        }
    }
}