import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        int len = people.length;
        //1명인 경우 return 1;
        if(len==1) return 1;
        
        Arrays.sort(people);
        
        
        int lightIdx = 0;
        int heavyIdx = len -1;
        
        while (lightIdx <= heavyIdx){
            if(people[lightIdx] + people[heavyIdx] <= limit){
                boat++;
                lightIdx++;
                heavyIdx--;
            }
            else{
                boat++;
                heavyIdx--;
            }
        }
        return boat;
            
            
            
    }
}