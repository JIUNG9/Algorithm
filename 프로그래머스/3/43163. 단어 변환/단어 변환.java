class Solution {
    private boolean[] visited;
    private int answer = Integer.MAX_VALUE; 
    
    public int solution(String b, String t, String[] w) {
        int len = w.length;
        visited = new boolean[len];     
        dfs(b,t,0,w);
        return answer == Integer.MAX_VALUE ? 0 : answer;
        
    }
    public void dfs(String current, String target, int counter, String[] w){
        
        
         if(current.equals(target)){
                answer = Math.min(answer, counter);
        }
        for(int i =0; i < w.length; i++){

            if(!visited[i] && isDifferentOnlyOneWord(current,w[i])){
                visited[i] = true;
                dfs(w[i],target,counter+1,w);
                visited[i] = false;
            }
        }
        
        
    }
    public boolean isDifferentOnlyOneWord(String s1, String s2){
        int differentCounter = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)) differentCounter++;
            if(differentCounter >= 2) return false; 
        }
        return true;
    }
}