class Solution {
 public int solution(int n){
    //Using combination with factorial it will be occurred stack over flow.
    //ex)16! already over the int range2.092279e+13

    /**
     * as alternative. can use the Dynamic Programming. because there is the rule. so by increasing
     * index value increase the answer by following the rule *
     */

    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;

    for(int i = 2; i < n; i++){
      dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
    }
    return dp[n-1];
}
}