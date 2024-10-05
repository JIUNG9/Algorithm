class Solution {
    private int answer = -1;
    int solution(int[][] land) {

        //두 번째 행부터 끝 행까지 매 줄마다 자기 자신과 동일한 열을 제외한 이전 줄의 가장 큰 값을 더하여 마지막 행의 가장 큰 값을 반환한다.
        int len = land.length;
        int width = land[0].length;
        int[][] dp = new int[len][width];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i = 1; i < len; i++){
            for(int j = 0; j < width; j++){
                int max = -1;
                for(int k = 0; k < width; k++){
                    if(k==j) continue;
                    max = Math.max(max, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + max;
            }
        }
        
        for(int z = 0; z < 4; z++){
            answer = Math.max(answer, dp[len-1][z]);
        }
        return answer;
    }
}