import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        
        for(Integer l : lostList){
            if(reserveList.contains(l)){
                reserveList.remove(l);
                temp.add(l);
            }
        }
        
        for(Integer t: temp){
            if(lostList.contains(t)){
                lostList.remove(t);
            }
        }
        
        temp.clear();
        
        for(Integer r : reserveList){
            int smallSize = r-1;
            int biggerSize = r+1;
            
       
             if(lostList.contains(smallSize)){
                lostList.remove(new Integer(smallSize));
                continue;
            }
            else if(lostList.contains(biggerSize)){
                lostList.remove(new Integer(biggerSize));
                continue;
            }
            }
        return n - lostList.size();
        }
        
    
}