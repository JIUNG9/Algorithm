class Solution {
    public long solution(int n) {
        //반환 값 long
        //1234567 나머지 연산자
        //n이 주어질 때, 도달할 수 있는 경우의 수
        //1,1,1,1 / 1, 2, 1 / 1,1, 2/ 2 1 1 / 2 2
        //1과 2를 사용해서 도달 할 수 있는 것
        //1일 때는 1, 2일 때는 1,1 / 2 -> 2가지
        //3일 때는 2를 도달하는 방법과 하나를 가는 방법
        //dp[n] = dp[n-2] + dp[n-1] % 1234567
        if(n==1) return 1;
        if(n==2) return 2;
        
        long[] dp = new long[n];
        dp[0] = 1L;
        dp[1] = 2L;
        for(int i = 2; i < n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        return dp[n-1];
        
    }
}