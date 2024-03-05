import java.util.*;
class Solution {
    private int answer = -1;
  public int solution(int[][] maps) {
    Queue<int[]> q = new LinkedList<>();


    int mapLength = maps.length;;
    int mapWidth = maps[0].length;
    boolean[][] visited = new boolean[mapLength][mapWidth];
    q.add(new int[]{0,0,1});
    visited[0][0]= true;

    while(!q.isEmpty()){
      int[] polled =q.poll();
      int x = polled[0];
      int y = polled[1];
      int counter = polled[2];
      if(x == mapWidth-1 && y == mapLength-1){
        answer = Math.max(counter,answer);
      }
      if(canGo(maps,y+1,x,mapLength,mapWidth,visited)){
        q.add(new int[]{x,y+1,counter+1});
      }
      if(canGo(maps,y,x+1,mapLength,mapWidth,visited)){
        q.add(new int[]{x+1,y,counter+1});
      }
      if(canGo(maps,y-1,x,mapLength,mapWidth,visited)){
        q.add(new int[]{x,y-1,counter+1});
      }
      if(canGo(maps,y,x-1,mapLength,mapWidth,visited)){
        q.add(new int[]{x-1,y,counter+1});
      }
    }
    return answer;
  }


  public boolean canGo(int[][] maps, int len, int width, int mapLen, int mapWidth,
      boolean[][] visited) {
    if(len < mapLen && width < mapWidth && len >= 0 && width >= 0 && maps[len][width] != 0 && !visited[len][width])
    {
      visited[len][width] = true;
      return true;
    }
    return false;
  }

}