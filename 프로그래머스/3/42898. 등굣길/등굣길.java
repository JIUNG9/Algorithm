import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] dp = new int[n+1][m+1];
        boolean[][] isPuddle = new boolean[n+1][m+1];
        
        
        for(int[] p : puddles){
            isPuddle[p[1]][p[0]] = true;
        }
        
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= m; j++){
        //         System.out.println("boolean: "+ isPuddle[i][j]);
        //     }
        // }
        
        for(int i = 1; i <= n; i++){
            if(isPuddle[i][1]) break;
            dp[i][1] = 1;
        }
        
        for(int j = 1; j <= m; j++){
            if(isPuddle[1][j]) break;
            dp[1][j] = 1;
        }
        
        
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= m; j++){
                if(i == 1 && j ==1) continue;
                if(isPuddle[i][j]){
                    dp[i][j] = 0;
                } 
                else{
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) %1000000007;
            }
                    // System.out.println("dp[" + i + "]" + "[" + j+"] : "+ dp[i][j]);

        }
        }
        return dp[n][m];
        
        
        
    }
}