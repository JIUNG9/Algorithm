import java.util.*;

class Solution {
    
    private int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int solution(int[][] maps) {
        //상대 팀 진영에 도달 -> 캐릭터가 맵의 끝 자락에 도착했을 때  -> x== length-1 && y == width-1
        //벽으로 막혀있지 않으면 나아갈 수 있음 + 맵을 초과할 수는 없음 -> maps[][] == 1  currentPosition + move < length or width, 
        //하지만 가장 빨리 도달할 수 있는 루트가 있다면 해당 루트로 전진 BFS -> queue -> 상하 좌우를 담으면서 진행 -> 전진 시 x,y counter를 가짐, pop을 할 경우 0 이 x 1이 y, 2가 counter로 이후 위의 조건을 확인
        
        //도착할 수 없다 -> Queue<>가 비어있는데 answer이 -1인경우
        int length = maps.length;
        int width = maps[0].length;
        Queue<int[]> q =new LinkedList<>();
        q.add(new int[]{0,0,1});
        while(!q.isEmpty()){
            int[] arr= q.poll();
            int currentRow = arr[0];
            int currentCol = arr[1];
            int counter = arr[2];
            
            //도달했을 경우 break -> 가장 먼저 도착한 것이므로
            if(currentRow == length-1 && currentCol == width-1){
                return counter;
            }
            
            //상하좌우 + 방문하지 않은 것 체크 + 맵을 초과하지 않은 것
            
            
            for(int i = 0; i < 4; i++){
                int moveToRow = currentRow + move[i][0];
                int moveToCol = currentCol + move[i][1];
            
                //방문한 경우 방문처리,q에 추가
                if( !isExceededMapSize(moveToRow,moveToCol,length,width) &&  maps[moveToRow][moveToCol] == 1){
                    maps[moveToRow][moveToCol] = 0;
                    q.add(new int[]{moveToRow,moveToCol,counter+1});
                }
                
            }                    
                }
        return -1;
            }

        
    
    public void moveThePosition(int x, int y, int counter, Queue<int[]> q){
        q.add(new int[]{x,y,counter+1});
    }
    

    public boolean isExceededMapSize(int row, int col, int mapRow, int mapCol){
        if(row >= mapRow || col >=  mapCol || col < 0 || row < 0) return true;
        
        return false;
    }
}