class Solution {
    private boolean[] visited;
//실수했던 부분 : 자기 자신을 포함하지 않기 위해 continue를 했지만 그렇게 하지 않아도, 자기 자신은 이후의 다른 것과 연결된 것이 없기에 1개로 포함된다. 즉 구현 단계에서 구현의 미스이다.
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int counter = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // 방문하지 않은 노드라면
                visited[i] = true;
                dfs(i, computers, n);
                counter++;  // 네트워크 하나가 완성되었으므로 증가
            }
        }
        
        return counter;
    }

    private void dfs(int node, int[][] computers, int n) {
        
        
        for (int i = 0; i < n; i++) {
            if (computers[i][node] == 1 && !visited[i]) {  // 연결되어 있고 방문하지 않은 경우
                visited[node] = true;
                dfs(i, computers, n);
                
            }
        }
    }
}
