class Solution {
    private int answer = 0;
    private boolean[] visited;
    public int solution(int n, int[][] c) {
        int len = c.length;
        visited = new boolean[len];
        
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(i!=j && !visited[i]){
                    visited[i] = true;
                    dfs(i,c);
                    answer++;
                }
            }
        }
        
        return answer == 0 ? len : answer;
        /*
        for(i ; i < len; i++)
        if(방문하지 않았고 연결되어있다면)
        연속적으로 연결된 것을 확인(dfs)
        연결된 것은 하나의 간선으로 간주하고 answer 값을 추가
        */
    }
    
    public void dfs(int connectedIdx, int[][] c){
        /*
        for(i;i < len; i++)
        if(currentIdx!= i && 방문하지 않았다면)
        방문처리
        dfs(connectedIdx, i)
        */
        for(int i = 0; i < c.length; i++){
            if(connectedIdx!=i && c[connectedIdx][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(i,c);
            }
        }
    }
        
        
}