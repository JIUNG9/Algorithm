class Solution {
    private boolean[] visited;
    private int answer = 0;
    public int solution(int[] n, int t) {
        visited = new boolean[n.length];
        dfs(n,0,0,t);
        return answer;
        
    }
    
    public void dfs(int[] n, int current, int currentLen,int t){
        if(current == t && currentLen == n.length){
          answer++;
            return;
        } 
        if(currentLen < n.length){
            dfs(n, current + n[currentLen], currentLen + 1, t);
            dfs(n,current - n[currentLen], currentLen + 1, t);
        }
        
    }

}