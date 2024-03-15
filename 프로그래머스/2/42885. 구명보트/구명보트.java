import java.util.*;
class Solution {
    public int solution(int[] p, int l) {
        //무게를 정렬
        //가장 무거운 사람을 담아본다. -> 무거운 사람이 limit보다 작다면 가벼운 사람을 계속해서 추가한다.
        //추가하다가 한계를 넘으면 보트를 하나 추가하고 보낸다.
        //만약 그 합이 한계보다 작으면 그 다음 가벼운 사람을 될 때까지 싣는다. 초과했다면 보트를 하나 추가한다. 
        
        //구현 : two pointer
        Arrays.sort(p);

        int light = 0;
        int heavy = p.length-1;
        int sum = p[heavy];
        int counter = 0;
        
        while(light <= heavy){     
            
            sum= p[light] + p[heavy];
        
            
            if(sum > l){
                sum-=p[heavy--];
                counter++;
                
            }
            else{
            heavy--;
            light++;
            counter++;
            }
            
     
            
            
            
        
            }
        return counter;
            }
            
    }
