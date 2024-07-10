class Solution {
    private boolean[] visited;
    private int answer = -1;
    public int solution(int k, int[][] dungeons) {
        int len = dungeons.length;
        visited = new boolean[len];
        
        dfs(k,dungeons,0);
        return answer;
    }
    public void dfs(int current, int[][] d, int counter){
        
        for(int i = 0; i < d.length; i++){
            int requirement = d[i][0];
            int fee = d[i][1];
            if(current >= requirement && !visited[i]){
                visited[i] = true;
                dfs(current-fee, d, counter+1);
                visited[i] = false;
            }
            else{
                answer = Math.max(answer, counter);
            }
        }
        
        
    }
}