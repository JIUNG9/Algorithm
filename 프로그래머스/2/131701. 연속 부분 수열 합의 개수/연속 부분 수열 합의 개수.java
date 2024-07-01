import java.util.*;

class Solution {
    Set<Integer> set;
    public int solution(int[] elements) {
        int len = elements.length;
         set = new HashSet<>(); 
        for(int i = 0; i < len; i++){
            int sum = 0;
            for(int j = i; j < len + i; j++){               
                sum+=elements[j % len];
                set.add(sum);
            }
        }
        return set.size();
    }
    public void sout(){
        for(Integer i : set){
            System.out.println("i: " + i);    
        }
        
    }
}