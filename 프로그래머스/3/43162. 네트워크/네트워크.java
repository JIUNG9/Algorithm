class Solution {

    private boolean[][] visited;
    
   //1번과 2번이 연결되어있을 때 2번과 연결된 모든 노드들도 연결되어있어 1개라고 표시하면서
    //이미 방문한 것을 제외한 2번 3번 4번 n 번까지 반복하여 연결된 노드의 수를 구한다.
    
    
    // 구현:
    /*
    1번을 먼저 시작하고 자기 자신을 제외한 것을 순회해야한다. 자기 자신은 항상 computers 1 처리가 되어있다.
    방문을 하지 않은 것을 방문해야한다. 1과 2를 방문 했다는 것은 visited[i][j] [j][i] 동일하다 
    
    visited를 dfs에 파라미터로 하지 않는다. 스택 x
    
    
    for(int i =0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(i==j) visited[i][j] = true;
        }
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(c[i][j]==1 && !visited[i][j] && visited[j][i]) {
            dfs(c,j,i);
            counter++;
        }
    }
    
    //1과 2가 연결되어있다고 할 때 2와 연결된 모든 노드들을 1과 방문 처리
    public void dfs(int[][] c, int node, int connectedNode){
    
    for(int i = 0; i < c.length; i++){
        if(!visited[node][i] && !visited[i][node]){
            visited[connectedNode][i] = true;
            visited[i][connectedNode] = true;
            dfs(c,node1,node2)
        }
    }
    
    }
    
    
    
    */
    public int solution(int n, int[][] c) {
        
        visited = new boolean[n][n];
        int counter = 0;
        int standAloneCounter = 0;
    for(int i =0; i < n; i++){
        boolean standAloneFlag = true;
        for(int j = 0; j < n; j++){
            if(i==j) visited[i][j] = true;
            else if(c[i][j] != 0){
                standAloneFlag = false;
            }
        }
        if(standAloneFlag) standAloneCounter++;
    }
    
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(c[i][j]==1 && !visited[i][j]) {
                System.out.println("before start dfs");
                System.out.println("i, j" + i + " "+ j);
            dfs(c,j,i);
            counter++;
        }
    }
    }
        
        return counter + standAloneCounter;
    }
        
    public void dfs(int[][] c , int node, int connectedNode){
            for(int i = 0; i < c.length; i++){
        if(!visited[node][i] && c[node][i] == 1){
            visited[node][i] = true;
            visited[i][node] = true;
            visited[connectedNode][i] = true;
            visited[i][connectedNode] = true;
            dfs(c,i,connectedNode);
        }
    }
    }
}