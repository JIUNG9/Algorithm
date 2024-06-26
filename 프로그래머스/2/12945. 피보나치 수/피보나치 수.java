class Solution {
    private int[] dp;
    public int solution(int n) {
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        return dp[n];
        
        
    
    }
}