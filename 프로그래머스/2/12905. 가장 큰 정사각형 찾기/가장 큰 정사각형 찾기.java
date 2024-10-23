class Solution
{
    public int solution(int [][]board)
    {
        //결국, 가로와 세로에 연속적으로 있는 1의 개수 중 적은 개수의 1의 연속된 숫자의 대해 연속된 숫자 * 연속된 숫자를 구하여라
        //실수 모두 0인 경우
        int x = board[0].length;
        int y = board.length;
        
        int answer = 1;
        boolean all0 = true;
        
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(board[i][j]==1) all0 = false;
                if(fourDirectionCanGo(i, j, board)){
                    board[i+1][j+1] = Math.min(Math.min(board[i+1][j], board[i][j+1]), board[i][j])+ 1;
                    answer = Math.max(board[i+1][j+1],answer);
                }
            }
        }
        return all0 == true ? 0 : answer * answer;
        
    

    }
    public boolean fourDirectionCanGo(int y, int x, int[][] board){
        int len = board.length;
        int width = board[0].length;
        if(y + 1 < len && x + 1 < width){
            if(board[y][x] >= 1 && board[y+1][x] >= 1 && board[y][x+1] >=1 && board[y+1][x+1] >=1) return true;
            else{
                return false;
            }
        }
        return false;
    }
}