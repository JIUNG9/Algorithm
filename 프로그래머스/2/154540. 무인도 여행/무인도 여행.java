import java.util.*;

class Solution {
    private int[][] move = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        Queue<Position> q = new LinkedList<>();
        int length = maps.length;
        int width = maps[0].length();
        boolean[][] visited = new boolean[length][width];
        
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++){
                char c = maps[i].charAt(j);
                if(c !='X' && !visited[i][j]){
                    int sum = Character.getNumericValue(c);
                    q.add(new Position(j,i));
                    visited[i][j] = true;
                    
                    while(!q.isEmpty()){
                        Position p = q.poll();
                        
                        int currentX = p.x;
                        int currentY = p.y;
                        
                        for(int[] m : move){
                            int movedPositionX = p.x + m[0];
                            int movedPositionY = p.y + m[1];
                            if(movedPositionX >= 0 && movedPositionY >=0 && movedPositionX < width &&  movedPositionY < length && !visited[movedPositionY][movedPositionX]){
                                char characterValue = maps[movedPositionY].charAt(movedPositionX);
                                if(characterValue!='X'){
                                sum+=Character.getNumericValue(maps[movedPositionY].charAt(movedPositionX));
                                q.add(new Position(movedPositionX,movedPositionY));
                                visited[movedPositionY][movedPositionX] = true;
                                }
                            }
                        }
                    }
                    list.add(sum);
                }
            }
        }
        if(list.size()==0) return new int[]{-1};
        return list.stream().sorted().mapToInt(i->i).toArray();
        
        
        
    }
    
    class Position{
        int x;
        int y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        
    }
}