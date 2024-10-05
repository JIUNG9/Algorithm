class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        boolean[][] isPuddle = new boolean[n+1][m+1];
        initPuddle(isPuddle, puddles);
        
        for (int i = 1; i < n + 1; i++) {
            if (isPuddle[i][1]) break;
            dp[i][1] = 1;
        }
        for (int j = 1; j < m + 1; j++) {
            if (isPuddle[1][j]) break;
            dp[1][j] = 1;
        }

        for (int y = 1; y < dp.length; y++) {
            for (int x = 1; x < dp[0].length; x++) {
                if (x == 1 && y == 1) continue; 
                if (!isPuddle[y][x]) {
                    dp[y][x] = (dp[y-1][x] + dp[y][x-1]) % 1000000007;
                }
            }
        }
        
        return dp[n][m];
    }
    
public void initPuddle(boolean[][] isPuddle, int[][] p) {
    for (int i = 0; i < p.length; i++) {
        int y = p[i][1];
        int x = p[i][0]; 
        isPuddle[y][x] = true; 
    }
}
}
