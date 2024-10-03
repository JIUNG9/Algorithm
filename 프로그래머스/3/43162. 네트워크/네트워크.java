class Solution {
    private int answer = 0;
    private boolean[] visited;
    public int solution(int n, int[][] c) {
        int len = c.length;
        visited = new boolean[len];
        int counter = 0;
        //dfs, graph, traversal
        //heap -> visited array, answer(개수)
        //stack -> 현재 노드 idx, 
        //action
        //연결된 네트워크는 하나의 네트워크로 구분하며 연결되어있지 않은 네트워크 또한 하나의 네트워크라고 칭한다.
        //모든 노드를 확인하며 연결된 노드를 찾는 문제이다. n번이 연결된 노드를 찾을 때  자기 자신을 제외한 노드 이외의 n번과 연결된 노드를 찾고 자기  타겟 노드를 방문처리를 한다. 방문처리가 되어있는 것은 다시 방문하지 않는다. 만약 연결된 노드가 존재한다면 연결된 노드가 또한 해당 노드와 연결된 노드가 존재한다면 방문처리를 하고 이때 연결된 모든 노드들을 1개의 네트워크라고 칭한다. 향후 하나의 네트워크로 여겨진 노드들은 이후에 다시 순회하지 않는다. 이때 방문처리가 되지 않은 것의 개수와 answer의 개수의 합이 정답이다.

        
        //만약 두개의 노드가 연결되어있다면
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c.length; j++){
                if(i!=j && c[i][j] == c[j][i] && !visited[j]){
                    visited[j] = true;
                    answer++;
                    dfs(j,c);
                }
            }
        }
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]) counter++;
        }
        return counter+answer;

    }
    public void dfs(int target, int[][] c){
        for(int i = 0; i < c.length; i++){
                if((c[i][target] == 1 || c[target][i] == 1) && !visited[i]){
                    visited[i] = true;
                    dfs(i,c);
                    dfs(target,c);
        }
    }
}
}