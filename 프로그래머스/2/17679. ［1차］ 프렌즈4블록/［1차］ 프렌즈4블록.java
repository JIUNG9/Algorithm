import java.util.*;
class Solution {
    private int counter = 0;
    public int solution(int m, int n, String[] board) {
        //삭제할 블럭이 없을 때까지 매 라운드마다 현재 블록에서 우, 하, 대각선의 블록이 같다면 해당 블럭을 표시하여 라운드가 끝났을 때 모두 삭제하고 삭제해서 빈 부분의 공백을 공백이지 않은 블럭으로 위에서 찾아 아래부터 채워준다. 삭제할 블럭이 없을 때, 현재까지 해당 블럭의 개수를 반환한다.
        
        char[][] c = new char[m][n];
        
        for(int i = 0; i < board.length; i++){
            c[i] = board[i].toCharArray();
        }
        
        int currentDeleteCounter = -1;
        
        while(currentDeleteCounter != 0){
            boolean[][] b = new boolean[m][n];
            currentDeleteCounter = 0;
            //같은 블럭 삭제 처리,(공백이 아닌 경우)
            for(int j = 0; j < m; j++){
                for(int k = 0; k < n; k++){
                    if(j + 1 < m && k + 1 < n && c[j][k]!=' ' && c[j][k] == c[j+1][k] &&  c[j+1][k] == c[j][k+1] && c[j][k+1] == c[j+1][k+1]){
                        b[j][k] = true;
                        b[j][k+1] = true;
                        b[j+1][k] = true;
                        b[j+1][k+1] = true;
                    }
                }
            }
            //논리의 공백 + 잘못 구현: 
            //한 턴이 끝난 이후, 같은 것들은 모두 공백처리를(삭제)한다.
            for(int x = 0; x < n; x++){
                for(int y = m -1 ; y >= 0; y--){
                    if(b[y][x]){
                        currentDeleteCounter++;
                        c[y][x] =' ';
                }
                }
        }
            counter+=currentDeleteCounter;
            
            
            //삭제 처리를 한 이후,모든 열의 블럭들을 확인하는데 아래의 블럭이 공백이라면 아래서부터 공백이지 않은 것들을 찾아 아래 부분부터 채워준다. 그리고 채웠으면 채웠었던 캐릭터는 공백으로 표시한다.
            for(int i = 0; i < n; i++){
                for(int j = m -1; j >= 0; j--){
                    if(c[j][i]==' '){
                      int idx = j;
                      while(idx >= 0 && c[idx][i]==' '){
                        idx--;
                      }
                        if(idx>=0 && c[idx][i] != ' '){
                            c[j][i] = c[idx][i];
                            c[idx][i] =' ';
                        }
                    }
                }
            }
        
 
        
        
    }
        return counter;

}
}