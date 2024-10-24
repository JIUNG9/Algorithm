class Solution {
    private int answer = Integer.MAX_VALUE;
    private int connectedLen = 0;
    private boolean[] visited;
    public int solution(int n, int[][] wires) {
        //모든 간선을 하나씩 끊으면서, 매 라운드마다 끊어진 간선은 더 이상 고려하지 않고, 끊어진 것을 제외한 연결된 간선의 개수를 구한다. 이때 해당 간선은 한 번씩만 방문한다. 간선의 개수에서 끊어진 것을 제외한 것이 연결된 개수의 절댓값의 차이가 가장 작은 것을 정답으로 저장한다.
        
        // implementation : dfs를 할 때, stack 연결된 노드 !!heap : 현재 노드를 끊을 때 연결된 간선의 개수!! 그리고 visited, Node는 양방향이다.
        // *주의 간선의 개수가 아니라 노드의 개수임*
        
        for(int i = 0; i < wires.length; i++){
            connectedLen = 0;
            visited = new boolean[wires.length];
            if(i == 0) dfs(i, wires,wires[1][0]);
            else{
                
                dfs(i, wires, wires[0][0]);
            }
            answer =Math.min(answer , Math.abs((n - (connectedLen + 1) - (connectedLen+1))));
        }
        return answer;
        
        
    }
    public void dfs(int cutIdx, int[][] wires, int connectedNode){
        for(int i = 0; i < wires.length; i++){
            if(cutIdx == i) continue;
            else if(!visited[i]){
                if(wires[i][0] == connectedNode) {
                    connectedLen++;
                    visited[i] = true;
                    dfs(cutIdx, wires, wires[i][1]);
                }
                else if(wires[i][1] == connectedNode){
                    connectedLen++;
                    visited[i] = true;
                    dfs(cutIdx, wires, wires[i][0]);
                }
            }
        }
        
    }
    
}