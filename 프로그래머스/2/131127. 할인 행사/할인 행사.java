import java.util.*;
class Solution {
    
    //discount 시작부터 10개까지  모두 want의 넘버의 개수를 충족하면 정답 개수 하나 추가
    public int solution(String[] w, int[] n, String[] d) {
        int counter  = 0;
        
        for(int i = 0; i < d.length; i++){
            Map<String,Integer> map = new HashMap<>();
            for(int j =i; j < i+10 && j < d.length; j++){            
                map.put(d[j], map.getOrDefault(d[j],0)+1);
            }
            if(isSatisfyWantedDiscounted(map, w, n)){
                counter++;
            }
            
        }
        
        
        return counter;
    }
    
    public boolean isSatisfyWantedDiscounted(Map<String, Integer> map, String w[], int n[]){
        
        for(int i =0; i < w.length; i++){
            if(map.get(w[i]) ==null || map.get(w[i]) < n[i]) return false;
        }
        return true;
    }
}