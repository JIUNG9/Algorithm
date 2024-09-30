import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        
        //의상 종류별 개수를 구하고 의상의 종류가 한 개라면 해당 종류에 대한 개수를 반환
        //아니라면 종류별 개수들의 곱의 합에서 1개씩만 골라서 입을 수 있는 경우의 수를 즉 모든 값(values)의 총 합을 구한다.(아예 입지 않는 경우의 수 제외이므로)
        
        Map<String, Integer> map = new HashMap<>();
        int sum = 1;
        
        for(int i = 0; i < clothes.length; i++){
            String key = clothes[i][1];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        
        for(Integer i : map.values()){
            sum*=(i+1);
        }
    
        return sum -1;
        
    }
}