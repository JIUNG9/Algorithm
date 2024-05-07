import java.util.*;
class Solution {

   public long solution(int n, int[] times) {
        int answer = 0;
        long max = 0;
        for(int i = 0; i < times.length; i++) {
            if(times[i] > max) {
                max = times[i];
            }
        }
        long s = 1, e = max*n, mid;
        long res = e;
        while(s <= e) {
            mid = (s+e)/2;
            long total = 0;
            for(int i = 0; i < times.length; i++) {
                total += (mid / times[i]);
            }
            if(total < n) {
                s = mid + 1;                
            }
            else {
                if(res > mid) {
                    res = mid;
                }
                e = mid-1;
            }
        }
        return res;
    }
}