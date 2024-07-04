class Solution {
    private boolean[] visited;
    private int counter = 0;
    public int solution(int n, int[][] c) {
        visited = new boolean[n];
        for(int i = 0; i < c.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,c);
                counter++;
            }
        }
        return counter;
        
    }
    public void dfs(int currentNode, int[][] c){
        
        for(int i = 0; i < c.length; i++){
                if(currentNode != i){
                    if( c[i][currentNode] == 1 &&  !visited[i]){
                        visited[i] = true;
                        dfs(i,c);
                    }
            }
        }
        
    }
}