import java.util.*;
class Solution {
    public int solution(int[][] r) {
        Arrays.sort(r,(o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        
        
        
        int counter = 1;
        int len = r.length;
        int camPosition = r[0][1];
        for(int i = 1; i < len; i++){
            // System.out.println("r[" + i + "][0]: " + r[i][0]);
            // System.out.println("r[" + i + "][1]: " + r[i][1]);

            if(r[i][0] > camPosition){
                counter++;
                camPosition = r[i][1];
            } 
            
            
            
        }
        return counter;
        
        
    }
}