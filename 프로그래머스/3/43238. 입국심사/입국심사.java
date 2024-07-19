import java.util.*;
import java.math.BigDecimal;

class Solution {
    private long answer;
    public long solution(int n, int[] times) {
        answer = Long.MAX_VALUE;
        //먼저 고객을 처리하는 심사관을 우선적으로 처리하도록 하여 최적의 결과값을 얻는다.-> 최적:(그리디)
        //n을 조정하여 순회할 수 없다 -> input 값이 10billion
        //시각을 통하여 (Parameterized binary search를 사용해야한다.)
        //특정 시각을 지정하여 특정 시각을 모두 체크할 때 까지, 해당 시각에 모든 요청을 처리할 수 있으면(해당 시각으로 심사관이 처리할 수 있는 인원 수의 합이 n보다 같거나 커야한다.) 더 적은 시각으로 해당 요청을 처리하고 아니라면 더 많은 시각으로 요청을 처리한다. 요청을 처리할 수 있을 때 answer와 비교하여 더 작은 값으로 업데이트한다.
        //int left = 0; int right = 가장 오래걸리는 심사관이 모든 일을 처리; mid = (left + right)
        
        //이후 가장 작은 값을 정답으로 리턴
        Arrays.sort(times);
        int len = times.length;
        long left = 0;
        long right = ((long)times[len/2] * n);
        
        
        
        while(left <= right){
            long mid = (left+right)/2;
            long thePersonNumberWhichIsHandled = getTimeTaken(times,mid);
            if(n <= thePersonNumberWhichIsHandled){
                if(answer > mid) answer = mid;
                right = mid -1 ;
            }
            else{
                left = mid + 1;
            }
        }
        
        return answer;
    }
            
        
    public long getTimeTaken(int[] times, long mid){
        long sum = 0;
        for(int i = 0; i < times.length; i++){
            sum+=(mid / times[i]);
        }
        
        return sum;
        
    
    }
}