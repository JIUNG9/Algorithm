import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
  private final int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  private boolean[][] visited;
  private int width;
  private int length;
    
    
  
  public int solution(int[][] maps) {
    width = maps.length;
    length = maps[0].length;

    visited = new boolean[width][length];

    //init the visited array
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < length; j++) {
        visited[i][j] = false;
      }
    }
    //make the queue and init the position and counter
    Queue<int[]> q = new LinkedList<>();
    //current position
    q.offer(new int[]{0, 0, 1});
    return bfs(maps, q);

  }


  public int bfs(int[][] maps, Queue<int[]> q) {
    //** no matter compare the answer. because use the queue. the shortest path is reached to the target
    //1. if x and y is reached at target position return the counter
    //iteration => check every direction by using for loop
    //* if not visited added in the queue

    while (!q.isEmpty()) {
      int[] xAndYCurrentCounter = q.poll();
      int currentX = xAndYCurrentCounter[0];
      int currentY = xAndYCurrentCounter[1];
      int counter = xAndYCurrentCounter[2];

      if (currentX == width - 1 && currentY == length - 1) {
        return counter;
      }
      for (int[] location : direction) {
        int furtherX = location[0] + currentX;
        int furtherY = location[1] + currentY;

      if(furtherX >= width || furtherX < 0 || furtherY >= length || furtherY < 0 ) continue;

     if (maps[furtherX][furtherY] == 1) {
          maps[furtherX][furtherY] = 0;
          q.offer(new int[]{furtherX, furtherY, counter + 1});
        }
      }
    }
    return -1;
  }

}