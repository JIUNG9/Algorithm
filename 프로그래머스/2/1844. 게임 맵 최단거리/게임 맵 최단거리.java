import java.util.*;
class Solution {
    int[][] move = {{1,0},{-1,0},{0,-1},{0,1}};
    boolean[][] visited;
    public int solution(int[][] maps) {
        //맵을 넘어서지 않고, 이미 방문한 곳을 방문하지 않고, 벽이 아닌 곳을 방문할 때 가장 빠르게 도착하는 방법, 가장 빠르게 도착했을 때, 진행한 횟수를 반환
        
        Queue<int[]> q = new LinkedList<>();
        int len = maps.length;
        int width = maps[0].length;
        visited = new boolean[len][width];
        visited[0][0] = true;
        
        q.add(new int[]{0,0,1});
        
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int y = arr[0];
            int x = arr[1];
            int counter = arr[2];
            
            if(x == width -1 && y == len -1) return counter;
            
            for(int[] m : move){
                int moveY = y + m[0];
                int moveX= x + m[1];
                if(canGo(moveY, moveX, len, width,maps)){
                    visited[moveY][moveX] = true;
                    q.add(new int[]{moveY,moveX,counter+1});
                }
            }
            
            
            
        }
        
        return -1;
        
    }
    
    public boolean canGo(int currentY , int currentX, int mapY, int mapX, int[][] maps){
        if(currentX >= 0 && currentY >= 0 && currentX < mapX && currentY < mapY && !visited[currentY][currentX] && maps[currentY][currentX]!=0) return true;
        return false;
    }
}