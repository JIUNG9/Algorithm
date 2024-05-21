
import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (arr1,arr2)->{
            return Integer.compare(arr1[1],arr2[1]);
        });
        int camera = 0;
        int len = routes.length;
        int idx = 0;
        int currentStartPointIdx = 0;
        int currentEndPointIdx = 0;
        
        
        while(currentEndPointIdx < len && currentStartPointIdx < len){
            
             if(routes[currentEndPointIdx][1] >= routes[currentStartPointIdx][0]){
                currentStartPointIdx++;
                 
            }
            else{
                currentEndPointIdx = currentStartPointIdx;
                camera++;   
            }
            
        }
        return camera+1;
    }
}