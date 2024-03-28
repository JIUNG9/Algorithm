import java.util.*;
class Solution {
    public int solution(int[][] t) {
        int answer = Integer.MIN_VALUE;
        int[][] dp = new int[500][500];
        dp[0][0] = t[0][0];
        dp[1][0] = t[1][0] + dp[0][0];
        dp[1][1] = t[1][1] + dp[0][0];
        
        
        for(int i = 2; i < t.length; i++){
            int currLen = t[i].length;
            for(int j  = 0; j < currLen; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][0] + t[i][0];
                }
                else if(j == currLen-1){
                    dp[i][j] = dp[i-1][currLen-2] + t[i][currLen-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + t[i][j];
                }
                
            }
        }
        int lastLayerTheNumber = t[t.length-1].length;
        for(int k = 0; k < lastLayerTheNumber; k++)
        {
            if(answer < dp[t.length-1][k]) answer = dp[t.length-1][k];
        }
        return answer;
    }
}