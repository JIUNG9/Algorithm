

public class Solution {
    private int answer = 0;
    public int solution(int n) {
        while(n > 0){
            if(n % 2 == 1) answer++;
            n/=2;
        }   
        return answer;
    }
}