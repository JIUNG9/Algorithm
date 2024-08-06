import java.util.*;
import java.util.regex.*;


class Solution {
    private Pattern p;
    private int intersectionCount = 0;
    private int unionCount = 0;
    public int solution(String str1, String str2) { 
//소문자, 대문자 상관없이 연속된 영어의 2개의 조합만을 검사하여 두 개의 합집합의 크기와 교집합의 크기를 구하여 교집합의 개수 / 합집합의 개수 * 65536 를 구한다 만약 교집합의 개수가 0이라면 1 * 65536을 구한다.
    // Str을 각각 모두 Upper case로 구한 뒤 Pattern을 [A-Z]{2}로 컴파일하여 모든 문자열의 순서쌍 케이스를 확인한다. 각각의 문자열의 Map을 생성하여, 각 맵을 서로가 순회하면서 만약 키 값이 일치한다면 큰 값을 가지는 것이 합집합의 원소가 되고, 작은 것이 교집합의 개수가 된다.
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        
        p = Pattern.compile("[A-Z]{2}");
            
        initMapByInputString(str1,map1,p);
        initMapByInputString(str2,map2,p);
        
    
        float answer = getJarcard(map1,map2);
        // System.out.println("answer: " + answer);
        return (int)(answer * 65536);

        
    }
    private float getJarcard(Map<String,Integer> map1 ,Map<String,Integer> map2){
        Set<String> keySet1 = map1.keySet();
        Set<String> keySet2 = map2.keySet();
        
        for(String key : keySet1){
            if(keySet2.contains(key)){
                int value1 = map1.get(key);
                int value2 = map2.get(key);
                
                int min = (value1 >= value2) ? value2 : value1;
                int max = (value1 >= value2) ? value1 : value2;
                    
                intersectionCount+=min;
                unionCount+=max;  
            }
            else{
                unionCount+=map1.get(key);
            }
        }
        
        for(String secodnKey : keySet2){
            if(!keySet1.contains(secodnKey)) unionCount+=map2.get(secodnKey);
            
        }

        
        return intersectionCount == 0 && unionCount == 0 ? 1 : (float)((float)intersectionCount / (float)unionCount);
        
    }

    
    private void initMapByInputString(String str,Map<String,Integer> map, Pattern p){
        
        for(int i = 0; i < str.length()-1 ; i++){
            String current = str.substring(i,i+2);
            if(p.matcher(current).matches()) {
                map.put(current,map.getOrDefault(current,0)+1);
                }
        }
        
        
        
    }
}