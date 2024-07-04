import java.util.*;

class Solution {
    private int[][] move = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private boolean[][] visited;
    public int solution(int[][] maps) {

        int targetX = maps[0].length-1;
        int targetY = maps.length-1;
        int length = maps.length;
        int width = maps[0].length;
        
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{0,0,1});
        
        visited = new boolean[length][width];
        
        
        
        
        
        while(!q.isEmpty()){
            int[] current  = q.poll();
            int currentY = current[0];
            int currentX = current[1];
            int weight = current[2];
            if(currentX == targetX && currentY == targetY) return weight;
            else{
                for(int[] m : move){
                    int movedY = currentY + m[0];
                    int movedX = currentX + m[1];
                    if(movedY >= 0 && movedX >=0 && movedY < length && movedX < width && !visited[movedY][movedX] && maps[movedY][movedX] == 1){
                        visited[movedY][movedX] = true;
                        q.add(new int[]{movedY,movedX,weight+1});
                    }
                }
            }
        }
        return -1;
    }
    
}