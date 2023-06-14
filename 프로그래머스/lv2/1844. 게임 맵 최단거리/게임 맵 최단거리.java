import java.util.*;

class Solution {
    int dx[] = {1,0,-1,0};
    int dy[] = {0,1,0,-1};
    static int row;
    static int col;
    static int visited[][];
    
    public int solution(int[][] maps) {
    
        
        row = maps.length;
        col = maps[0].length;
        visited = new int[row][col];
        bfs(maps);
        //도달하지 못 하는 경우
        if(visited[row-1][col-1] == 0){
            return -1;
        }
        //도달하는 경우
        return visited[row-1][col-1];
    }
    
    public void bfs(int[][] m) {

    int x = 0;
    int y = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{x, y});
    visited[x][y] = 1;
    //진행
    while (!q.isEmpty()) {
      int[] current = q.remove();
      int cX = current[0];
      int cY = current[1];

      //현재 위치에서 nX, nY를 체크하면서 Queue를 진행
      for (int i = 0; i < 4; i++) {
        int nX = cX + dx[i];
        int nY = cY + dy[i];
        //방문하지 못 하는 경우 (사이즈가 넘은 경우, 이미 방문한 경우, 방문 예정인 곳이 0인 경우)
        //ArrayIndexOutOfBoundsException => If I check range with the place which I can go => the error will be trhown

        if (nX < 0 || nX > row-1 || nY < 0 || nY > col-1) {
          continue;
        }
        //방문하는 경우(상, 하, 좌, 우 체크), 가중치 추가
        if (visited[nX][nY] == 0 && m[nX][nY] == 1) {
          q.add(new int[]{nX, nY});
          visited[nX][nY] = visited[cX][cY] + 1;
        }
      }
    }
        
        
        
        
        
}
}