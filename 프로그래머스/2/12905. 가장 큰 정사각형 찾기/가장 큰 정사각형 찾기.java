class Solution
{
    
    public boolean isAllElement0(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j]==1) return false;
            }
        }
        return true;
    }
    public int solution(int [][]board)
    {
        
        int answer = 1;
        boolean isAllElementIs0 = isAllElement0(board);
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                
                if(board[i][j] == 1){
                    board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]), board[i-1][j-1]) + 1;
                }
                answer = Math.max(answer,board[i][j]);
            }
        }
        return isAllElementIs0 == true ? 0 :  answer * answer;
    }
}