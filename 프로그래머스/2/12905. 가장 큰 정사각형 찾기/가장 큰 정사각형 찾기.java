class Solution
{
    private int answer = 0;
    public int solution(int [][]board)
    {
        //모든 원소를 검사하면서 현재 검사하는 원소가 1일 때 동일한 세로의 위치의 원소들이 연속적으로 n번으로 1이라면 가로로도 모두 n길이 만큼 모두 1이고 해당 면적에 관한 것들도 모두 1일 때 최대 정사각형 넓이는 모두 1인 경우 n * n의 넓이를 가진다.
        
        //Impl : 세로로 (1) + (1+2) + (1+2+3)--- 세로, 가로로 접근한다면 n^2이 나온다. 따라서 n^2 * m^2이 나온다. n과 m이 모두 1000이라고 했을 때 시간 초과가 난다. (top down)
        //Impl : 1000의 길이로 가정할 때 1000은 1번(1000만) 999부터 500까지는 2번(가로로만) 이후 500부터는 500번(가로로만) 250부터는 750번(brute force) -> 시간 효율이 낮음
        //Impl : Down top approach, 현재 위치를 기준으로 현재의 값 더하기 이전에 만들어졌던 정사각형 길이 중 가장 작은 것이, 현재 내가 만들 수 있는 가장 큰 길이의 정사각형
            //Down top approach -> 1. init value. 2. procced 3. return(the max value)
        //Missed point: 현재 위치가 0이라면 정사각형은 만들어질 수 없다. 따라서 현재 검사하는 원소가 1이고 이전에 만들어졌던 (대각선, x축, y축)의 원소들 중 가장 작은 것 + 1이 내가 만들 수 있는 것들 중 가장 큰 것
        
        int len = board.length;
        int width = board[0].length;
        int[][] dp = new int[len][width];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j]==1){
                    if(i == 0 || j == 0){
                        dp[i][j] = board[i][j];
                        answer = Math.max(1,answer);
                    }
                else{
                    dp[i][j] = board[i][j];
                    int weight = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
                    dp[i][j]+=weight;
                    answer = Math.max(answer,dp[i][j]);
                }
                
            }
            }
        }
        return answer * answer ;
}

}