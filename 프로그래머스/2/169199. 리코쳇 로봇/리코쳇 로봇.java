import java.util.*;
class Solution {
    private int[][] move ={{1,0},{0,1},{-1,0},{0,-1}};
    public int solution(String[] b) {
        //시작 위치를 구하여 상, 하, 좌, 우로 이동하여 맵을 넘기 전, D를 만나기 전 그리고 방문했던 적이 없는 경우 같은 방향으로 이동한다. 이동한 곳에서 똑같은 곳으로 움직이는 것을 막기 위해 방문 처리를하고 움직인 곳에서 동일하게 반복하여 G에 도달하도록 하여라, 만약 도달시킬 수 없다면 0을 반환하고. 만약 도달한다면 이때까지 진행했던 회차를 반환한다. 
        //"방문했던 적이 없는 경우" -> This meant, every step while moving the current position is already visited can't be visited. -> This is the wrong. the last position user is stopped cuz of the map size and obstacle. Otherwise this logic make this work "벽을 만나거나 장애물을 만난 경우" 해당 지점이 이미 방문했던 적이 있다면 해당 지점에서는 더 이상 검사를 하지 않는다. 만약 방문했던 적이 없더라면 해당 지점을 방문처리 하고 다른 방향 또한 체크한다.
        
        
        //Impl: be cautious not to change the object reference value(robot) while iterating. The value should be changed every iteration. So NOT TO USE THE OBJECT TYPE WITH THIS PROBLEM CAN BE IDEAL OR MAKE THE NEW REFERNCE EVERY TIME
        int[] start = findStr(b,'R');
        int[] dest = findStr(b,'G');
        List<int[]> ob = findStrReturningWihtList(b,'D');
        Map map = new Map(b.length, b[0].length());
        boolean[][] visited = new boolean[b.length][b[0].length()];
        Queue<Robot> q = new LinkedList<>();
        
        q.add(new Robot(0,start));
        visited[start[0]][start[1]] = true;
        
        while(!q.isEmpty()){
            Robot robot = q.poll();
            int[] p = robot.position;
       
            for(int[] m: move){
                int y = p[0]; 
                int x = p[1];
                //언제 방문처리를 하고, 가지 못 하게 할 것인가?
                while(map.canGo(y + m[0], x + m[1]) && b[y+m[0]].charAt(x+m[1])!='D'){
                    y+=m[0];
                    x+=m[1];    
                }
                
                
                int[] updatedLocation = new int[]{y,x};
                
                if(updatedLocation[0] == dest[0] && dest[1] == updatedLocation[1]) return robot.counter + 1;
                else if(!visited[updatedLocation[0]][updatedLocation[1]]){
                    Robot newRobot = new Robot(robot.counter + 1, updatedLocation);
                    q.add(newRobot);
                    visited[y][x] = true;
                }
            }
            
            
        }
        return -1;
        
        
        
        
        
    }
    public int[] findStr(String[] b,char target){
        for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[i].length(); j++){
                if(b[i].charAt(j) == target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    public List<int[]> findStrReturningWihtList(String[] b, char target){
        List<int[]> list = new ArrayList<>();
           for(int i = 0; i < b.length; i++){
            for(int j = 0; j < b[i].length(); j++){
                
                if(b[i].charAt(j) == target) 
                {
                    list.add(new int[]{i,j});
                }
            }
        }
    
        return list;
    }
    class Robot{
        private int counter;
        private int[] position;
        
        public Robot(int counter, int[] position){
            this.counter = counter;
            this.position = position;
        }
        
        
    }
    class Map{
        private int y;
        private int x;
        
        public Map(int y, int x){
            this.y = y;
            this.x = x;
        }
        public boolean canGo(int wantToY,int wantToX){
            if(wantToY >= 0 && wantToX >= 0 && wantToY < y && wantToX < x){
                return true;
            }
            return false;
        }
        
        
    }
    
}