import java.util.*;

class Solution {
    
    
    public int findMaxExcludeInputIdx(int[] arr, int idx){
        int max = idx == 0 ? arr[1] : arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i] && idx != i) max = arr[i];                
        }
        return max;
        
    }
    
    int solution(int[][] land) {
        int len = land.length;
        int[][] dp = new int[len][4];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];

        for(int i = 1; i < len; i++){
            for(int j = 0; j < 4; j++){
                int max = findMaxExcludeInputIdx(dp[i-1],j);
                dp[i][j] = land[i][j] + max;
            }
        }
        
        int answer = dp[len-1][0];
        System.out.println("answer: "+ answer);
        for(int k = 0; k < 4; k++){
            if(answer < dp[len-1][k]){
                answer = dp[len-1][k];
            }
        }
        return answer;
        

    }
}