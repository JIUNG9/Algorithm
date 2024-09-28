class Solution {
    public long solution(int n) {
        //n칸 까지 한 칸 또는 두 칸을 뛰어서 도달할 수 있는 방법의 수 
        //1칸을 뛰어서 갈 수 있는 방법은 1개
        //2칸을 뛰어서 갈 수 있는 방법은 2개
        //3칸을 뛰어서 갈 수 있는 방법은 1칸을 뛰어서 갈 수 있는 방법과 2칸을 뛰어서 갈 수 있는 방법을 합친 것이다.
        
        int[] dp = new int[20000];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < 2000; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
        return dp[n-1];

    }
}