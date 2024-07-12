 import java.util.*;

class Solution {
    private int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    private boolean[][] visited;
    
    public int solution(String[] board) {
        int len = board.length;
        int width = board[0].length();
        visited = new boolean[len][width];
        
        Location start = findLocation(board, 'R');
        Location goal = findLocation(board, 'G');
    
        Queue<Robot> q = new LinkedList<>(); 
        q.add(new Robot(start, 0));
        visited[start.y][start.x] = true;
        
        while (!q.isEmpty()) {
            Robot r = q.poll();
            Location location = r.location;
            int currentMoveCounter = r.moveCounter;
            
            if (location.x == goal.x && location.y == goal.y) {
                return currentMoveCounter;
            }
            
            for (int[] m : move) {
                Location nextLocation = new Location(location.y, location.x);
                
                while (true) {
                    nextLocation.move(m);
                    if (isExceededMap(len, width, nextLocation) || isObstacle(board, nextLocation)) {
                        nextLocation.stepBack(m);
                        break;
                    }
                }
                
                if (!isExceededMap(len, width, nextLocation) && !isVisited(nextLocation.y, nextLocation.x)) {
                    visited[nextLocation.y][nextLocation.x] = true;
                    q.add(new Robot(new Location(nextLocation.y, nextLocation.x), currentMoveCounter + 1));
                }
            }
        }
        return -1;
    }
    
    public Location findLocation(String[] m, char c) {
        int len = m.length;
        int width = m[0].length();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < width; j++) {
                if (m[i].charAt(j) == c) return new Location(i, j);
            }
        }
        return new Location(-1, -1);
    }
    
    public boolean isVisited(int y, int x) {
        return visited[y][x];
    }
    
    public boolean isObstacle(String[] map, Location location) {
        return map[location.y].charAt(location.x) == 'D';
    }

    public boolean isExceededMap(int len, int width, Location current) {
        int x = current.x;
        int y = current.y;
        return x < 0 || y < 0 || x >= width || y >= len;
    }
    
    class Robot {
        private Location location;
        private int moveCounter;
        
        public Robot(Location location, int moveCounter) {
            this.location = location;
            this.moveCounter = moveCounter;
        }
    }
    
    class Location {
        private int y;
        private int x;
        
        public Location(int y, int x) {
            this.x = x;
            this.y = y;
        }
        
        public void move(int[] direction) {
            y += direction[0];
            x += direction[1];
        }
        
        public void stepBack(int[] direction) {
            y -= direction[0];
            x -= direction[1];
        }
    }
}
