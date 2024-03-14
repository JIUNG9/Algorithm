import java.util.*;

class Solution {
    
    private boolean[] visited;
    private int answer = -1;
    public int solution(int k, int[][] d) {
        //완전탐색 -> 순회가 가능하다 input이 8 이하
        //최소 필요도, 소모 필요도가 같을 수 있다.
        //유저가 탐험할 수 있는 최대 던전 수 -> Math.max
        //dfs() 방식 사용
        //visited[d.length] 사용
        // for loop 사용
        // counter를 증가시키면서 dfs 순회
        // 종료 조건: 현재 피로도 < 최소 필요 피로도
        // dfs 조건 -> 종료조건을 제외한 나머지  + 방문하지 않은 경우
        // 재귀 -> visited[]를 true,counter 1 증가, 현재 피로도 - 현재 던전 탐색 필요 소모도
        /*
        
        pseudo
        boolean[] visited = visited[d.len] (전역 변수)
        dfs(int[][] d, int counter, int currentHp) 
        {
        for(int i = 0; i < d.length; i++){
            if(!visited[i]) continue;
            if(d[i][0] > currentHp){
                answer = Math.max(ansewr,counter) // answer 전역변수
            } 
            
            else{
                visited[i] = true;
                dfs(d,counter+1, currentHp - d[i][1]);
            }
            
        }
        }
        */
        
        int len = d.length;
        visited = new boolean[len];
        dfs(d,0,k);
        return answer;
    
        
    }
 public void dfs(int[][] d, int counter, int currentHp) 
        {
        for(int i = 0; i < d.length; i++){
            if(!visited[i] && d[i][0] <= currentHp){
                visited[i] = true;
                dfs(d,counter+1, currentHp - d[i][1]);
                visited[i] = false;
            }
            else if(d[i][0] > currentHp){
                answer = Math.max(answer, counter);
            }
            
        }
        }
}