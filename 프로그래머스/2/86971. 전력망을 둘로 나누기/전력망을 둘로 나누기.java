class Solution {
    //구현 방법: 잘랐다는 것을 다시 remove한 후 add한 다면 위치가 달라짐
    private boolean[] visited;
    private int connectedWire = 0;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] w) {
    
    
        for(int i = 0; i < w.length; i++){
            int startNode;
            if(i == 0) startNode = w[1][0];
            else startNode = w[0][0];
            connectedWire = 0;
            visited = new boolean[w.length];
            dfs(startNode, i,w);
            int connectedNode =  connectedWire + 1;
            int anotherPartNode = n - connectedNode;
            int difference = Math.abs(connectedNode - anotherPartNode); 

            answer = Math.min(answer, difference);
        }
        
        return answer;
    }
    
    
    
    public void dfs(int node, int cutWire, int[][] w){
        for(int i = 0; i < w.length; i++){
            int startNode = w[i][0];
            int endNode = w[i][1];
            if(cutWire == i) continue;
            if(!visited[i] && (node == startNode || node == endNode)){
                connectedWire++;
                visited[i] = true;
                dfs(startNode, cutWire, w);
                dfs(endNode, cutWire, w);
            }
        }
    }
}