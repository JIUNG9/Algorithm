import java.util.*;
class Solution {
    
    int[][] move ={{1,0},{0,1},{-1,0},{0,-1}};
    public int solution(String[] board) {
        Queue<int[]> q = new LinkedList<>();
        int[] startP = getPosition(board,'R');
        int[] endP = getPosition(board,'G');
        int[] target = getPosition(board,'G');
        int targetY = endP[0];
        int targetX = endP[1];
        int width = board[0].length();
        int length = board.length;
        boolean[][] visited = new boolean[length][width];
        
        q.add(new int[]{startP[0],startP[1], 0});    
        
        while(!q.isEmpty()){
            int[] currentP = q.poll();
            int currentX = currentP[1];
            int currentY = currentP[0];
            int weight = currentP[2];
            if(currentX == targetX && currentY == targetY) return weight;
            
             for (int[] m : move) {
                int movedY = currentY;
                int movedX = currentX;
                
                while (!(movedY < 0 || movedX < 0 || movedX >= width || movedY >= length || board[movedY].charAt(movedX) =='D')) {
                        movedX+=m[1];
                        movedY+=m[0];
                    }
                    
                
                movedY-=m[0];
                movedX-=m[1];
                
                if (!visited[movedY][movedX]) {
                    visited[movedY][movedX] = true;
                    q.add(new int[]{movedY, movedX, weight + 1});
                }
            }
        }
    
        return -1;
        
    }
    
    
    public int[] getPosition(String[] board, char target){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length(); j++){
                if(board[i].charAt(j) == target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }

    

}
