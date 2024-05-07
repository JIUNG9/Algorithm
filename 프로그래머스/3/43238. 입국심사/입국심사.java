import java.util.*;
import java.util.*;
class Solution {
   public static long solution(int n, int[] times) {
       Arrays.sort(times);
        long a = 1;
        long b = (long)times[times.length-1] * (long) n;
        long answer = 0;

        while(a<=b){
            long c = (a+b)/2;

            long sum = 0; // 가능한 인원
            for(int i=0; i<times.length; i++){
                sum += c/times[i];
            }

            if(sum >= n){
                answer = c;
                b = c-1;
            }else{
                a = c+1;
            }
        }

        return answer;
    }

}