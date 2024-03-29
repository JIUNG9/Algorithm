import java.util.*;
class Solution {
    private int answer = 0;
    private boolean[][] visited;
    public int solution(int n, int[][] c) {
        
        int len = c.length;
        visited = new boolean[len][len];
        
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i==j) continue;
                if(!visited[i][j] && !visited[j][i]&& c[i][j] == 1 &&  c[j][i] == 1){
                    visited[i][j] = true;
                    visited[j][i] = true;
                    dfs(c,j,i);
                    answer++;
                
            }
        }
        }

            return answer+getNotConnectedNodeCount(visited);
    
    }
        
        
            
        

    
    public int getNotConnectedNodeCount(boolean[][] visited){
        int counter = 0;
        for(boolean[] boolArr: visited){
            boolean flag = false;
            for(boolean b: boolArr){
                if(b) flag = true;
            }
            if(!flag) counter++;
        }
        return counter;
    }
    
    
    public void dfs(int[][] c, int targetNode, int originNode){
        int len = c.length;
        for(int i = 0; i < len; i++){
            if(i==targetNode) continue;
            if(c[targetNode][i] == 1 && c[i][targetNode] == 1 && !visited[targetNode][i] && !visited[i][targetNode]){
                visited[i][targetNode] = true;
                visited[targetNode][i] = true;
                dfs(c,i,targetNode);
            }
            
            }
        }
    
}