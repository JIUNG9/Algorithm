import java.util.*;
class Solution {
    private int[][] move = {{1,0},{0,1}, {-1,0},{0,-1}};
    public int solution(int[][] maps) {
        //게임 맵을 초과하지 않고, 벽을 넘어서지 않으며(벽에는 갈 수 없음) 가장 최단 거리로 map의 끝지점에 도달하는 거리를 구하시시오. 
        
        //Queue를 통해 이전의 방문했던 것을 다시 한 번 방문하지 않고 맵의 크기를 체크하고, 벽인지 아닌지 체크하며 방문, 방문한 것은 방문처리를하고, 현재까지 방문한 횟수를 기록. 즉 움직인 위치와 현재까지 움직인 거리를 기록해야함. 이때 캐릭터가 map의 끝지점의 다달았을 때 해당 움직인 거리를 반환. 시작 위치는 0,0 이며 시작 시 1의 거리를 움직였다고 판단, 다다를 수 없을 떄는, Q가 더 이상 모든 곳을 방문해 갈 수 없을 때임.(q의 사이즈가 0)
        
        int len = maps.length;
        int width = maps[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[len][width];
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int currY = arr[0];
            int currX = arr[1];
            int counter = arr[2];
            if(currY  == len -1  && currX == width - 1) return counter;
            
            for(int[] m : move){
                int movedY = m[0] + currY;
                int movedX = m[1] + currX;
                if(canGo(movedY,movedX, maps,visited)){
                    visited[movedY][movedX] = true;
                    q.add(new int[]{movedY,movedX, counter+1});
                }
            }
        }
        return -1;
            
    }
    //장애물, 방문처리, 맵 사이즈
    public boolean canGo(int y, int x, int[][] maps , boolean[][] visited){
        if(y < 0 || x < 0 || x >= maps[0].length || y >= maps.length || visited[y][x] == true || maps[y][x] == 0) return false;
            return true;
    }
}