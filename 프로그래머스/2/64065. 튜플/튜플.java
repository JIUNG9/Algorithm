import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;



class Solution {
    public int[] solution(String s) {

         Map<Integer,Integer> map = getOnlyNumberHashMap(s);
        

       return getArrtWithtDESC(map);
        
        

        
        
    }
    
    public int[] getArrtWithtDESC(Map<Integer,Integer> map){
  List<Entry<Integer, Integer>> entry = map.entrySet().stream()
        .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());

    int size = entry.size();
    int counter = 0;
    int[] arr = new int[size];
    for(Entry<Integer,Integer> e : entry){
      arr[counter++] = e.getKey();
    }
        return arr;
    }
    
    
    
    
    public Map<Integer,Integer> getOnlyNumberHashMap(String s){
        
        int len = s.length();
        Map<Integer,Integer> map = new HashMap<>();
        
        
        for(int i = 0; i < len; i++){
                String temp="";
                for(; i < len && s.charAt(i) >= 48 && s.charAt(i) <=57 ; i++){
                    temp = temp.concat(String.valueOf(s.charAt(i)));
                }
                    if(!temp.equals("")){
                        Integer value = Integer.valueOf(temp);
                        map.put(value,map.getOrDefault(value,0) + 1);
                    }
                }
        return map;
            }
        }
