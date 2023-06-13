import java.util.*;

class Solution {
    
    static int xLen;
    static int yLen;
    static int[][] visited;
    static int dx[] ={1,0,-1,0};
    static int dy[] ={0,1,0,-1};
    
    public int solution(int[][] maps) {
     //visited
        xLen = maps.length;
        yLen = maps[0].length;
        visited = new int[xLen][yLen];
        bfs(maps,visited);
        int ans = visited[xLen-1][yLen-1];
        if(ans == 0){
            return -1;
        }
        return ans;
        
    }
    
    public void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = 1;
        
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];
            
            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                if(nX < 0 || nY < 0 || nX > maps.length-1 || nY > maps[0].length-1 ) continue;
                
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    visited[nX][nY] = visited[cX][cY] + 1;
                    queue.add(new int[]{nX,nY});
                }
            }
            
        }
        
    
        
    }
}