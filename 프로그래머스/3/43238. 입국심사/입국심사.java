import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        //1부터 가장 큰 값이 모두 처리하는 시간까지
        //모든 시간을 처리할 수 없다면 끝 지점 + 현재 지점 / 2, 만약 모두 처리할 수 있다면 현재지점을 끝지점으로 반환, 만약 모두 처리할 수 있다면 정답 반환.
        
        Arrays.sort(times);
        long left = 0;
        long right = 1000000000000000000L;
        long sum = 0;
        long mid = (left + right)/2;
        while(left < right){
            sum = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < times.length; i++){
                sum+=(mid / times[i]);
            }
            if(sum >= n){
                right = mid;
            }
            else if(sum < n){
                left = mid + 1;
            }
                
        }  
        return left;
    
        
    }
}