import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[][] r) {

        int answer = 0;
        Arrays.sort(r,(o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });

        
        
        int pointer = r[0][1];
        for(int i = 1; i < r.length; i++){
            if(pointer < r[i][0]){
                pointer = r[i][1];
                answer++;
                // System.out.println("answer:" + answer);
            }
        }
        
        

        return answer+1;
        
    }
}




