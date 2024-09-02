import java.util.*;
class Solution {
    private int answer = -1;
    private int[][] move = {{-1,0},{0,-1},{1,0},{0,1}};
    public int solution(int[][] maps) {
        //가려는 곳이 벽이 아니고, 맵의 크기를 넘어서지 않고, 이미 방문한 적이 없다면 해당 장소를 방문한다. 방문한 곳은 방문처리를 하고 이후에는 방문하지 않는다. 해당 과정을 최단 거리로 [n-1][m-1]를 도달하였을 때 반복한 횟수를 반환하여라. 만약 도달할 수 없다면 -1을 반환하여라
        
        int len = maps.length;
        int width = maps[0].length;
        boolean[][] visited = new boolean[len][width];
        Queue<int[]> q = new LinkedList<>();
        
        visited[0][0] = true;
        q.add(new int[]{1,0,0});
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int counter = arr[0];
            int y = arr[1];
            int x = arr[2];
            
            if(y == len -1 && x == width -1) return counter;
            
            for(int[] m : move){
                int newY = y + m[0];
                int newX = x + m[1];
                
                if(newY < len && newX < width && newY >= 0 && newX >=0 &&!visited[newY][newX] && maps[newY][newX] != 0){
                    visited[newY][newX] = true;
                    q.add(new int[]{counter+1,newY,newX});
                }
            }
            
        }
        
 
        return answer;
    }
}