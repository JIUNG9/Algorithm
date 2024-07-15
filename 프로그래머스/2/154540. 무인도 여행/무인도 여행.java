import java.util.*;
class Solution {
    private List<Integer> answerList;
    private boolean[][] visited;
    private int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    public int[] solution(String[] maps) {
        int len = maps.length;
        int width = maps[0].length();
        visited = new boolean[len][width];
        answerList = new ArrayList<>();
        
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < width; j++){
                char c = maps[i].charAt(j);
                if(c!='X' && !visited[i][j]){
                    int counter = 0;
                    Queue<Location> q = new LinkedList<>(); 
                    counter+=Character.getNumericValue(maps[i].charAt(j));
                    q.add(new Location(i,j));
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        
                        Location l = q.poll();

                        for(int[] m : move){
                            int y = l.y + m[0];
                            int x = l.x + m[1];
                            if(rangeCheck(y,x,len,width) && !visited[y][x] && maps[y].charAt(x) !='X'){
                                visited[y][x] = true;
                                counter+=Character.getNumericValue(maps[y].charAt(x));
                                q.add(new Location(y,x));    
                            }
                        }
                    }
                    answerList.add(counter);
                }
            }
                    
        }    
        if(answerList.size()==0) return new int[]{-1};
        return answerList.stream().sorted().mapToInt(i->i).toArray();
        
    
    }
    
    public boolean rangeCheck(int y,int x ,int len, int width){
        if(x >= 0 && y >= 0 && x < width && y < len) return true;
        return false;
    }

     class Location{
        int y;
        int x;
        public Location(int y, int x){
            this.x = x;
            this.y = y;
        }
        
    }
}