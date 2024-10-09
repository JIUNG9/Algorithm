import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        //모든 숫자를 even하게 만드는 것이 중요.
        //s를 n으로 나누어 모든 숫자를 구하고 나머지 숫자만큼 모두 가장 평등하게 만드는 방법을 사용, 가장 작은 숫자가 항상 top이 오게 만들어 해당 숫자를 하나 증가시킨다.
        //Collections.reverseOrder가 아님 even하게 해야하기 때문에 가장 작은 숫자가 top에 와야하므로
        //시간 초과.
        //결국 같은 숫자를 배정한다음 남은 나머지를 일정하게 모두 배분하는 것이 최적의 해, 또한 s / n이 == 0이라면 return -1
        int[] answer = new int[n];
        int remainder = s % n;
        int idx = 0;        
        if(s /n == 0) return new int[]{-1};
        for(int i = 0; i < n; i++){
            answer[idx++ % n] = (s/n);
       }
        while(remainder > 0){
            answer[idx%n] +=1;
            remainder--;
            idx++;
        }
        Arrays.sort(answer);
        return  s / n == 0 ? new int[] {-1} : answer;
        
        
        
    }
}